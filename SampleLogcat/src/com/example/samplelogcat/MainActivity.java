package com.example.samplelogcat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button button01 = (Button) findViewById(R.id.button1);
		Button button02 = (Button) findViewById(R.id.button2);
		Button button03 = (Button) findViewById(R.id.button3);
		Button button04 = (Button) findViewById(R.id.button4);
		Button button05 = (Button) findViewById(R.id.button5);
		button01.setOnClickListener(onClick);
		button02.setOnClickListener(onClick);
		button03.setOnClickListener(onClick);
		button04.setOnClickListener(onClick);
		button05.setOnClickListener(onClick);

	}

	OnClickListener onClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.button1:
				Log.v("Test", "Verbose");
				break;
			case R.id.button2:
				Log.d("Test", "Debug");
				break;
			case R.id.button3:
				Log.i("Test", "Info");
				break;
			case R.id.button4:
				Log.w("Test", "Warn");
				break;
			case R.id.button5:
				Log.e("Test", "Error");
				break;
			default:
				break;
			}
		}
	};
}
