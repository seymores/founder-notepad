package com.founderapp;

import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.founderapp.domain.Pitch;


public class FounderListAdapter extends BaseAdapter {

	private List<Pitch> pitches = Collections.emptyList();
	private Context context;
	
	public FounderListAdapter(Context ctx) {
		super();
		this.context = ctx;
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
			convertView = LayoutInflater.from(context).inflate(R.layout.row, parent);
			holder = new ViewHolder();
			holder.name = (TextView)convertView.findViewById(R.id.name);
			holder.extraText = (TextView)convertView.findViewById(R.id.extraText);
			holder.lastUpdate = (TextView)convertView.findViewById(R.id.lastUpdate);
			holder.statusIndicatorView = convertView.findViewById(R.id.row_status_indicator);
			convertView.setTag(holder);
		}
		holder = (ViewHolder)convertView.getTag();
		
		Pitch pitch = pitches.get(position);
		holder.name.setText(pitch.getCompanyName());
		holder.extraText.setText(pitch.getOffering());
		holder.lastUpdate.setText( 
				BaseActivity.prettyTime.format( pitch.getLastUpdated() ));
		
		return convertView;
	}

	static class ViewHolder {
		TextView name;
		TextView extraText;
		TextView lastUpdate;
		View statusIndicatorView;
	}
}
