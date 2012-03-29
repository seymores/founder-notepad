package com.founderapp;

import java.util.Date;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.founderapp.domain.DomainHelper;
import com.founderapp.domain.Pitch;

public class PitchActivity extends BaseActivity {

	protected static final String TAG = "PitchActivity";
	private EditText companyNameText;
	private EditText developingText;
	private EditText offeringText;
	private EditText audienceText;
	private EditText solutionText;
	private EditText secretSauceText;
	
	private Pitch thePitch;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_note);
	
		thePitch = (Pitch)getIntent().getSerializableExtra("pitch");
		//Log.d(TAG, " --> Loaded " + thePitch );
		
		// -- Setup views
		companyNameText = (EditText)findViewById(R.id.company_text);
		developingText = (EditText)findViewById(R.id.developing_text);
		offeringText = (EditText)findViewById(R.id.offering_text);
		audienceText = (EditText)findViewById(R.id.audience_text);
		solutionText = (EditText)findViewById(R.id.solution_text);
		secretSauceText = (EditText)findViewById(R.id.secret_sauce_text);
	
	}
	
	public void onResume() {
		super.onResume();
		loadPitchData();
	}
	
	@Override
	public void onPause() {
		super.onPause();
		savePitchData();
	}
	
	private void loadPitchData() {
		if (thePitch == null) return;
		//Log.d(TAG,  " * Loading pitch data");
		companyNameText.setText(thePitch.getCompanyName());
		audienceText.setText(thePitch.getAudience());
		developingText.setText(thePitch.getDeveloping());
		offeringText.setText(thePitch.getOffering());
		solutionText.setText(thePitch.getSolution());
		secretSauceText.setText(thePitch.getSecretSauce());
	}
	
	private void savePitchData() {
		
		String name = companyNameText.getText().toString();
		if( name == null || "".equalsIgnoreCase(name))
			return;

		//Log.d(TAG,  " * Saving pitch data");
		
		if (thePitch == null) {
			thePitch = new Pitch();
		}
		
		thePitch.setCompanyName(companyNameText.getText().toString());
		thePitch.setAudience(audienceText.getText().toString());
		thePitch.setDeveloping(developingText.getText().toString());
		thePitch.setOffering(offeringText.getText().toString());
		thePitch.setSolution(solutionText.getText().toString());
		thePitch.setSecretSauce(secretSauceText.getText().toString());
		thePitch.setLastUpdated(new Date());
		DomainHelper.savePitch(this, thePitch);
	}
	
}
