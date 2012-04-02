package com.founderapp;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.founderapp.domain.DomainHelper;
import com.founderapp.domain.Pitch;

/**
 * 
 * @author Teo Choong Ping
 * 
 */
public class PitchListActivity extends ListActivity {
	
	private static final String TAG = "FounderActivity";
	private FounderListAdapter adapter ;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		adapter = new FounderListAdapter(this);
		setListAdapter(adapter);
		
		getListView().setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Pitch p = (Pitch)adapter.getItem(position);
				Intent act = new Intent(PitchListActivity.this, PitchEditorActivity.class);
				Bundle b = new Bundle();

				Log.d(TAG, " * Click " + position + ", pitch=" + p);

				b.putSerializable("pitch", p);
				act.putExtras(b);
				startActivity(act);
			}
		});
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		List<Pitch> pitches = DomainHelper.loadPitches(this);
		adapter.setPitches(pitches);
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