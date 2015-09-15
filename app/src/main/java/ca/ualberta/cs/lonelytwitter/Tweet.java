package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Joshua on 2015-09-14.
 */
public abstract class Tweet {

    protected String text;

    private Date date;

    public ArrayList<Mood> getMoods() {
        return moods;
    }

    public void setMoods(ArrayList<Mood> moods) {
        this.moods = moods;
    }

    public void insertMoods(Mood mood){
        this.moods.add(mood);
    }

    private ArrayList<Mood> moods;


    public Tweet(String tweet, Date date){
            text = tweet;
            this.date = date;
            this.moods = new ArrayList<Mood>();
    }

    public Tweet(String text){
        this.text = text;
        date = new Date();
        this.moods = new ArrayList<Mood>();
    }

    public String getText() {
        return text;
    }

    public void setText(String text)  throws IOException {

         if( text.length() <= 140) {
             this.text = text;
         }

         else { throw new IOException("Tweet was too long!");}

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isImportant();
}
