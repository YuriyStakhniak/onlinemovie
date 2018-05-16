package com.movies.controller;

import com.movies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.movies.service.MovieService;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class IndexController {
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index(Model model, Principal principal, @PageableDefault Pageable pageable){

		model.addAttribute("movie", movieService.findAllPages(pageable));

		model.addAttribute("movies", movieService.moviesWithGenresAndStarsAndDirectors());

		if (principal == null || principal.getName().equals("admin")){
			return "views-base-index";
		}else {

			model.addAttribute("user", userService.findUserWithMovies(Integer.parseInt(principal.getName())));

		}


		return "views-base-index";

	}
	@PostMapping("/")
	public String indexAfterLogin(Model model, Principal principal, String username){

		model.addAttribute("movies", movieService.moviesWithGenresAndStarsAndDirectors());
		if(username.equals("admin")){
			return "views-base-index";
		}else{
			model.addAttribute("user", userService.findUserByNameWithMovies(username));
			return "views-base-index";
		}



	}

}
