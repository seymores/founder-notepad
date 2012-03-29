package com.founderapp.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;


public class DomainHelper {

	private static final String TAG = "DomainHelper";
	
	public static void savePitch(Context ctx, Pitch pitch) {
		DatabaseHelper helper = new DatabaseHelper(ctx);
		
		try {
			
			Dao<Pitch, String> dao = helper.getPitchDao();
			dao.createOrUpdate(pitch);
			
		} catch (Exception ex) {
			Log.e(TAG, " Error saving Pitch: " + ex.getMessage());
		} finally {
			helper.close();
		}
		
	}
	
	public static void savePitch(Context ctx, Map<String, String> pitch) {
		
	}
	
	public static void saveEditorValue(Context ctx, EditorValue edit) {
		DatabaseHelper helper = new DatabaseHelper(ctx);
		
		try {
			
			Dao<EditorValue, String> dao = helper.getEditorDao();
			dao.createOrUpdate(edit);
			
		} catch (Exception ex) {
			Log.e(TAG, " Error saving Edit: " + ex.getMessage());
		} finally {
			helper.close();
		}
	}
	
	public static void saveEditorValue(Context ctx, Map<String, String> edit) {

	}

	public static List<Pitch> loadPitches(Context ctx) {
		DatabaseHelper helper = new DatabaseHelper(ctx);
		List<Pitch> rs = Collections.emptyList();
		try {
			rs 
			= helper.getPitchDao().queryBuilder().orderBy("lastUpdated", false).query();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
		}
		return rs;
	}
	
}
