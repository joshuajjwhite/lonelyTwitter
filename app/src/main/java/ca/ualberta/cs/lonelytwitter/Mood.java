package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Joshua on 2015-09-14.
 */
public abstract class Mood {

    Date date;

    public Mood(Date date){

        this.date = date;
    }

    public Mood(){
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String moodMessage();



}
