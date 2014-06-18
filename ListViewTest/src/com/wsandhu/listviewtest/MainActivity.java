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

public class MainActivity extends Activity implements AdapterView.OnItemClickListener{
	
	ListView list;
	String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Wasimday", "Sunday"}; // the string array
	
	@Override
	// The onCreate method
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// the ListView takes the data from the data source (the array)
		list = (ListView) findViewById(android.R.id.list);
		
		// the array adapter takes the data from the array and changes it into a view
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, days);
		
		// Set the adapter to the ListView
		list.setAdapter(adapter);
		
		// Handles what happens when an item in the ListView is clicked
		list.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		// The textviews in the list
		TextView temp = (TextView) view;
		
		// Displays a toast that echoes what TextView was clicked i.e. tap "Monday" and a toast that says "Monday" will appear.
		Toast.makeText(this, temp.getText(), Toast.LENGTH_SHORT).show();
	}
}
