package com.example.h1107_spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AlbumListView extends LinearLayout {

	private ImageView cover;
	private TextView name;
	private TextView year;

	public AlbumListView(Context context, Album album) {
		super(context);

		// Layout inflation
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.listitem, this, true);

		// Set icon
		cover = (ImageView) findViewById(R.id.liCover);
		cover.setImageDrawable(getResources().getDrawable(album.getCover()));
		// cover.setLayoutParams(new LayoutParams(cover.getWidth(), cover
		// .getWidth()));
		// cover.requestLayout();

		name = (TextView) findViewById(R.id.liName);
		name.setText(album.getName());

		year = (TextView) findViewById(R.id.liYear);
		year.setText(album.getYear());
	}

	public void setAlbum(Album album) {
		cover.setImageDrawable(getResources().getDrawable(album.getCover()));
		name.setText(album.getName());
		year.setText(album.getYear());
	}
}
