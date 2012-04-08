package com.founderapp;

import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.founderapp.domain.DomainHelper;
import com.founderapp.domain.EditorValue;
import com.founderapp.domain.Pitch;

public class EditorFragment extends Fragment implements OnFocusChangeListener {

	private static final String TAG = "EditorActivity";
	private EditText editorText;
	private TextView title;
	private TextView description;
	private String pitchId;
	private Integer editorIndex = 0;
	private int _textLength = 0;

	static String[] titles;
	static String[] descriptions;
	static String[] codes;

	static final int[] icons = { R.drawable.content_new_attachment,
			R.drawable.rating_favorite, R.drawable.av_make_available_offline,
			R.drawable.device_access_bightness_low,
			R.drawable.device_access_flash_on, R.drawable.hardware_phone,
			R.drawable.device_access_network_cell,
			R.drawable.collections_labels, R.drawable.device_access_data_usage,
			R.drawable.social_add_group, R.drawable.collections_view_as_grid,
			R.drawable.collections_view_as_list };

	public EditorFragment(String pitchId, Integer index) {
		super();
		this.pitchId = pitchId;
		this.editorIndex = index;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Log.d(TAG, " [0] *** pitch=" + pitchId + ", index=" + editorIndex) ;

		titles = getResources().getStringArray(R.array.sections);
		descriptions = getResources().getStringArray(R.array.descriptions);
		codes = getResources().getStringArray(R.array.codes);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater
				.inflate(R.layout.editor_fragment, container, false);
		editorText = (EditText) view.findViewById(R.id.editor_text);
		title = (TextView) view.findViewById(R.id.title);
		description = (TextView) view.findViewById(R.id.extraText);
//		editorText.setText("");
		editorText.setOnFocusChangeListener(this);
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		// String editorTitle = titles[editorIndex];
		// Log.d(TAG, "  >>> onResume index=> " + editorIndex + ", >>>" +
		// editorTitle);
		refreshViews();
	}

	public void refreshViews() {

		// Log.d(TAG, "       1 --> " + title + ", index=" + editorIndex);
		if (title == null)
			return;

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

		load();
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		save();
	}

	private void save() {
		String code = codes[editorIndex];
		String value = editorText.getText().toString();
		if (value == null || "".equals(value.trim()))
			return;
		if (_textLength == value.length()) return;
		_textLength = value.length();
		Map<String, String> params = new HashMap<String, String>();
		
		if (pitchId == null) {
			pitchId = PitchEditorActivity.pitch.getId();
			if (pitchId == null) {

				return;
			}
		}
		
		params.put("pitchId", pitchId);
		params.put("code", code);
		params.put("value", value);
		DomainHelper.saveEditorValue(getActivity(), params);
		
		if ("task".equalsIgnoreCase(code)) {
			//XXX This is fcking ugly
			PitchEditorActivity.pitch.setHasTask(true);
			DomainHelper.savePitch(getActivity(), PitchEditorActivity.pitch);
		}
		Log.d(TAG, " * Saved =" + params);
	}
	
	private void load() {
		String code = codes[editorIndex];
		Log.d(TAG, " * Loading: " + code);
		EditorValue val = DomainHelper.loadEditorValue(getActivity(), pitchId, code);
		if (val == null) return;
		editorText.setText(val.getValue());
		_textLength = val.getValue().length();
		Log.d(TAG, " * Loaded=" + val );
	}

}
