package labs.lab10;

import java.util.List;

/*
 * Represents a movie
 */
public class Movie {
	private String title;
	private int year;
	private List<String> directors;
	private List<String> producers;
	private List<String> actors;

	/**
	 * Constructs a Movie object
	 * 
	 * @param title
	 * @param year
	 * @param directors
	 * @param producers
	 * @param actors
	 */
	public Movie(String title, int year, List<String> directors, List<String> producers, List<String> actors) {
		this.title = title;
		this.year = year;
		this.directors = directors;
		this.producers = producers;
		this.actors = actors;
	}

	public List<String> getActors() {
		return actors;
	}

	public List<String> getDirectors() {
		return directors;
	}

	public List<String> getProducers() {
		return producers;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public String toString() {
		return "Name: " + title + ", Year: " + year + ", Directed by: " + directors + ", Produced by: " + producers
				+ ", Actors: " + actors;
	}
	
	public boolean equals(Object otherObject) {
		if (otherObject instanceof Movie) {
			Movie other = (Movie)otherObject;
			return this.title.equals(other.title) 
					&& this.year == other.year 
					&& this.directors.equals(directors)
					&& this.producers.equals(producers)
					&& this.actors.equals(actors);
		}
		return false;
	}
}
