package com.movies.validator.genreValidator;

import com.movies.dao.GenreDao;
import com.movies.entity.Genre;
import com.movies.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Yura on 03.07.2017.
 */
@Component
public class GenreValidator implements Validator {

    @Autowired
    private GenreDao genreDao;
    @Override
    public void validate(Object o) throws Exception {

        Genre genre = (Genre) o;

        if (genre.getName().isEmpty()){

            throw new GenreException(GenreValidatorMessages.EMPTY_GENRE_FIELD);

        }

        if (genreDao.findByName(genre.getName())!=null){

            throw new GenreException(GenreValidatorMessages.THIS_GENRE_ALREADY_EXISTS);

        }
    }
}
