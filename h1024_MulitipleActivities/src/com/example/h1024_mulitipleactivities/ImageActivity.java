package com.example.h1024_mulitipleactivities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);

		ImageView imgView = (ImageView) findViewById(R.id.imgView);
		Button btnClose = (Button) findViewById(R.id.btnClose);

		Intent receiveIntent = getIntent();
		final String artist = receiveIntent.getStringExtra("artist");

		switch (artist) {
		case "Kaskade":
			setTitle("Kaskade");
			imgView.setImageResource(R.drawable.kaskade);
			break;

		case "Galantis":
			setTitle("Galantis");
			imgView.setImageResource(R.drawable.galantis);
			break;
		}

		btnClose.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.putExtra("artist", artist);
				
				setResult(1, intent);
				finish();
			}
		});
	}
}

