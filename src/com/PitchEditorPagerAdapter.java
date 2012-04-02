package com;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.founderapp.R;

public class PitchEditorPagerAdapter extends PagerAdapter {

	
	static int PAGER_SECTIONS = 12;
	
	private Context context;
	
	public PitchEditorPagerAdapter(Context ctx) {
		this.context = ctx;
		
	}
	
	@Override
	public int getCount() {
		return PAGER_SECTIONS;
	}
	
    public Object instantiateItem(View collection, int position) {
    	LayoutInflater inflater = LayoutInflater.from(context);
    
    	View view = null;
    	if (position == 0) {
    		view = inflater.inflate(R.layout.new_note, null);
    	} else {
    		view = inflater.inflate(R.layout.editor_activity, null);
    	}
    	
        ((ViewPager) collection).addView(view, 0);

    	return view;
    }

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == ((View) arg1);
	}
	
    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView((View) arg2);
    }


}
