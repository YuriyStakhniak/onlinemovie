package com.movies.validator.starValidator;

import com.movies.dao.StarDao;
import com.movies.entity.Star;
import com.movies.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Yura on 07.06.2017.
 */

@Component
public class StarValidator implements Validator {

    @Autowired
    private StarDao starDao;

    @Override
    public void validate(Object o) throws Exception {

        Star star = (Star) o;
        if (star.getName().isEmpty()){

            throw new StarExeption(StarValidatorMessages.EMPTY_STARNAME_FIELD);

        }else if (starDao.findByName(star.getName()) !=null){

            throw new StarExeption(StarValidatorMessages.STARNAME_ALREADY_EXISTS);

        }else if (star.getAbout().isEmpty()){

            throw  new StarExeption(StarValidatorMessages.EMPTY_ABOUT_FIELD);

        }


    }
}
