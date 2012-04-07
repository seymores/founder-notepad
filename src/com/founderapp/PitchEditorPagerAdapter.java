package com.founderapp;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;

import com.founderapp.domain.Pitch;


public class PitchEditorPagerAdapter extends FragmentPagerAdapter {

	
	private static final String TAG = "PitchEditorPagerAdapter";

	static int PAGER_SECTIONS = 12;
	
	private FragmentActivity context;
	private Pitch pitch;
	
	public PitchEditorPagerAdapter(FragmentActivity ctx, Pitch pitch) {
		super(ctx.getSupportFragmentManager());
		this.context = ctx;
		this.pitch = pitch;
	}
	
	@Override
	public int getCount() {
		return PAGER_SECTIONS;
	}

	@Override
	public Fragment getItem(int index) {
		//Log.d(TAG, " getItem: " + index);
		Fragment item = null;
		if (index == 0) {
			item = new PitchFragment(pitch);
		} else {
			String id = null;
			if (pitch != null) {
				id = pitch.getId();
			}
			item = new EditorFragment(id, index);
		}
		
		return item;
	}

}
