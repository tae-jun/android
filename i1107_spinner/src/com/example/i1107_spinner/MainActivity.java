package com.example.i1107_spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemSelectedListener {
	TextView txt;
	Spinner spinner;
	String[] items = { "mike", "angel", "crow", "john", "ginnie", "sally",
			"cohen", "rice" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txt = (TextView) findViewById(R.id.txt);
		spinner = (Spinner) findViewById(R.id.spinner);

		spinner.setOnItemSelectedListener(this);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, items);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner.setAdapter(adapter);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		txt.setText(items[position]);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}
}
