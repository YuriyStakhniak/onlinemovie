package com.movies.validator.userValidator;

import com.movies.dao.UserDao;
import com.movies.entity.User;
import com.movies.validator.Validator;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Yura on 29.05.2017.
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDao userDao;

    public void validate(Object o) throws Exception {
        User user = (User) o;
        if(user.getName().isEmpty()){
            throw new UserExeption(UserValidatorMessages.EMPTY_USERNAME_FIELD);
        }else if(userDao.findByName(user.getName()) != null){
            throw new UserExeption(UserValidatorMessages.USERNAME_ALREADY_EXIST);
        }else if(user.getEmail().isEmpty()){
            throw new UserExeption(UserValidatorMessages.EMPTY_EMAIL_FIELD);
        }else if(!user.getEmail().contains("@")){
            throw new UserExeption(UserValidatorMessages.WRONG_EMAIL);
        }else if(userDao.findByEmail(user.getEmail()) != null){
            throw new UserExeption(UserValidatorMessages.EMAIL_ALREADY_EXIST);
        }else if(user.getPassword().isEmpty()){
            throw new UserExeption(UserValidatorMessages.EMPTY_PASSWORD_FIELD);
        }else if(user.getPassword().length()<4){
            throw  new UserExeption(UserValidatorMessages.TOO_SHORT_PASSWORD);
        }

        }
    }


