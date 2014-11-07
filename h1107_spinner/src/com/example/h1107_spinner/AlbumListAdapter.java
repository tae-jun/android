package com.example.h1107_spinner;

import java.util.ArrayList;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class AlbumListAdapter extends BaseAdapter {

	private Context context;

	private ArrayList<Album> albums = new ArrayList<Album>();

	public AlbumListAdapter(Context context) {
		this.context = context;
	}
	
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.albums.size();
	}

	@Override
	public Object getItem(int position) {
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
//		if (convertView == null) {
//			itemView = new IconTextView(mContext, mItems.get(position));
//		} else {
//			itemView = (IconTextView) convertView;
//			
//			itemView.setIcon(mItems.get(position).getIcon());
//			itemView.setText(0, mItems.get(position).getData(0));
//			itemView.setText(1, mItems.get(position).getData(1));
//			itemView.setText(2, mItems.get(position).getData(2));
//		}

		return itemView;
	}

}