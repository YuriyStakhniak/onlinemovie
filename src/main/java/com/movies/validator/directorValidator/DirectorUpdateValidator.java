package com.movies.validator.directorValidator;

import com.movies.dao.DirectorDao;
import com.movies.entity.Director;
import com.movies.entity.Movie;
import com.movies.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Yura on 03.07.2017.
 */
@Component

public class DirectorUpdateValidator implements Validator {

    @Autowired
    private DirectorDao directorDao;
    @Override
    public void validate(Object o) throws Exception {

        Director director = (Director) o;

        if (director.getName().isEmpty()){
            throw new DirectorExeption(DirectorValidatorMessages.EMPTY_NAME_FIELD);
        }else if (director.getAbout().isEmpty()){
            throw new DirectorExeption(DirectorValidatorMessages.EMPTY_ABOUT_FIELD);
        }

    }
}
