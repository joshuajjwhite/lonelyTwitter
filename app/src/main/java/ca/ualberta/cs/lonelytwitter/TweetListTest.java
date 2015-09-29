package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;

/**
 * Created by Joshua on 2015-09-28.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.TweetListTest.class);
    }

    public void testAddTweet(){
        try{
            TweetList tweets = new TweetList();
            tweets.add(new NormalTweet("Hello"));
            tweets.add(new NormalTweet("Hello"));}
        catch(IllegalArgumentException e)
            {assertEquals("You tried adding a duplicate tweet...", e.getMessage());}
    }

    public void testGetTweets(){
        TweetList tweets = new TweetList();

        Tweet tweet1 = new NormalTweet("Hello");
        Tweet tweet2 = new NormalTweet("Hello1");
        Tweet tweet3 = new NormalTweet("Hello2");
        Tweet tweet4 = new NormalTweet("Hello3");

        tweets.add(tweet1);
        tweets.add(tweet2);
        tweets.add(tweet3);
        tweets.add(tweet4);

        ArrayList<Tweet> al = new ArrayList<Tweet>();
        al.add(tweet1);
        al.add(tweet2);
        al.add(tweet3);
        al.add(tweet4);


        assertEquals(tweets.getTweets(),al);}

    public void testHasTweets(){
        TweetList tweets = new TweetList();

        Tweet tweet1 = new NormalTweet("Hello");
        Tweet tweet2 = new NormalTweet("Hello1");
        Tweet tweet3 = new NormalTweet("Hello2");
        Tweet tweet4 = new NormalTweet("Hello3");

        tweets.add(tweet1);
        tweets.add(tweet2);
        tweets.add(tweet3);
        tweets.add(tweet4);

        assertTrue(tweets.hasTweet(tweet1));
        assertTrue(tweets.hasTweet(tweet2));
        assertTrue(tweets.hasTweet(tweet3));
        assertTrue(tweets.hasTweet(tweet4));}



    public void testCount(){
        TweetList tweets = new TweetList();

        assertTrue(tweets.getCount()==0);

        Tweet tweet1 = new NormalTweet("Hello");
        Tweet tweet2 = new NormalTweet("Hello1");
        Tweet tweet3 = new NormalTweet("Hello2");
        Tweet tweet4 = new NormalTweet("Hello3");

        tweets.add(tweet1);
        assertTrue(tweets.getCount() == 1);
        tweets.add(tweet2);
        assertTrue(tweets.getCount() == 2);
        tweets.add(tweet3);
        assertTrue(tweets.getCount() == 3);
        tweets.add(tweet4);
        assertTrue(tweets.getCount() == 4);


        tweets.delete(tweet1);
        assertTrue(tweets.getCount() == 3);
        tweets.delete(tweet2);
        assertTrue(tweets.getCount() == 2);
        tweets.delete(tweet3);
        assertTrue(tweets.getCount() == 1);
        tweets.delete(tweet4);
        assertTrue(tweets.getCount()==0);


    }
}

