package com.example.h1024_mulitipleactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ListActivity extends Activity {
	private static final int IMAGE_ACTIVITY = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		Button btnKaskade = (Button) findViewById(R.id.btnKaskade);
		Button btnGalantis = (Button) findViewById(R.id.btnGalantis);

		btnKaskade.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						ImageActivity.class);
				intent.putExtra("artist", "Kaskade");

				startActivityForResult(intent, IMAGE_ACTIVITY);
			}
		});

		btnGalantis.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						ImageActivity.class);
				intent.putExtra("artist", "Galantis");

				startActivityForResult(intent, IMAGE_ACTIVITY);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 2) {
			if (resultCode == 1) {
				Toast.makeText(getApplicationContext(),
						data.getStringExtra("artist"), Toast.LENGTH_SHORT)
						.show();
			}
		}
	}
}



