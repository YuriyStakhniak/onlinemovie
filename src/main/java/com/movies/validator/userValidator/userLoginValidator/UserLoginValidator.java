package com.movies.validator.userValidator.userLoginValidator;

import com.movies.dao.UserDao;
import com.movies.entity.User;
import com.movies.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Yura on 22.07.2017.
 */
@Component
public class UserLoginValidator implements Validator {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void validate(Object o) throws Exception {
        User user = (User) o;

        if (user.getName().isEmpty()) {
            throw new UserLoginException(UserLoginValidatorMessages.EMPTY_USERNAME_FIELD);
        } else if (userDao.findByName(user.getName()) == null) {
            throw new UserLoginException(UserLoginValidatorMessages.WRONG_USERNAME_OR_PASSWORD);
        } else if (encoder.matches(user.getPassword(),
                userDao.findByName(user.getName()).getPassword())){
            throw new UserLoginException(UserLoginValidatorMessages.WRONG_USERNAME_OR_PASSWORD);
        }

    }
}
