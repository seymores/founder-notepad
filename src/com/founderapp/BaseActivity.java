package com.founderapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public abstract class BaseActivity extends Activity {
	
	static final String TAG = "BaseActivity";
	
	static String[] titles;// = getResources().getStringArray(R.array.sections);
	static String[] descriptions;// = getResources().getStringArray(R.array.descriptions);
	static String[] codes;// = getResources().getStringArray(R.array.codes);
	static final int[] icons = {R.drawable.content_new_attachment,
								R.drawable.rating_favorite,
								R.drawable.av_make_available_offline,
								R.drawable.device_access_bightness_low,
								R.drawable.device_access_flash_on,
								R.drawable.hardware_phone,
								R.drawable.device_access_network_cell,
								R.drawable.collections_labels,
								R.drawable.device_access_data_usage,
								R.drawable.social_add_group,
								R.drawable.collections_view_as_grid,
								R.drawable.collections_view_as_list
								};
	
	int editorIndex = 0; 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		editorIndex = getIntent().getIntExtra("editorIndex", 0);
		
		titles = getResources().getStringArray(R.array.sections);
		descriptions = getResources().getStringArray(R.array.descriptions);
		codes = getResources().getStringArray(R.array.codes);
		
		setContentView(R.layout.editor_activity);

		setupNavigation();
		setupTitleAndDescription();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		getActionBar().setSelectedNavigationItem( editorIndex );
	}

	private void setupTitleAndDescription() {
		TextView title = (TextView)findViewById(R.id.title);
		TextView description = (TextView)findViewById(R.id.extraText);
		
		if (title == null) return;
		
		String editorTitle = titles[editorIndex];
		String desc = descriptions[editorIndex];
		
		title.setText(editorTitle);
		int icon = icons[editorIndex];
		title.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0);
		
		if ("_".equalsIgnoreCase(desc)) {
			description.setVisibility(View.GONE);
		} else {
			description.setText(desc);
			description.setVisibility(View.VISIBLE);
		}
	}

	private void setupNavigation() {
		SpinnerAdapter adapter = ArrayAdapter.createFromResource(this, 
	    										R.array.sections, 
	    										android.R.layout.simple_spinner_dropdown_item);
		ActionBar bar = getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

		bar.setDisplayHomeAsUpEnabled(true);
		bar.setDisplayShowTitleEnabled(false);
		bar.setListNavigationCallbacks(adapter, naviListener);

	}
	
	private ActionBar.OnNavigationListener naviListener = new ActionBar.OnNavigationListener() {

		@Override
		public boolean onNavigationItemSelected(int itemPosition, long itemId) {
			Log.d(TAG, " Selected: " + itemPosition + " editorIndex >> "
					+ editorIndex);
			if (itemPosition == 0 && itemPosition == editorIndex)
				return true;

			if (editorIndex == 0 && itemPosition > 0) {
				Intent next = new Intent(BaseActivity.this,
						EditorActivity.class);
				next.putExtra("editorIndex", itemPosition);
				// next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(next);
				return true;
			}

			if (itemPosition == 0) {
				finish();
				return true;
			}

			editorIndex = itemPosition;
			setupTitleAndDescription();

			return false;
		}
		
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.note_menus, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.next_note:
			nextNoteAction();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}

	}
	
	protected void nextNoteAction() {
//		Intent next = new Intent(this, EditorActivity.class);
//		int nextIndex = editorIndex + 1;
//		if (nextIndex >= codes.length) {
//			// Display toast
//			return;
//		}
//		
//		if (nextIndex >= codes.length) nextIndex = 0;
//		next.putExtra("editorIndex", nextIndex);
//		startActivity(next);
		
		int nextIndex = editorIndex + 1;
		if (nextIndex >= 11) nextIndex = editorIndex;
		getActionBar().setSelectedNavigationItem(nextIndex);
		
	}
	
	
}
