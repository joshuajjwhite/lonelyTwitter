package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Joshua on 2015-09-14.
 */
public class HungryForLove extends Mood {

    public HungryForLove(Date date){
        super(date);
    }

    public HungryForLove(){
        super();
    }

    @Override
    public String moodMessage() {
        return "I can feel the tremble when we touch";
    }
}
