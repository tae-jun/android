package com.example.h1107_spinner;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Album implements Serializable {
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

	public String getYear() {
		return String.valueOf(year);
	}

	public String[] getSongs() {
		return this.songs;
	}
}
