package com.movies.validator.movieValidator;


import com.movies.entity.Movie;
import com.movies.validator.Validator;
import org.springframework.stereotype.Component;


/**
 * Created by Yura on 28.06.2017.
 */


@Component
public class MovieUpdateValidator implements Validator {




    @Override
    public void validate(Object o) throws Exception {
        Movie movie = (Movie) o;
        if (movie.getTitle().isEmpty()) {

            throw new MovieExeption(MovieValidatorMessages.EMPTY_MOVIE_TITLE_FIELD);

        }else if (movie.getImdbRating().equals("-100")) {

            throw new MovieExeption(MovieValidatorMessages.EMPTY_IMDB_RATING_FIELD);

        } else if(movie.getDescription().isEmpty()){

            throw new MovieExeption(MovieValidatorMessages.EMPTY_MOVIE_DESCRIPTION_FIELD);

        }else if (movie.getYear().equals("-100")){

            throw new MovieExeption(MovieValidatorMessages.EMPTY_YEAR_FIELD);
        }


    }
}
