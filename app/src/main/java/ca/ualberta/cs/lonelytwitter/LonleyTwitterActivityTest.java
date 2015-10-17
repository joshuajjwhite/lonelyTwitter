package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by Joshua on 2015-10-16.
 */
public class LonleyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private EditText bodyText;
    private Button savebutton;
    private ListView oldTweetsList;

    public LonleyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonleyTwitterActivityTest.class);}

        public void testStart() throws Exception{

            Activity activity = getActivity();
    }

    public void testEditTweet() {
        LonelyTwitterActivity activity = (LonelyTwitterActivity) getActivity();
        activity.getTweets().clear();


        final String tweetText = "Hello!";
        bodyText = activity.getBodyText();

        activity.runOnUiThread((new Runnable() {
            public void run() {
                bodyText.setText(tweetText);
            }
        }));

        getInstrumentation().waitForIdleSync();
        savebutton = activity.getSaveButton();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                savebutton.performClick();
            }
        });

        getInstrumentation().waitForIdleSync();
        oldTweetsList = activity.getOldTweetsList();
        Tweet newestTweet = (Tweet) oldTweetsList.getItemAtPosition(0);
        bodyText.setText(tweetText);

        assertEquals(tweetText, newestTweet.getText());


        // Set up an ActivityMonitor
        Instrumentation.ActivityMonitor receiverActivityMonitor =
                getInstrumentation().addMonitor(EditTweetActivity.class.getName(),
                        null, false);

        activity.runOnUiThread(new Runnable() {
            public void run() {
                View v = oldTweetsList.getChildAt(0);
                oldTweetsList.performItemClick(v, 0, v.getId());
            }
        });


        EditTweetActivity receiverActivity = (EditTweetActivity)
                receiverActivityMonitor.waitForActivityWithTimeout(1000);
        assertNotNull("ReceiverActivity is null", receiverActivity);
        assertEquals("Monitor for ReceiverActivity has not been called",
                1, receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type",
                EditTweetActivity.class, receiverActivity.getClass());

    // Remove the ActivityMonitor
        getInstrumentation().removeMonitor(receiverActivityMonitor);



        getInstrumentation().waitForIdleSync();

        //test that the tweet editor starts with the correct tweet

        //test that we can edit tweets

        //test taht we can push a save button for the edited tweet

        //test that the modified tweet is in the tweet list

        receiverActivity.finish();

    }
}
