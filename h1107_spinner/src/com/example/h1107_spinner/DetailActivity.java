package com.example.h1107_spinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {
	ImageView img;
	TextView txtName;
	TextView txtYear;
	TextView txtSong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_detail);

		Intent intent = getIntent();
		Album album = (Album) intent.getSerializableExtra("album");

		img = (ImageView) findViewById(R.id.alImg);
		txtName = (TextView) findViewById(R.id.alTxtName);
		txtYear = (TextView) findViewById(R.id.alTxtYear);
		txtSong = (TextView) findViewById(R.id.alTxtSong);

		img.setImageDrawable(getResources().getDrawable(album.getCover()));

		String songs = "";
		for (String song : album.getSongs()) {
			songs += song + "\n";
		}
		txtName.setText(album.getName());
		txtYear.setText(album.getYear());
		txtSong.setText(songs);
	}
}
