package com.xgen.spider;

import java.util.ArrayList;

public class Film {
	String filmName;
	int filmTime;
	ArrayList<String> actors = new ArrayList<>();
	String director;

	public Film() {

	}

	public Film(String filmName, int filmTime, String director) {
		super();
		this.filmName = filmName;
		this.filmTime = filmTime;
		this.director = director;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public int getFilmTime() {
		return filmTime;
	}

	public void setFilmTime(int filmTime) {
		this.filmTime = filmTime;
	}

	public ArrayList<String> getActors() {
		return actors;
	}

	public void setActors(ArrayList<String> actors) {
		this.actors = actors;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void addActor(String actor) {
		actors.add(actor);
	}

	@Override
	public String toString() {
		return "Film [filmName=" + filmName + ", filmTime=" + filmTime + ", actors=" + actors + ", director=" + director
				+ "]";
	}

}
