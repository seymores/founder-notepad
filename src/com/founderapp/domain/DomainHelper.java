package com.founderapp.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;


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
	
		String pitchId = edit.get("pitchId");
		String code = edit.get("code");
		EditorValue val = loadEditorValue(ctx, pitchId, code);
		if (val == null) {
			val = new EditorValue();
		}
		val.setCode(code);
		val.setPitchId(pitchId);
		val.setValue(edit.get("value"));
		val.setLastUpdated(new java.util.Date());
		
		saveEditorValue(ctx, val);
	}

	public static List<Pitch> loadPitches(Context ctx) {
		DatabaseHelper helper = new DatabaseHelper(ctx);
		List<Pitch> rs = Collections.emptyList();
		try {
			rs 
			= helper.getPitchDao().queryBuilder().orderBy("lastUpdated", false)
										.where().eq("closed", false).query();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
		} finally {
			helper.close();
		}
		return rs;
	}

	public static EditorValue loadEditorValue(Context ctx,
			String pitchId, String code) {
		
		DatabaseHelper helper = new DatabaseHelper(ctx);
		EditorValue val = null;
		try {
			
			Dao<EditorValue, String> dao = helper.getEditorDao();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("pitchId", pitchId);
			params.put("code", code);
			List<EditorValue> vals = dao.queryForFieldValues(params);
			if (vals != null && vals.size() > 0)
				val = vals.get(0);
		} catch (Exception ex) {
			Log.e(TAG, " Error loading Edit: " + ex.getMessage());
		} finally {
			helper.close();
		}
		
		return val;
	}

	public static void delete(Context ctx,	Pitch pitch) {
		String pitchId = pitch.getId();
		DatabaseHelper helper = new DatabaseHelper(ctx);
		try {
			
			helper.getPitchDao().deleteById(pitchId);
			DeleteBuilder<EditorValue, String> del = helper.getEditorDao().deleteBuilder();
			del.where().eq("pitchId", pitchId);
			del.delete();
			
		} catch (Exception e) {
			Log.e(TAG,  e.getMessage());
		} finally {
			helper.close();
		}
		
	}
	
}
