package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity implements MyObserver {

	private static final String FILENAME = "file.sav"; //model
	private EditText bodyText; // view
	private LonelyTwitterActivity activity  = this;

	private ArrayList<Tweet> tweets; //model
	ArrayAdapter<Tweet> adapter; // controller
	private Button saveButton;
	private  EditText bodytext;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState); //view
		setContentView(R.layout.main); //view

		bodyText = (EditText) findViewById(R.id.body);
		saveButton = (Button) findViewById(R.id.save); //view
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList); //view

		oldTweetsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(activity, EditTweetActivity.class);
				intent.putExtra("Tweet", view.getId());
				startActivity(intent);
			}
		});

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK); //controller
				String text = bodyText.getText().toString(); //view
				tweets.add(new NormalTweet(text)); //model
				saveInFile(); //model
				adapter.notifyDataSetChanged(); //view



			}
		});



	}

	public EditText getBodyText(){
		return bodyText;
	}

	public Button getSaveButton(){
		return saveButton;
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart(); //view
		loadFromFile(); //model
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets); //controller

		oldTweetsList.setAdapter(adapter); //controller
	}



	private void loadFromFile() { //<--- From here
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			//Following line based on gson
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
			tweets = gson.fromJson(in, listType );

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(); //<--- to here should be model
		}

	}
	
	private void saveInFile() { // <-- From here to.....
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweets, writer);
			writer.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e); //<--- here is model
		}
	}

	public void myNotify(MyObservable observable) { //controller
		adapter.notifyDataSetChanged(); //controller
	}

	public ListView getOldTweetsList() {
		return oldTweetsList;
	}

	public void setOldTweetsList(ListView oldTweetsList) {
		this.oldTweetsList = oldTweetsList;
	}

	private ListView oldTweetsList; //view

	public ArrayList<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(ArrayList<Tweet> tweets) {
		this.tweets = tweets;
	}
}