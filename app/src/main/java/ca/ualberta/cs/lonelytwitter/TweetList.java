package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by Joshua on 2015-09-28.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) throws IllegalArgumentException {
        if (!tweets.contains(tweet)) {
            tweets.add(tweet);
        } else {
            throw new IllegalArgumentException("You tried adding a duplicate tweet...");
        }
    }

    public void delete(Tweet tweet) {
        if (tweets.contains(tweet)) {
            tweets.remove(tweet);

    }
}

    public boolean hasTweet(Tweet tweet){
        if(tweets.contains(tweet)){ return true;}
        else{return false;}
    }

    public int getCount(){
        return this.tweets.size();
    }

    public ArrayList<Tweet> getTweets(){
        return this.tweets;
    }
}
