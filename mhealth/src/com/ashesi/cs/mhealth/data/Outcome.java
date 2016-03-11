package com.ashesi.cs.mhealth.data;

/**
 * Created by george.assan on 09/03/2016.
 */
public class Outcome {

    private int id;
    private String outcome;

    public Outcome(int id, String outcome) {
        this.id = id;
        this.outcome = outcome;
    }

    public int getId() {
        return id;
    }

    public String getOutcome() {
        return outcome;
    }

    @Override
    public String toString(){
      return outcome;
    }
}
