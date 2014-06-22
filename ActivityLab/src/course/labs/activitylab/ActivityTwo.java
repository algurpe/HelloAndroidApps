package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

	// TODO:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called
	private static int mCreate;
	private static int mRestart;
	private static int mStart;
	private static int mResume;


	// TODO: Create variables for each of the TextViews, called
        // mTvCreate, etc. 
	TextView mTvCreate;
	TextView mTvRestart;
	TextView mTvStart;
	TextView mTvResume;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);
		mTvCreate = (TextView) findViewById(R.id.create);
		mTvRestart = (TextView) findViewById(R.id.restart);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvResume = (TextView) findViewById(R.id.resume);

		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO:
				// This function closes Activity Two
				// Hint: use Context's finish() method
				finish();
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			savedInstanceState.getInt("mCreate", mCreate);
			savedInstanceState.getInt("mRestart", mRestart);
			savedInstanceState.getInt("mStart", mStart);
			savedInstanceState.getInt("mResume", mResume);
		}

		// Emit toast
		Toast toast_c = Toast.makeText(getApplicationContext(), "Entered the onCreate() method", Toast.LENGTH_SHORT);
		toast_c.show();


		// TODO:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
		mCreate++;
		displayCounts();
	}

	// Lifecycle callback overrides

		@Override
		public void onStart() {
			super.onStart();

			// Emit toast
			Toast toast_s = Toast.makeText(getApplicationContext(), "Entered the onStart() method", Toast.LENGTH_SHORT);
			toast_s.show();

			// TODO:
			// Update the appropriate count variable
			// Update the user interface
			mStart++;
			displayCounts();
		}

		@Override
		public void onResume() {
			super.onResume();

			// Emit toast
			Toast toast_re = Toast.makeText(getApplicationContext(), "Entered the onResume() method", Toast.LENGTH_SHORT);
			toast_re.show();

			// TODO:
			// Update the appropriate count variable
			// Update the user interface
			mResume++;
			displayCounts();
		}

		@Override
		public void onPause() {
			super.onPause();
			
			// Emit toast
			Toast toast_p = Toast.makeText(getApplicationContext(), "Entered the onPause() method", Toast.LENGTH_SHORT);
			toast_p.show();
		}

		@Override
		public void onStop() {
			super.onStop();
			
			// Emit toast
			Toast toast_st = Toast.makeText(getApplicationContext(), "Entered the onStop() method", Toast.LENGTH_SHORT);
			toast_st.show();
		}

		@Override
		public void onRestart() {
			super.onRestart();

			// Emit toast
			Toast toast_r = Toast.makeText(getApplicationContext(), "Entered the onRestart() method", Toast.LENGTH_SHORT);
			toast_r.show();
					
			// TODO:
			// Update the appropriate count variable
			// Update the user interface
			mRestart++;
			displayCounts();
		}

		@Override
		public void onDestroy() {
			super.onDestroy();

			// Emit toast
			Toast toast_d = Toast.makeText(getApplicationContext(), "Entered the onDestroy() method", Toast.LENGTH_SHORT);
			toast_d.show();

		}

		@Override
		public void onSaveInstanceState(Bundle savedInstanceState) {
			// TODO:
			// Save state information with a collection of key-value pairs
			// 4 lines of code, one for every count variable
			savedInstanceState.putInt("mCreate", mCreate);
			savedInstanceState.putInt("mRestart", mRestart);
			savedInstanceState.putInt("mStart", mStart);
			savedInstanceState.putInt("mResume", mResume);
		}

	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}
