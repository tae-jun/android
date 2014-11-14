package com.example.h1107_spinner;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnItemSelectedListener,
		OnItemClickListener {
	Spinner spin;
	ListView list;

	ArrayList<Artist> artists;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Find views
		spin = (Spinner) findViewById(R.id.spin);
		list = (ListView) findViewById(R.id.list);

		// Add listener on spinner
		spin.setOnItemSelectedListener(this);
		// Add listener on list view
		list.setOnItemClickListener(this);

		// Initialize artists array
		artists = new ArrayList<Artist>();

		// Create John Mayer
		Artist johnMayer = new Artist("John Mayer");

		// Room for Squares
		String[] roomForSongs = { "No Such Thing", "Why Georgia" };
		Album roomFor = new Album(R.drawable.john_mayer_room_for_squares,
				"Room for Squares", 2001, roomForSongs);
		johnMayer.addAlbum(roomFor);
		// Clarity
		String[] heavierSongs = { "Clarity", "Bigger Than My Body" };
		Album heavier = new Album(R.drawable.john_mayer_heavier_things,
				"Heavier Things", 2003, heavierSongs);
		johnMayer.addAlbum(heavier);
		// Add John Mayer
		artists.add(johnMayer);

		ArrayAdapter<Artist> adapter = new ArrayAdapter<Artist>(this,
				android.R.layout.simple_spinner_item, artists);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spin.setAdapter(adapter);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Log.d("jun", artists.get(position).toString());
		Artist artist = artists.get(position);

		ArrayAdapter<Album> adapter = new ArrayAdapter<Album>(this, );
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

	/**
	 * List View On Item Click
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub

	}
}
