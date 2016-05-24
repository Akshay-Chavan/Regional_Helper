package com.android.databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DBUserDetails {
	public static final String KEY_CONTACT="contact";
	public static final String KEY_NAME="name";
	public static final String KEY_CITY="city";
	public static final String KEY_EMAIL="email";
    private static final String TAG="DBAdapter";
	private static final String DATABASE_NAME="User";
	private static final String DATABASE_TABLE="userdetails";
	private static final int DATABASE_VERSION=1;
	private static final String DATABASE_CREATE=
			"create table userdetails (contact text not null, name text not null,city text not null,email text not null);";
	private final Context context;
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	
	public DBUserDetails(Context ctx)
	{
		this.context=ctx;
		DBHelper=new DatabaseHelper(context);
	}
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		public DatabaseHelper(Context context) {
			super(context,DATABASE_NAME,null,DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}
		@Override
		public void onCreate(SQLiteDatabase db)
		{
			try
			{
				db.execSQL(DATABASE_CREATE);
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		@Override
		public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
		{
			Log.w(TAG,"Upgrading database from version"+oldVersion+"to"
					+newVersion+",which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS userdetails");
			
			onCreate(db);
		}
	}
	//---opens the database----
	public DBUserDetails open() throws SQLException
	{
		db=DBHelper.getWritableDatabase();
		return this;
	}
			
		//---closes the database---
	public void close()
	{
		DBHelper.close();
	}
	//inserts into database
	public long insertUserDetails(String contact,String name,String city,String email)
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_CONTACT,contact);
		initialValues.put(KEY_NAME,name);
		initialValues.put(KEY_CITY,city);
		initialValues.put(KEY_EMAIL,email);
		
		return db.insert(DATABASE_TABLE, null, initialValues);
	}
	
	//----deletes a particular contact---
//	public boolean deleteIP(String rowId)
//	{
//		return db.delete(DATABASE_TABLE, KEY_IPADDRESS+"="+rowId, null)>0;
//	}
	
	//------retrives all clients----
	public Cursor getUserDetails()
	{
		return db.query(DATABASE_TABLE, new String[]{KEY_CONTACT,KEY_NAME,KEY_CITY,KEY_EMAIL},null, null, null,null, null);
	}
	//retrieve a particular contact
//	public Cursor getClient(String rowId) throws SQLException
//	{
//		Cursor mCursor=
//				db.query(DATABASE_TABLE, new String[]{KEY_IPADDRESS},null, null, null,null, null);
//		if(mCursor!=null){
//			mCursor.moveToFirst();
//		}
//		return mCursor;
//	}
	
	//---updates a contact---
	/*public boolean updateClient(String rowId,String name)
	{
		ContentValues args=new ContentValues();
		args.put(KEY_NAME, name);
		return db.update(DATABASE_TABLE, args, KEY_USERID+"="+rowId, null)>0;
		
			}*/
	//-----delete all contacts-----
	public void deleteIP()
	{
	
		db.execSQL("DELETE FROM tbl");
	}
}
