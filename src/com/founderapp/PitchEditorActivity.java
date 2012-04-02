package com.founderapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.PitchEditorPagerAdapter;
import com.founderapp.domain.Pitch;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;


public class PitchEditorActivity extends Activity {
	
	private Pitch pitch;
	ViewPager pager;
	PitchEditorPagerAdapter pagerAdapter;
	PageIndicator indicator;
	
	@Override
	public void onCreate(Bundle bundleInstance) {
		super.onCreate(bundleInstance);
		setContentView(R.layout.pitch_editor_activity);
		pager = (ViewPager)findViewById(R.id.view_pager);
		pagerAdapter = new PitchEditorPagerAdapter(this);
		pager.setAdapter(pagerAdapter);
		indicator = (CirclePageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);
	}
	
}
