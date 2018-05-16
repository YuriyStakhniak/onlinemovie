package com.movies.validator.genreValidator;

import com.movies.entity.Genre;
import com.movies.validator.Validator;
import org.springframework.stereotype.Component;

/**
 * Created by Yura on 03.07.2017.
 */
@Component
public class GenreUpdateValidator implements Validator {
    @Override
    public void validate(Object o) throws Exception {

        Genre genre = (Genre) o;

        if (genre.getName().isEmpty()){

            throw new GenreException(GenreValidatorMessages.EMPTY_GENRE_FIELD);

        }

    }
}
