package com.example.h1107_spinner;

import java.util.ArrayList;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class AlbumListAdapter extends BaseAdapter {

	private Context context;

	private ArrayList<Album> albums;

	public AlbumListAdapter(Context context, ArrayList<Album> albums) {
		this.context = context;
		this.albums = albums;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.albums.size();
	}

	@Override
	public Album getItem(int position) {
		// TODO Auto-generated method stub
		return this.albums.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		AlbumListView itemView;
		Album album = albums.get(position);
		if (convertView == null) {
			itemView = new AlbumListView(context, album);
		} else {
			itemView = (AlbumListView) convertView;
			itemView.setAlbum(album);
		}

		return itemView;
	}

}
