package com.movies.controller;

import com.movies.service.OrdersService;
import com.movies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

/**
 * Created by Yura on 22.07.2017.
 */
@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private UserService userService;


    @GetMapping("/addToCart/{id}")
    public  String buy(Principal principal, @PathVariable int id, Model model){

        ordersService.addToCart(principal, id);

        return "redirect:/";
    }

//    @GetMapping("/profile")
//    public String profile(@ PathVariable int id, Model model){
//        model.addAttribute("userOrders", userService.findUserWithOrders(id));
//        return "views-user-profile";
//    }

    @GetMapping("/deleteFromCart/{userId}/{drinkId}")
    public String deleteFromBasket(@PathVariable int userId,
                                   @PathVariable int drinkId){

        ordersService.deleteFromCart(userId, drinkId);

        return "redirect:/profile";
    }

    @PostMapping("/buy")

    public String buy (Principal principal){

        ordersService.buy(Integer.parseInt(principal.getName()));

        return "redirect:/profile";
    }

}
