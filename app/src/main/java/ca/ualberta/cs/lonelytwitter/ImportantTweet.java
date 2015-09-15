package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Joshua on 2015-09-14.
 */
public class ImportantTweet extends Tweet implements Tweetable {

    public ImportantTweet(String tweet, Date date){
        super(tweet, date);
    }

    public ImportantTweet(String text) throws IOException{
        super(text);
        this.setText(text);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
