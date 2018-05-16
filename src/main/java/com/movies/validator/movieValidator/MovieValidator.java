package com.movies.validator.movieValidator;

import com.movies.dao.MovieDao;
import com.movies.entity.Movie;
import com.movies.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by Yura on 08.06.2017.
 */

@Component
public class MovieValidator implements Validator {

    @Autowired
    private MovieDao movieDao;

    @Override
    public void validate(Object o) throws Exception {

        Movie movie = (Movie) o;

        if (movie.getTitle().isEmpty()) {

            throw new MovieExeption(MovieValidatorMessages.EMPTY_MOVIE_TITLE_FIELD);

        } else if (movieDao.findByTitle(movie.getTitle()) != null) {

            throw new MovieExeption(MovieValidatorMessages.MOVIE_TITLE_ALREADY_EXISTS);

        } else if (movie.getImdbRating().equals("-100")) {

            throw new MovieExeption(MovieValidatorMessages.EMPTY_IMDB_RATING_FIELD);

        } else if(movie.getDescription().isEmpty()){

            throw new MovieExeption(MovieValidatorMessages.EMPTY_MOVIE_DESCRIPTION_FIELD);

        }else if (movie.getYear().equals("-100")){

            throw new MovieExeption(MovieValidatorMessages.EMPTY_YEAR_FIELD);
        }


    }

}

