package com.movies.controller;


import com.movies.entity.User;
import com.movies.service.MailSenderService;
import com.movies.service.UserService;
import com.movies.validator.Validator;
import com.movies.validator.userValidator.UserValidatorMessages;
import com.movies.validator.userValidator.userLoginValidator.UserLoginValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;



    @Controller
    public class RegistrationController {

        @Autowired
        private UserService userService;

        @Autowired
        private MailSenderService mailSenderService;
        @Autowired
        @Qualifier("userLoginValidator")
        private Validator validator;

        @GetMapping("/register")
        public String signUp(Model model) {
            model.addAttribute("user", new User());
            return "views-user-register";
        }

        @PostMapping("/register")
        public String signUp(@ModelAttribute User user, Model model) {

            String uuid = UUID.randomUUID().toString();
            user.setUuid(uuid);

            try {
                userService.save(user);
            } catch (Exception e) {

                if (e.getMessage().equals(UserValidatorMessages.EMPTY_USERNAME_FIELD) ||
                        e.getMessage().equals(UserValidatorMessages.USERNAME_ALREADY_EXIST)) {

                    model.addAttribute("usernameException", e.getMessage());

                } else if (e.getMessage().equals(UserValidatorMessages.EMPTY_EMAIL_FIELD) ||
                        e.getMessage().equals(UserValidatorMessages.EMAIL_ALREADY_EXIST) ||
                        e.getMessage().equals(UserValidatorMessages.WRONG_EMAIL)) {

                    model.addAttribute("emailException", e.getMessage());
                } else if (e.getMessage().equals(UserValidatorMessages.EMPTY_PASSWORD_FIELD) ||
                        e.getMessage().equals(UserValidatorMessages.TOO_SHORT_PASSWORD)) {
                    model.addAttribute("passwordException", e.getMessage());
                }


                return "views-user-register";
            }
            String theme = "thank's for registration";
            String mailBody =
                    "gl & hf       http://localhost:8080/confirm/" + uuid;

            mailSenderService.sendMail(theme, mailBody, user.getEmail());

            return "redirect:/";
        }

        @GetMapping("/confirm/{uuid}")
        public String confirm(@PathVariable String uuid) {

            User user = userService.findByUuid(uuid);
            user.setEnable(true);

            userService.update(user);

            return "redirect:/";
        }

        @PostMapping("/failureLogin")
        public String failureLogin(Model model, @RequestParam String username, @RequestParam String password) {

            try {

                validator.validate(new User(username, password));

            } catch (Exception e) {

                if (e.getMessage().equals(UserLoginValidatorMessages.EMPTY_PASSWORD_FIELD) ||
                        e.getMessage().equals(UserLoginValidatorMessages.EMPTY_USERNAME_FIELD) ||
                        e.getMessage().equals(UserLoginValidatorMessages.WRONG_USERNAME_OR_PASSWORD)) {
                    model.addAttribute("exception", e.getMessage());

                }


            }
            model.addAttribute("user", new User());

            return "views-user-register";
        }

        @GetMapping("/profile")
        public String profile(Principal principal, Model model) {

            model.addAttribute("userCart", userService.findUserWithMovies(Integer.parseInt(principal.getName())));
            model.addAttribute("userOrders", userService.findUserWithOrders(Integer.parseInt(principal.getName())));
            return "views-user-profile";


        }
    }





