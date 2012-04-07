package com.founderapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.founderapp.domain.DomainHelper;
import com.founderapp.domain.Pitch;

public class PitchFragment extends Fragment {

	private static final String TAG = "PitchFragment";
	private Pitch thePitch;

	private EditText companyNameText;
	private EditText developingText;
	private EditText offeringText;
	private EditText audienceText;
	private EditText solutionText;
	private EditText secretSauceText;

	public PitchFragment(Pitch pitch) {
		super();
		this.thePitch = pitch;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Log.d(TAG, " *** pitch=" + pitchId + ", index=" + editorIndex) ;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.pitch_fragment, container, false);

		companyNameText = (EditText) view.findViewById(R.id.company_text);
		developingText = (EditText) view.findViewById(R.id.developing_text);
		offeringText = (EditText) view.findViewById(R.id.offering_text);
		audienceText = (EditText) view.findViewById(R.id.audience_text);
		solutionText = (EditText) view.findViewById(R.id.solution_text);
		secretSauceText = (EditText) view.findViewById(R.id.secret_sauce_text);

		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		if (thePitch == null) thePitch = PitchEditorActivity.pitch;
		Log.d(TAG, "  >>> onResume => " + thePitch);
		loadPitchData();
	}

	@Override
	public void onPause() {
		super.onPause();
		savePitchData();
	}

	private void loadPitchData() {
		if (thePitch == null)
			return;
		// Log.d(TAG, " * Loading pitch data");
		companyNameText.setText(thePitch.getCompanyName());
		audienceText.setText(thePitch.getAudience());
		developingText.setText(thePitch.getDeveloping());
		offeringText.setText(thePitch.getOffering());
		solutionText.setText(thePitch.getSolution());
		secretSauceText.setText(thePitch.getSecretSauce());
	}

	private void savePitchData() {

		String name = companyNameText.getText().toString();
		if (name == null || "".equalsIgnoreCase(name))
			return;

		// Log.d(TAG, " * Saving pitch data");

		if (thePitch == null) {
			thePitch = new Pitch();
			PitchEditorActivity.pitch = thePitch;
		}

		thePitch.setCompanyName(companyNameText.getText().toString());
		thePitch.setAudience(audienceText.getText().toString());
		thePitch.setDeveloping(developingText.getText().toString());
		thePitch.setOffering(offeringText.getText().toString());
		thePitch.setSolution(solutionText.getText().toString());
		thePitch.setSecretSauce(secretSauceText.getText().toString());
		thePitch.setLastUpdated(new java.util.Date());
		DomainHelper.savePitch(getActivity(), thePitch);
		Log.d(TAG, " ** Saved = " + thePitch);
	}

}
