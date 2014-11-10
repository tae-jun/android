package com.example.h1107_spinner;

public class Album {
	private int cover;
	private String name;
	private int year;
	private String[] songs;

	public Album(int cover, String name, int year, String[] songs) {
		this.cover = cover;
		this.name = name;
		this.year = year;
		this.songs = songs;
	}

	public int getCover() {
		return this.cover;
	}

	public String getName() {
		return this.name;
	}

	public int getYear() {
		return this.year;
	}

	public String[] getSongs() {
		return this.songs;
	}
}
