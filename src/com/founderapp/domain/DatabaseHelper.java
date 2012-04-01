package com.founderapp.domain;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private static final String TAG = "DatabaseHelper";
	private static final String DATABASE_NAME = "trello.db";
	private static final int DATABASE_VERSION = 2;

	private Dao<Pitch, String> pitchDao;
	private Dao<EditorValue, String> editorDao;
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {

		try {

			TableUtils.createTable(connectionSource, Pitch.class);
			TableUtils.createTable(connectionSource, EditorValue.class);

		} catch (Exception e) {
			Log.e(TAG, " Error creating database table: " + e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,
			int arg3) {
		try {

			TableUtils.dropTable(connectionSource, Pitch.class, true);
			TableUtils.dropTable(connectionSource, EditorValue.class, true);

		} catch (Exception e) {
			Log.e(TAG, " Error creating database table: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public Dao<Pitch, String> getPitchDao() throws SQLException {
		if (pitchDao == null) {
			pitchDao = getDao(Pitch.class);
		}
		return pitchDao;
	}
	
	public Dao<EditorValue, String> getEditorDao() throws SQLException {
		if (editorDao == null) {
			editorDao = getDao(EditorValue.class);
		}
		return editorDao;
	}

}
