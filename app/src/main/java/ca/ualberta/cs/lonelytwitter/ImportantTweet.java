package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Joshua on 2015-09-14.
 */
public class ImportantTweet extends Tweet {

    public ImportantTweet(String tweet, Date date){
        super(tweet, date);
    }

    public ImportantTweet(String text) {
        super(text);
        this.setText(text);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
