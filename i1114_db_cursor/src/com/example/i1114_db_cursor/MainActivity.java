package com.example.i1114_db_cursor;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView status;
	public static final String TAG = "MainActivity";
	private static String DATABASE_NAME = null;
	private static String TABLE_NAME = "employee";
	private static int DATABASE_VERSION = 1;
	private DatabaseHelper dbHelper;
	private SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		status = (TextView) findViewById(R.id.status);
		final EditText input01 = (EditText) findViewById(R.id.input01);
		Button queryBtn = (Button) findViewById(R.id.queryBtn);
		queryBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				DATABASE_NAME = input01.getText().toString();
				boolean isOpen = openDatabase();
				if (isOpen) {
					executeRawQuery();
					executeRawQueryParam();
				}
			}
		});
	}

	private boolean openDatabase() {
		println("2012440037 Tae-Jun Kim");
		println("opening database [" + DATABASE_NAME + "].");
		dbHelper = new DatabaseHelper(this);
		db = dbHelper.getWritableDatabase();
		return true;
	}

	private void executeRawQuery() {
		println("\n executeRawQuery called.\n");
		Cursor c1 = db.rawQuery("select count(*) as Total from " + TABLE_NAME,
				null);
		println("cursor count : " + c1.getCount());
		c1.moveToNext();
		println("record count : " + c1.getInt(0));
		c1.close();
	}

	private void executeRawQueryParam() {
		println("\nexecuteRawQueryParam called.\n");
		String SQL = "select name, age, phone " + " from " + TABLE_NAME
				+ " where age > ?";
		String[] args = { "30" };
		Cursor c1 = db.rawQuery(SQL, args);
		int recordCount = c1.getCount();
		println("cursor count : " + recordCount + "\n");
		for (int i = 0; i < recordCount; i++) {
			c1.moveToNext();
			String name = c1.getString(0);
			int age = c1.getInt(1);
			String phone = c1.getString(2);
			println("Record #" + i + " : " + name + ", " + age + ", " + phone);
		}
		c1.close();
	}

	private void executeRawQueryParam2() {
		println("\n executeRawQueryParam2 called.\n");
		String[] columns = { "name", "age", "phone" };
		String whereStr = "where age > ?";
		String[] whereParams = { "30" };
		Cursor c1 = db.query(TABLE_NAME, columns, whereStr, whereParams, null,
				null, null);
		int recordCount = c1.getCount();
		println("cursor count : " + recordCount + "\n");
		for (int i = 0; i < recordCount; i++) {
			c1.moveToNext();
			String name = c1.getString(0);
			int age = c1.getInt(1);
			String phone = c1.getString(2);
			println("Record #" + i + " : " + name + ", " + age + ", " + phone);
		}
		c1.close();
	}

	private void println(String msg) {
		Log.d(TAG, msg);
		status.append("\n" + msg);
	}

	private class DatabaseHelper extends SQLiteOpenHelper {
		public DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			println("creating table [" + TABLE_NAME + "].");
			try {
				String DROP_SQL = "drop table if exists " + TABLE_NAME;
				db.execSQL(DROP_SQL);
			} catch (Exception ex) {
				Log.e(TAG, "Exception in DROP_SQL", ex);
			}
			String CREATE_SQL = "create table " + TABLE_NAME + "("
					+ " _id integer PRIMARY KEY autoincrement, "
					+ " name text, " + " age integer, " + " phone text)";
			try {
				db.execSQL(CREATE_SQL);
			} catch (Exception ex) {
				Log.e(TAG, "Exception in CREATE_SQL", ex);
			}
			println("inserting records.");
			try {
				db.execSQL("insert into "
						+ TABLE_NAME
						+ "(name, age, phone) values ('John', 20, '010-7788-1234');");
				db.execSQL("insert into "
						+ TABLE_NAME
						+ "(name, age, phone) values ('Mike', 35, '010-8888-1111');");
				db.execSQL("insert into "
						+ TABLE_NAME
						+ "(name, age, phone) values ('Sean', 26, '010-6677-4321');");
			} catch (Exception ex) {
				Log.e(TAG, "Exception in insert SQL", ex);
			}
		}

		@Override
		public void onOpen(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			super.onOpen(db);
			println("opened database [" + DATABASE_NAME + "].");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ".");
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
			onCreate(db);
		}
	}
}
