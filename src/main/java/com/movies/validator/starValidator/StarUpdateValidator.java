package com.movies.validator.starValidator;

import com.movies.entity.Star;
import com.movies.validator.Validator;
import org.springframework.stereotype.Component;

/**
 * Created by Yura on 03.07.2017.
 */
@Component
public class StarUpdateValidator implements Validator {
    @Override
    public void validate(Object o) throws Exception {

        Star star = (Star) o;

        if (star.getName().isEmpty()){

            throw new StarExeption(StarValidatorMessages.EMPTY_STARNAME_FIELD);

        }else if (star.getAbout().isEmpty()){

            throw new StarExeption(StarValidatorMessages.EMPTY_ABOUT_FIELD);
        }

    }
}
