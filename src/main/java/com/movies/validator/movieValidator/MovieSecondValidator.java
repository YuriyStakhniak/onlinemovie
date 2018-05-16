package com.movies.validator.movieValidator;

import com.movies.entity.Movie;
import com.movies.validator.Validator;

import org.springframework.stereotype.Component;

/**
 * Created by Yura on 02.07.2017.
 */
@Component

public class MovieSecondValidator implements Validator {
    @Override
    public void validate(Object o) throws Exception {

        Movie movie = (Movie) o;
        System.out.println(movie.getStars().get(0));

        if(movie.getStars().contains("-100")){
            throw new MovieExeption(MovieValidatorMessages.NO_STAR_SELECTED);
        }

    }
}
