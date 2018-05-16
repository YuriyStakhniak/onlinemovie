package com.movies.controller;

import com.movies.dao.StarDao;
import com.movies.validator.starValidator.StarValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.movies.entity.Star;
import com.movies.service.StarService;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@Controller
public class StarController {
	@Autowired
	private StarService starService;
	@Autowired
	private StarDao starDao;

	@GetMapping("/star")
	public String star(Model model) {
		model.addAttribute("stars", starService.findAll());

		return "views-admin-star";
	}

	@PostMapping("/star")
	public String star(@ModelAttribute Star star, Model model, @RequestParam MultipartFile image) {
		try {
            starService.save(star, image);
		} catch (Exception e) {
			if (e.getMessage().equals(StarValidatorMessages.EMPTY_STARNAME_FIELD) ||
					(e.getMessage().equals(StarValidatorMessages.STARNAME_ALREADY_EXISTS))) {

				model.addAttribute("starNameException", e.getMessage());

			}else if (e.getMessage().equals(StarValidatorMessages.EMPTY_ABOUT_FIELD)){
				model.addAttribute("starAboutException", e.getMessage());
			}

			model.addAttribute("stars", starService.findAll());
			return "views-admin-star";
		}
		return "redirect:/star";
	}

	@GetMapping("/deleteStar/{id}")
	public String deleteStar(@PathVariable int id) {
		starService.delete(id);
		return "redirect:/star";
	}

	@GetMapping("/updateStar/{id}")
	public String updateStar(@PathVariable int id, Model model) {
		Star star = starService.findOne(id);
		model.addAttribute("currentStar", star);
		return "views-admin-updateStar";

	}

	@PostMapping("/updateStar/{id}")


	public String update(@PathVariable int id, @RequestParam String name,
						 @RequestParam String about, @RequestParam MultipartFile image, Model model) throws Exception {

		Star star = starService.findOne(id);
		star.setName(name);
		star.setAbout(about);
		try {
			starService.update(star, image);
		} catch (Exception e) {

			if (e.getMessage().equals(StarValidatorMessages.EMPTY_STARNAME_FIELD) ||
					(e.getMessage().equals(StarValidatorMessages.STARNAME_ALREADY_EXISTS))) {

				model.addAttribute("starNameException", e.getMessage());

			}else if (e.getMessage().equals(StarValidatorMessages.EMPTY_ABOUT_FIELD)){

			    model.addAttribute("starAboutException", e.getMessage());
            }
			model.addAttribute("currentStar", star);
			return "views-admin-updateStar";
		}

			return "redirect:/star";


	}
}