package com.movies.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Star {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String about;
	private String pathImage;
	@ManyToMany
	@JoinTable(name = "stars_movies",
			joinColumns=@JoinColumn(name = "stars_id"), inverseJoinColumns=@JoinColumn(name = "movies_id"))
	private List<Movie> movies;
	
	public Star() {
		
	}
	

	public Star(String name) {
		super();
		this.name = name;
	}


	public Star(String name, String about) {
		super();
		this.name = name;
		this.about = about;
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

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Star star = (Star) o;

		return id == star.id;
	}

	@Override
	public int hashCode() {
		return id;
	}
}
