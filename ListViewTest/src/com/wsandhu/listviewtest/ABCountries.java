package com.wsandhu.listviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;
import android.widget.AdapterView;

public class ABCountries extends Activity implements AdapterView.OnItemClickListener {
	
	ListView list;
	// The string array -- sorry for so many lines of "code"
	String[] countries = {"Afghanistan",
			"Akrotiri",
			"Albania",
			"Algeria",
			"American Samoa",
			"Andorra",
			"Angola",
			"Anguilla",
			"Antarctica",
			"Antigua and Barbuda",
			"Argentina",
			"Armenia",
			"Aruba",
			"Ashmore and Cartier Islands",
			"Australia",
			"Austria",
			"Azerbaijan",
			"Bahamas, The",
			"Bahrain",
			"Bangladesh",
			"Barbados",
			"Bassas da India",
			"Belarus",
			"Belgium",
			"Belize",
			"Benin",
			"Bermuda",
			"Bhutan",
			"Bolivia",
			"Bosnia and Herzegovina",
			"Botswana",
			"Bouvet Island",
			"Brazil",
			"British Indian Ocean Territory",
			"British Virgin Islands",
			"Brunei",
			"Bulgaria",
			"Burkina Faso",
			"Burma",
			"Burundi",
			"Cambodia",
			"Cameroon",
			"Canada",
			"Cape Verde",
			"Cayman Islands",
			"Central African Republic",
			"Chad",
			"Chile",
			"China",
			"Christmas Island",
			"Clipperton Island",
			"Cocos (Keeling) Islands",
			"Colombia",
			"Comoros",
			"Congo, Democratic Republic of the",
			"Congo, Republic of the",
			"Cook Islands",
			"Coral Sea Islands",
			"Costa Rica",
			"Cote d'Ivoire",
			"Croatia",
			"Cuba",
			"Cyprus",
			"Czech Republic",};
	
	@Override
	// The onCreate method
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// the ListView takes the data from the data source (the array)
		list = (ListView) findViewById(R.id.listview);
		
		// the array adapter takes the data from the array and changes it into a view
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
		
		// Set the adapter to the ListView
		list.setAdapter(adapter);
		
		// Handles what happens when an item in the ListView is clicked
		list.setOnItemClickListener(this);
		
		// Attach the listener to the AdapterView onCreate
		list.setOnScrollListener(new InfiniteScrollListener(10) {
		    @Override
		    public void loadMore(int page, int totalItemsCount) {
		        adapter.notifyDataSetChanged();
		    }
		});
	}
	
	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position,
			long id) {
		
		// The textviews in the list
		TextView temp = (TextView) view;
		
		// Displays a toast that echoes what TextView was clicked i.e. tap "Cuba" and a toast that says "Cuba" will appear.
		Toast.makeText(this, temp.getText(), Toast.LENGTH_SHORT).show();
	}
	
	/* Added these other methods for learning purposes. */
	
	@Override
	protected void onStart() {
		super.onStart();
	}


	@Override
	protected void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
