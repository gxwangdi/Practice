package com.example.earthquakeexplorer.modelUtils;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



/*
 * For persistence, we store the json string directly
 * for future scalability, like adding a field or changing a field.
 * 
 * Have not check the data size but when it scales to 
 * all earthquake records in the past, we do not use SQL
 * to do the filtering, we do it in memory instead.
 * 
 * */
public class PersistenceUtils {

	private static final String tag = "PersistenceUtils";
	private static final String TABLE_NAME = "FeatureCollection";
	private static final String CREATE_TABLE 
		= "create table " + TABLE_NAME + "(id text, properties text, geometry text)";       
	
	private static final int SCHEMA_VERSION = 10;
	
	private class DatabaseHelper 
		extends SQLiteOpenHelper {
		
		final Context mContext;

		public DatabaseHelper(Context c) {
			super(c, TABLE_NAME, null, SCHEMA_VERSION);
			mContext = c;
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			Log.i(tag, "SQLiteOpenHelper.onCreate().");
			db.execSQL(CREATE_TABLE);
			db.setVersion(SCHEMA_VERSION);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.i(tag, "SQLiteOpenHelper.onUpgrade().");
			db.execSQL(CREATE_TABLE);
			db.setVersion(newVersion);
		}
		
	}// end of DatabaseHelper class 
	
	private SQLiteDatabase db = null;
	private DatabaseHelper dbHelper;
	private static PersistenceUtils INSTANCE = null;
	
	public synchronized static PersistenceUtils getInstance(Context c) {
		if (INSTANCE == null)
			INSTANCE = new PersistenceUtils(c);
		
		return INSTANCE;
	}
	
	private PersistenceUtils(Context c) {
		dbHelper = new DatabaseHelper(c);
	}
	
	public synchronized void save(final String src) {
		List<Feature> input = ParsingUtils.parseFeatures(src);
		save(input);
	}// end of save
	
	public synchronized void save(final List<Feature> src) {
		db = dbHelper.getWritableDatabase();         
		ContentValues cv = null;
		for (Feature f:src) {
			cv = new ContentValues();
			cv.put("id", f.id);
			cv.put("properties", f.mProperty.toString());
			cv.put("geometry", f.mGeometry.toString());
			
			// check if same record exists
			Cursor c = db.query(
					TABLE_NAME
					, null
					, "id=?"
					, new String[]{f.id}
					, null
					, null
					, null);
			if (!c.moveToFirst()) {
				if (db.insert(TABLE_NAME, null, cv) < 0) {
					Log.e(tag, "Failed to add Feature:" + f.toString());
				}
			} else {
				if (db.update(TABLE_NAME, cv, "id=?", new String[]{f.id})==0) {
					Log.e(tag, "Failed to update feature:" + f.toString());
				}
			}
		}
		db.close();
		db = null;
	}
	
	public synchronized List<Feature> fetch() {
		// get all from local storage
		db = dbHelper.getReadableDatabase();   
		List<Feature> result = new ArrayList<Feature>();
		Cursor c = null;
		try {
			c = db.query(
					TABLE_NAME
					, null
					, null
					, null
					, null
					, null
					, null);
			if (c.moveToFirst()) {
				Feature f = new Feature();
				f.id = c.getString(c.getColumnIndex("id"));
				String s;
				s = c.getString(c.getColumnIndex("properties"));
				Log.d(s, "properties:"+s);
				f.mProperty = ParsingUtils.parseProperty(s);
				s = c.getString(c.getColumnIndex("geometry"));
				Log.d(s, "geometry:"+s);    
				f.mGeometry = ParsingUtils.parseGeometry(s);
				result.add(f);
			}
		} catch (Exception e) {
			Log.e(tag, "Failed to fetch.");
		}
		// parsing and close db
		db.close();
		db = null;
		return result;
	}
	
	
}// end of PersistenceUtils             




