package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Joshua on 2015-09-14.
 */
public class NormalTweet extends Tweet {

    public NormalTweet(String tweet, Date date){
        super(tweet,date);
    }

    public NormalTweet(String text){
        super(text);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
