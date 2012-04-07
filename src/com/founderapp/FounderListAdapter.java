package com.founderapp;

import java.util.Collections;
import java.util.List;

import org.ocpsoft.pretty.time.PrettyTime;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.founderapp.domain.Pitch;


public class FounderListAdapter extends BaseAdapter {

	private List<Pitch> pitches = Collections.emptyList();
	static PrettyTime prettyTime = new PrettyTime();
	
	private Context context;
	private static Typeface titleFont; //Typeface.createFromAsset(getAssets(), "Chantelli_Antiqua.ttf");  
	private static Typeface bodyFont;
	
	public FounderListAdapter(Context ctx) {
		super();
		this.context = ctx;
		titleFont = Typeface.createFromAsset(ctx.getAssets(), "Aller_Rg.ttf");
		bodyFont = Typeface.createFromAsset(ctx.getAssets(), "Aller_Lt.ttf");
	}
	
	public void setPitches(List<Pitch> _pitches) {
		
		if (_pitches == null) return;
		this.pitches = _pitches;
		notifyDataSetChanged();
	}

	public void setContext(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return pitches.size();
	}

	@Override
	public Object getItem(int position) {
		return pitches.get(position);
	}

	@Override
	public long getItemId(int position) {
		return pitches.get(position).hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.row, null);
			holder = new ViewHolder();
			holder.name = (TextView)convertView.findViewById(R.id.name);
			//holder.name.setTypeface(titleFont);
			
			holder.extraText = (TextView)convertView.findViewById(R.id.extraText);
			//holder.extraText.setTypeface(bodyFont);
			holder.lastUpdate = (TextView)convertView.findViewById(R.id.lastUpdate);
			//holder.statusIndicatorView = convertView.findViewById(R.id.row_status_indicator);
			convertView.setTag(holder);
		}
		holder = (ViewHolder)convertView.getTag();
		
		Pitch pitch = pitches.get(position);
		holder.name.setText(pitch.getCompanyName());
		
		if (pitch.hasTask()) {
			holder.name.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.task_indicator, 0);
		} else {
			holder.name.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
		}
		
		String desc = pitch.getDeveloping();
		if (desc == null || "".equals(desc.trim())) {
			holder.extraText.setVisibility(View.GONE);
		} else {
			holder.extraText.setText(desc);
			holder.extraText.setVisibility(View.VISIBLE);
		}
		holder.lastUpdate.setText( 
				prettyTime.format( pitch.getLastUpdated() ));
		
		return convertView;
	}

	static class ViewHolder {
		TextView name;
		TextView extraText;
		TextView lastUpdate;
		View statusIndicatorView;
	}
}
