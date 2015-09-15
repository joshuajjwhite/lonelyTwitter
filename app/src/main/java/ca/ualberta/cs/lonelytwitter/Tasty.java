package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Joshua on 2015-09-14.
 */
public class Tasty extends Mood {

    public Tasty(Date date){
        super(date);
    }

    public Tasty(){
        super();
    }

    @Override
    public String moodMessage() {
        return "Hair on Fleek and my outfit is krispy";
    }
}
