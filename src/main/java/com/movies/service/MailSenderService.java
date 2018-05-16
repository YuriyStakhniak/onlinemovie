package com.movies.service;

/**
 * Created by Yura on 09.06.2017.
 */
public interface MailSenderService {

    void sendMail(String theme, String mailBody, String email);

}
