package com.example.h1107_spinner;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
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
		requestWindowFeature(Window.FEATURE_NO_TITLE);
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

		// Create Avicii
		Artist Avicii = new Artist("Avicii");

		// True
		String[] trueSongs = { "Wake Me Up", "You Make Me" };
		Album tru = new Album(R.drawable.avicii_true, "True", 2013, trueSongs);
		Avicii.addAlbum(tru);
		// Add Avicii
		artists.add(Avicii);

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

		final AlbumListAdapter adapter = new AlbumListAdapter(this,
				artist.getAlbums());

		list.setAdapter(adapter);

		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(MainActivity.this,
						DetailActivity.class);
				intent.putExtra("album", adapter.getItem(position));
				startActivity(intent);
			}
		});
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
