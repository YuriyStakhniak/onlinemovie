package com.movies.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.movies.dao.DirectorDao;
import com.movies.dao.GenreDao;
import com.movies.dao.StarDao;
import com.movies.entity.Director;
import com.movies.entity.Genre;
import com.movies.entity.Star;
import com.movies.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.movies.dao.MovieDao;
import com.movies.entity.Movie;
import com.movies.service.MovieService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao movieDao;
	@Autowired
	private GenreDao genreDao;
	@Autowired
	private StarDao starDao;
	@Autowired
	private DirectorDao directorDao;
	@Autowired
	@Qualifier("movieValidator")
	private Validator validator;
	@Autowired
	@Qualifier("movieUpdateValidator")
	private Validator updateValidator;
//	@Autowired
//	@Qualifier("movieSecondValidator")
//	private Validator secondValidator;



	@Transactional
	@Override
	public void save(Movie movie, ArrayList<Integer> genresId,
					 ArrayList<Integer> starsId, MultipartFile image, ArrayList<Integer> directorsId) throws Exception {

		validator.validate(movie);
		movieDao.saveAndFlush(movie);

		String path = System.getProperty("catalina.home") + "/resources/" +
                movie.getTitle() + "/" + image.getOriginalFilename();
		movie.setPathImage("resources/" + movie.getTitle() + "/" + image.getOriginalFilename());
        File filePath = new File(path);


		try {
		    filePath.mkdirs();
		    image.transferTo(filePath);

        }catch (IOException e){

            System.out.println("e = " + e);
        }
        List<Genre> genres = new ArrayList<Genre>();
		for (Integer id: genresId) {
			genres.add(genreDao.findOne(id));

		}

		movie.setGenres(genres);

		List<Star> stars = new ArrayList<Star>();
		for (Integer id: starsId) {

			stars.add(starDao.findOne(id));

		}
		movie.setStars(stars);
		List<Director> directors = new ArrayList<>();
		for (Integer id : directorsId){
			directors.add(directorDao.findOne(id));
		}
		movie.setDirectors(directors);
//		secondValidator.validate(movie);
		movieDao.save(movie);

	}

	@Override
	public List<Movie> findAll() {
		return movieDao.findAll();
	}

	@Override
	public Movie findOne(int id) {
		return movieDao.findOne(id);
	}

	@Override
	public void delete(int id) {

	movieDao.delete(id);
	}


	@Transactional
	@Override
	public void update(Movie movie, String title, ArrayList<Integer> genresId,
					   ArrayList<Integer> starsId, String year, String imdbRating,
					   String description, MultipartFile image, ArrayList<Integer> directorsId) throws Exception {
		updateValidator.validate(movie);
        String path = System.getProperty("catalina.home") + "/resources/" +
                movie.getTitle() + "/" + image.getOriginalFilename();
        movie.setPathImage("resources/" + movie.getTitle() + "/" + image.getOriginalFilename());
        File filePath = new File(path);
        try {
            filePath.mkdirs();
            image.transferTo(filePath);

        }catch (IOException e){

            System.out.println("e = " + e);
        }
		List<Genre> genres = new ArrayList<Genre>();
		for (Integer id : genresId){
		    genres.add(genreDao.findOne(id));
        }
        List<Star> stars = new ArrayList<Star>();
        for(Integer id : starsId){
            stars.add(starDao.findOne(id));
        }
        movie.setGenres(genres);
        movie.setStars(stars);

		movieDao.save(movie);
	}

	@Override
	public List<Movie> moviesWithGenres() {
		return movieDao.moviesWithGenres();
	}

	@Override
	public List<Movie> moviesWithStars() {
		return movieDao.moviesWithStars();
	}



	@Override
	public List<Movie> moviesWithDirectors() {
		return movieDao.moviesWithDirectors();
	}

	@Override
	public List<Movie> movieWithGenresAndStars() {
		List<Movie> movies = new ArrayList<>();


		for (Movie m : moviesWithGenres()) {
			Movie movie = new Movie();
			movie.setGenres(m.getGenres());
			movie.setDescription(m.getDescription());
			movie.setImdbRating(m.getImdbRating());
			movie.setYear(m.getYear());
			movie.setId(m.getId());
			movie.setTitle(m.getTitle());
			movie.setPathImage(m.getPathImage());
			movies.add(movie);

		}

		int counter = 0;
		for (Movie movie : moviesWithStars()) {
			movies.get(counter).getStars().addAll(movie.getStars());
			counter++;
		}
		return movies;
	}

	@Override
	public List<Movie> moviesWithGenresAndStarsAndDirectors() {

		List<Movie> movies = new ArrayList<>();
		for (Movie m: moviesWithGenres()){
			Movie movie = new Movie();
			movie.setGenres(m.getGenres());
			movie.setPathImage(m.getPathImage());
			movie.setImdbRating(m.getImdbRating());
			movie.setDescription(m.getDescription());
			movie.setTitle(m.getTitle());
			movie.setYear(m.getYear());
			movie.setId(m.getId());
			movies.add(movie);
		}

		int counter = 0;
		for (Movie movie : moviesWithStars()){
			movies.get(counter).getStars().addAll(movie.getStars());

			counter++;
		}
		int iter = 0;
		for (Movie movie: moviesWithDirectors()){
			movies.get(iter).getDirectors().addAll(movie.getDirectors());
			iter++;
		}
		return movies;
	}


	@Override
	public Page<Movie> findAllPages(Pageable pageable) {
		return movieDao.findAll(pageable);
	}

	@Override
	public Movie findMovieWithGenres(int id) {
		return movieDao.findMovieWithGenres(id);
	}
	@Override
	public Movie findMovieWithDirectors(int id) {
		return movieDao.findMovieWithDirectors(id);
	}

	@Override
	public Movie findMovieWithDirectorsAndMoviesAndStars(int id) {

		Movie movie = new Movie();
		movie.setGenres(findMovieWithGenres(id).getGenres());
		movie.setStars(findMovieWithStars(id).getStars());
		movie.setDirectors(findMovieWithDirectors(id).getDirectors());
		movie.setTitle(findOne(id).getTitle());
		movie.setDescription(findOne(id).getDescription());
		movie.setImdbRating(findOne(id).getImdbRating());
		movie.setYear(findOne(id).getYear());
		movie.setId(id);
		movie.setPathImage(findOne(id).getPathImage());
		return movie;
	}

	@Override
	public Movie findMovieWithStars(int id) {
		return movieDao.findMovieWithStars(id);
	}

	@Override
	public Movie findMovieWithGenresAndStars(int id) {

		Movie movie = new Movie();
		movie.setGenres(findMovieWithGenres(id).getGenres());
		movie.setStars(findMovieWithStars(id).getStars());
		movie.setTitle(findOne(id).getTitle());
		movie.setDescription(findOne(id).getDescription());
		movie.setImdbRating(findOne(id).getImdbRating());
		movie.setYear(findOne(id).getYear());
		movie.setId(id);

		return movie;

	}



}

