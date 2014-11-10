package com.example.h1107_spinner;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
		cover = (ImageView)findViewById(R.id.liCover);
		
		cover.setImageDrawable(getResources().getDrawable(album.getCover()));
		
	}

}
