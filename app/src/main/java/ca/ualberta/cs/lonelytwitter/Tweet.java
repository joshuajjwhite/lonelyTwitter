package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Joshua on 2015-09-14.
 */
public abstract class Tweet {

    protected String text;

    private Date date;


    public Tweet(String tweet, Date date){
            text = tweet;
            this.date = date;


    }

    public Tweet(String text){
        this.text = text;
        date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {

         if( text.length() <= 140) {
             this.text = text;
         }

         else { throw new IllegalArgumentException("Tweet was too long!");}

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isImportant();
}
