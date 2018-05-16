//package com.movies.controller;
//
//
//import com.movies.entity.User;
//import com.movies.service.MailSenderService;
//import com.movies.service.UserService;
//import com.movies.validator.userValidator.UserValidatorMessages;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.UUID;
//
//@Controller
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private MailSenderService mailSenderService;
//
//    @GetMapping("/signUp")
//    public String signUp(Model model) {
//        model.addAttribute("user", new User());
//        return "user/signUp";
//    }
//
//    @PostMapping("/signUp")
//    public String signUp(@ModelAttribute User user, Model model) {
//
//        String uuid = UUID.randomUUID().toString();
//        user.setUuid(uuid);
//
//        try {
//            userService.save(user);
//        } catch (Exception e) {
//
//            if (e.getMessage().equals(UserValidatorMessages.EMPTY_USERNAME_FIELD) ||
//                    e.getMessage().equals(UserValidatorMessages.USERNAME_ALREADY_EXIST)) {
//
//                model.addAttribute("usernameException", e.getMessage());
//
//            }
//
//
//            return "user/signUp";
//        }
//        String theme = "thank's for registration";
//        String mailBody =
//                "gl & hf       http://localhost:8080/confirm/" + uuid;
//
//        mailSenderService.sendMail(theme, mailBody, user.getEmail());
//
//        return "redirect:/";
//    }
//
//    @GetMapping("/confirm/{uuid}")
//    public String confirm(@PathVariable String uuid) {
//
//        User user = userService.findByUuid(uuid);
//        user.setEnable(true);
//
//        userService.update(user);
//
//        return "redirect:/";
//    }
//
//
//}
//
//
//
