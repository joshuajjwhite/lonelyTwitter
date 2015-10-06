package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Observer;

/**
 * Created by Joshua on 2015-09-28.
 */
public class TweetList implements MyObservable, MyObserver {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    public void add(Tweet tweet) throws IllegalArgumentException {
        if (!tweets.contains(tweet)) {
            tweets.add(tweet);
            notifyAllObservers();
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

    public void notifyAllObservers(){
        for(MyObserver observer: observers){
            observer.myNotify(this);
        }
    }

    public void addObserver(MyObserver observer){
        observers.add(observer);
    }

    public void myNotify(MyObservable observable) {
        notifyAllObservers();
    }
}
