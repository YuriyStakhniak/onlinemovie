package com.movies.validator.userValidator;

/**
 * Created by Yura on 29.05.2017.
 */
public interface UserValidatorMessages {


    String EMPTY_USERNAME_FIELD = "EMPTY USERNAME FIELD";
    String USERNAME_ALREADY_EXIST = "USERNAME ALREADY EXIST";

    String EMPTY_EMAIL_FIELD = "EMPTY EMAIL FIELD";
    String EMAIL_ALREADY_EXIST = "EMAIL ALREADY EXIST";
    String WRONG_EMAIL = "WRONG_EMAIL! NEED @ SYMBOL";

    String EMPTY_PASSWORD_FIELD = "EMPTY PASSWORD FIELD";
    String TOO_SHORT_PASSWORD = "TOO SHORT PASSWORD";

}
