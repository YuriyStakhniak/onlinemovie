package com.movies.controller;

import com.movies.validator.genreValidator.GenreValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.movies.entity.Genre;
import com.movies.service.GenreService;

@Controller
public class GenreController {
	@Autowired
	private GenreService genreservice;

	@GetMapping("/genre")
	public String genre(Model model){
		model.addAttribute("genres", genreservice.findAll());
		return "views-admin-genre";
	}
	
	@PostMapping("/genre")
	public String genre(@ModelAttribute Genre genre, Model model) throws Exception {

		try {
			genreservice.save(genre);
		}catch (Exception e){

			if ((e.getMessage().equals(GenreValidatorMessages.EMPTY_GENRE_FIELD))||
                    e.getMessage().equals(GenreValidatorMessages.THIS_GENRE_ALREADY_EXISTS)){
				model.addAttribute("genreNameExeption", e.getMessage());
			}
            model.addAttribute("genres", genreservice.findAll());
            return "views-admin-genre";
		}
		return "redirect:/genre";
	}


	@GetMapping("/deleteGenre/{id}")
	public String delete(@PathVariable int id){
        genreservice.delete(id);
        return "redirect:/genre";
		
	}
	
	@GetMapping("/updateGenre/{id}")
	public String update(@PathVariable int id, Model model){
		
		Genre genre = genreservice.findOne(id);
		model.addAttribute("currentGenre", genre);
		
		return "views-admin-updateGenre";
	}
	
	@PostMapping("/updateGenre/{id}")
	public String update(@PathVariable int id, @RequestParam String name, Model model) throws Exception {
		
		Genre genre = genreservice.findOne(id);
		genre.setName(name);
		try {
            genreservice.update(genre);
        }catch (Exception e){
		    if (e.getMessage().equals(GenreValidatorMessages.EMPTY_GENRE_FIELD)){
		        model.addAttribute("genreNameException", e.getMessage());

            }
            model.addAttribute("currentGenre", genre);
            return "views-admin-updateGenre";
        }
        return "redirect:/genre";
	}
}
