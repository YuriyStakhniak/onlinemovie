package com.movies.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String about;
	private String pathImage;

	@ManyToMany
	@JoinTable(name = "directors_movies", joinColumns = @JoinColumn(name ="director_id"),
			inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private List<Movie> movies;

	public Director() {

	}

	public Director(String name, String about, List<Movie> movies) {
		this.name = name;
		this.about = about;
		this.movies = movies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Director director = (Director) o;

		return id == director.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "Director{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
