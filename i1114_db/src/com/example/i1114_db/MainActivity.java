package com.example.i1114_db;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	String databaseName;
	String tableName;
	TextView status;
	boolean databaseCreated = false;
	boolean tableCreated = false;

	SQLiteDatabase db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		final EditText databaseNameInput = (EditText) findViewById(R.id.databaseNameInput);
		final EditText tableNameInput = (EditText) findViewById(R.id.tableNameInput);

		Button createDatabaseBtn = (Button) findViewById(R.id.createDatabaseBtn);
		createDatabaseBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				databaseName = databaseNameInput.getText().toString();
				createDatabase(databaseName);
			}
		});

		Button createTableBtn = (Button) findViewById(R.id.createTableBtn);
		createTableBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				tableName = tableNameInput.getText().toString();
				createTable(tableName);
				int count = insertRecord(tableName);
				println(count + " records inserted.");
			}
		});

		status = (TextView) findViewById(R.id.status);

	}

	private void createDatabase(String name) {
		println("creating database [" + name + "].");

		try {
			db = openOrCreateDatabase(name, MODE_WORLD_WRITEABLE, null);

			databaseCreated = true;
			println("database is created.");
		} catch (Exception ex) {
			ex.printStackTrace();
			println("database is not created.");
		}
	}

	private void createTable(String name) {
		println("creating table [" + name + "].");

		db.execSQL("create table if not exists " + name + "("
				+ " _id integer PRIMARY KEY autoincrement, " + " name text, "
				+ " age integer, " + " phone text);");

		tableCreated = true;
	}

	private int insertRecord(String name) {
		println("inserting records into table " + name + ".");

		int count = 3;
		db.execSQL("insert into " + name
				+ "(name, age, phone) values ('John', 20, '010-7788-1234');");
		db.execSQL("insert into " + name
				+ "(name, age, phone) values ('Mike', 35, '010-8888-1111');");
		db.execSQL("insert into " + name
				+ "(name, age, phone) values ('Sean', 26, '010-6677-4321');");

		return count;
	}

	/**
	 * insert records using parameters
	 */
	private int insertRecordParam(String name) {
		println("inserting records using parameters.");

		int count = 1;
		ContentValues recordValues = new ContentValues();

		recordValues.put("name", "Rice");
		recordValues.put("age", 43);
		recordValues.put("phone", "010-3322-9811");
		int rowPosition = (int) db.insert(name, null, recordValues);

		return count;
	}

	/**
	 * update records using parameters
	 */
	private int updateRecordParam(String name) {
		println("updating records using parameters.");

		ContentValues recordValues = new ContentValues();
		recordValues.put("age", 43);
		String[] whereArgs = { "Rice" };

		int rowAffected = db.update(name, recordValues, "name = ?", whereArgs);

		return rowAffected;
	}

	/**
	 * delete records using parameters
	 */
	private int deleteRecordParam(String name) {
		println("deleting records using parameters.");

		String[] whereArgs = { "Rice" };

		int rowAffected = db.delete(name, "name = ?", whereArgs);

		return rowAffected;
	}

	private void println(String msg) {
		Log.d("SampleDatabase", msg);
		status.append("\n" + msg);

	}

}