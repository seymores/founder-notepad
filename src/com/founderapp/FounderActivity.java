package com.founderapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * 
 * @author Teo Choong Ping
 * 
 */
public class FounderActivity extends ListActivity {
	
	private static final String TAG = "FounderActivity";
	private FounderListAdapter adapter ;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		adapter = new FounderListAdapter(this);
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.add_new:
			startActivity(new Intent(this, PitchActivity.class));
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}

	}

}