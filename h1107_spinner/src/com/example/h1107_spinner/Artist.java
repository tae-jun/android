package com.example.h1107_spinner;

import java.util.ArrayList;

public class Artist {
	String name;
	ArrayList<Album> albums;

	public Artist(String name) {
		this.name = name;
		this.albums = new ArrayList<Album>();
	}

	public void addAlbum(Album album) {
		this.albums.add(album);
	}

	public ArrayList<Album> getAlbums(){
		return this.albums;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
