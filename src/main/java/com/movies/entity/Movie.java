package com.movies.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
//@Table(name = "movie", indexes = @Index(columnList = "movieTitle", name = "movieTitle_index"))
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String year;
    private String imdbRating;
    private String description;
    private int votes;
    private String pathImage;
    @ManyToMany
    @JoinTable(name = "user_movie", joinColumns = @JoinColumn(name = "id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> users = new ArrayList<User>();
    @ManyToMany
    @JoinTable(name = "directors_movies", joinColumns = @JoinColumn(name ="movie_id"), inverseJoinColumns = @JoinColumn(name = "director_id "))
    private List<Director> directors = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "movies_genres", joinColumns = @JoinColumn(name = "movies_id"), inverseJoinColumns = @JoinColumn(name = "genres_id"))
    private List<Genre> genres = new ArrayList<Genre>();
    @ManyToMany
    @JoinTable(name = "stars_movies", joinColumns = @JoinColumn(name = "movies_id"), inverseJoinColumns = @JoinColumn(name = "stars_id"))
    private List<Star> stars = new ArrayList<Star>();

    @ManyToMany
    @JoinTable(name = "orders_movies", joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "orders_id"))
    private List<Orders> orders = new ArrayList<Orders>();


    public Movie() {

    }




    public Movie(String title, String year, String imdbRating, String description, int votes) {
        super();
        this.title = title;
        this.year = year;
        this.imdbRating = imdbRating;
        this.description = description;
        this.votes = votes;
    }


    public Movie(String title) {
        super();
        this.title = title;
    }

    public Movie(String title, String year, String imdbRating, String description) {
        this.title = title;
        this.year = year;
        this.imdbRating = imdbRating;
        this.description = description;
    }

    public Movie(int id, String title, String imdbRating, String description, String year) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.imdbRating = imdbRating;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }


    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Star> getStars() {
        return stars;
    }

    public void setStars(List<Star> stars) {
        this.stars = stars;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pathImage='" + pathImage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return id == movie.id;
    }

    @Override
    public int hashCode() {
        return id;
    }


}
