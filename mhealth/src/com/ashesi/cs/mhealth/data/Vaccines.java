package com.ashesi.cs.mhealth.data;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ashesi.cs.mhealth.DataClass;

public class Vaccines extends DataClass {
	public final static String VACCINE_ID="vaccine_id";
	public final static String VACCINE_NAME="vaccine_name";
	public final static String VACCINE_SCHEDULE="vaccine_schedule";
	public final static String TABLE_NAME_VACCINES="vaccines";
	public final static String VIEW_PENDING_VACCINES="view_pending_vaccines";
	public final static String SCHEDULED_ON="scheduled_on";
	
	public Vaccines(Context context){
		super(context);
	}
	
	public static String getCreateSQLString(){
		return "create table "+ TABLE_NAME_VACCINES +" ( "
				+VACCINE_ID + "  integer primary key , "
				+VACCINE_NAME+ " text, "
				+VACCINE_SCHEDULE+ " integer "
				+")";
		
	}
	 
	public static String getCreateViewPendingVaccinesSQLString(){
		return "create view "+ VIEW_PENDING_VACCINES +" as " 
				+ "	select " +CommunityMembers.COMMUNITY_MEMBER_ID 
				+ " , " +VACCINE_ID
				+ ", (julianday('now')-julianday("+ CommunityMembers.BIRTHDATE + "))-" 
				+ VACCINE_SCHEDULE +" as "+ SCHEDULED_ON
				+ " from " 
				+ CommunityMembers.TABLE_NAME_COMMUNITY_MEMBERS +"," +TABLE_NAME_VACCINES
				+ " where " + VACCINE_SCHEDULE+">=0";
	}
	
	public static String getInsertSQLString(int id,String vaccineName,int vaccineSchedule){
		return "insert into "+TABLE_NAME_VACCINES +"("
				+VACCINE_ID+", "
				+VACCINE_NAME+", "
				+VACCINE_SCHEDULE
				+") values("+
				+id+","
				+"'"+vaccineName +"'," +
				+vaccineSchedule+
				")";
				
	}

	public HttpURLConnection connect(){
		try{
			return super.connect("vaccineActions.php?cmd=1&deviceId="+mDeviceId);
		}catch(Exception ex){
			return null;
		}
	}
	
	/**
	 * clears every vaccine from the table
	 * @return
	 */
	public boolean clearTable(){
		try{
			db=getWritableDatabase();
			db.delete(TABLE_NAME_VACCINES, null, null);
			return true;
			
		}catch(Exception ex){
			return false;
		}
	}
	
	/**
	 * writes the data from server to local database 
	 * @param data
	 */
	public boolean processDownloadData(String data){
		try{
			JSONObject obj=new JSONObject(data);
			int result=obj.getInt("result");
			if(result==0){
				return false;
			}
						
			clearTable();
			JSONArray jsonArray=obj.getJSONArray("vaccines");
			for(int i=0;i<jsonArray.length();i++){
				obj=jsonArray.getJSONObject(i);
				int vaccineId=obj.getInt("id");
				String vaccineName=obj.getString("vaccineName");
				int vaccineSchedule=obj.getInt("schedule");
				
				addVaccine(vaccineId,vaccineName,vaccineSchedule);
			}
			return true;
		}catch(Exception ex){
			return false;
		}
		
	}
	
	/**
	 * adds vaccine to table
	 * @param vaccineId
	 * @param vaccineName
	 * @param vaccineSchedule
	 * @return
	 */
	public boolean addVaccine(int vaccineId, String vaccineName,int vaccineSchedule){
		try{
			db=getWritableDatabase();
			ContentValues cv=new ContentValues();
			cv.put(VACCINE_ID,vaccineId);
			cv.put(VACCINE_NAME, vaccineName);
			cv.put(VACCINE_SCHEDULE, vaccineSchedule);
			if(db.insertWithOnConflict(TABLE_NAME_VACCINES, null, cv, SQLiteDatabase.CONFLICT_REPLACE)<=0){
				return false;
			}
			close();
			return true;
		}catch(Exception ex){
			close();
			return false;
		}
	}
	
	/**
	 * fetch a vaccine information from current cursor and return it as object
	 * @return
	 */
	public Vaccine fetch(){
		try{
			if(cursor.isBeforeFirst()){
				cursor.moveToFirst();
			}
			int index=cursor.getColumnIndex(VACCINE_ID);
			int id=cursor.getInt(index);
			index=cursor.getColumnIndex(VACCINE_NAME);
			String vaccineName=cursor.getString(index);
			index=cursor.getColumnIndex(VACCINE_SCHEDULE);
			int schedule=cursor.getInt(index);
			cursor.moveToNext();
			return new Vaccine(id,vaccineName,schedule);
		}catch(Exception ex){
			close();
			return null;
		}
		
	}
	
	/**
	 * return all vaccines in the table
	 * @return
	 */
	public ArrayList<Vaccine> getVaccines(){
		ArrayList<Vaccine> list=new ArrayList<Vaccine>();
		String[] columns={VACCINE_ID,VACCINE_NAME,VACCINE_SCHEDULE};
		try
		{
			db=getReadableDatabase();
			cursor=db.query(TABLE_NAME_VACCINES, columns,null,null, null, null, null);
			cursor.moveToFirst();
			Vaccine v=fetch();
			while(v!=null){
				list.add(v);
				v=fetch();
			}
			close();
			return list;
		}catch(Exception ex){
			close();
			return list;
		}
	}
	
	/**
	 * return all vaccines in the table
	 * @return
	 */
	public ArrayList<Vaccine> getScheduledVaccines(){
		ArrayList<Vaccine> list=new ArrayList<Vaccine>();
		String[] columns={VACCINE_ID,VACCINE_NAME,VACCINE_SCHEDULE};
		try
		{
			String selector=VACCINE_SCHEDULE+">=0";
			db=getReadableDatabase();
			cursor=db.query(TABLE_NAME_VACCINES, columns,selector,null, null, null, null);
			cursor.moveToFirst();
			Vaccine v=fetch();
			while(v!=null){
				list.add(v);
				v=fetch();
			}
			close();
			return list;
		}catch(Exception ex){
			close();
			return list;
		}
	}
	
	/**
	 * return all vaccines in the table
	 * @return
	 */
	public ArrayList<Vaccine> getUnscheduledVaccines(){
		ArrayList<Vaccine> list=new ArrayList<Vaccine>();
		String[] columns={VACCINE_ID,VACCINE_NAME,VACCINE_SCHEDULE};
		try
		{
			String selector=VACCINE_SCHEDULE+"=-1";
			db=getReadableDatabase();
			cursor=db.query(TABLE_NAME_VACCINES, columns,selector,null, null, null, null);
			cursor.moveToFirst();
			Vaccine v=fetch();
			while(v!=null){
				list.add(v);
				v=fetch();
			}
			close();
			return list;
		}catch(Exception ex){
			close();
			return list;
		}
	}
	
	/**
	 * Returns number of people who are scheduled to be vaccinated particular vaccination
	 * @param past
	 * @param future
	 * @return
	 */
	public ArrayList<String> getVaccinesNeeded(int past,int future)
	{
		ArrayList<String> list=new ArrayList<String>();
		list.add("Vaccine");
		list.add("Number");
		try{
			db=getReadableDatabase();
			String strQuery="select "
					+Vaccines.VIEW_PENDING_VACCINES +"."+Vaccines.VACCINE_ID +","
					+Vaccines.VACCINE_NAME+","
					+"count(*) as NO_REC"
					+" from "+Vaccines.VIEW_PENDING_VACCINES 
					+" left join vaccines on "
					+Vaccines.VIEW_PENDING_VACCINES +"."+Vaccines.VACCINE_ID +"="+Vaccines.TABLE_NAME_VACCINES+"."+Vaccines.VACCINE_ID
					+" where ("
					+Vaccines.SCHEDULED_ON +"<=" +past +" AND "
					+Vaccines.SCHEDULED_ON +">="+future 
					+") group by "+Vaccines.VIEW_PENDING_VACCINES +"."+Vaccines.VACCINE_ID;
			cursor=db.rawQuery(strQuery, null);
			cursor.moveToFirst();
			int index=0;
			String str;
			int n=0;
			while(!cursor.isAfterLast()){
				index=cursor.getColumnIndex(Vaccines.VACCINE_NAME);
				str=cursor.getString(index);
				list.add(str);
				index=cursor.getColumnIndex("NO_REC");
				n=cursor.getInt(index);
				str=Integer.toString(n);
				list.add(str);
				cursor.moveToNext();
			}
			return list;
		}catch(Exception ex){
			return list;
		}
	}

	
}
