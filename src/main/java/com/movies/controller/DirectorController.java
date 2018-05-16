package com.movies.controller;

import com.movies.entity.Director;
import com.movies.service.DirectorService;
import com.movies.service.MovieService;
import com.movies.validator.directorValidator.DirectorValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
@Controller
public class DirectorController {

    @Autowired
    private DirectorService directorService;
    @Autowired
    private MovieService movieService;

    @GetMapping("/director")
    public String director(Model model){

        model.addAttribute("directors", directorService.directorsWithMovies());
        model.addAttribute("movies", movieService.findAll());

        return "views-admin-director";

    }
    @PostMapping("/director")
    public String director(@ModelAttribute Director director,
                           @RequestParam String name,
                           @RequestParam String about,
                           @RequestParam MultipartFile image, Model model)
            throws Exception {

        try {
            directorService.save(director, name, about, image);
        }catch (Exception e){

            if ((e.getMessage().equals(DirectorValidatorMessages.EMPTY_NAME_FIELD))||
                    (e.getMessage().equals(DirectorValidatorMessages.THIS_DIRECTOR_ALREADY_EXISTS)) ){
                model.addAttribute("directorNameException", e.getMessage());
            }else if (e.getMessage().equals(DirectorValidatorMessages.EMPTY_ABOUT_FIELD)){
                model.addAttribute("directorAboutException", e.getMessage());
            }

            model.addAttribute("directors", directorService.directorsWithMovies());
            model.addAttribute("movies", movieService.findAll());


            return "views-admin-director";

        }

        return "redirect:/director";

    }

    @GetMapping("/deleteDirector/{id}")
    public String delete(@PathVariable int id) throws Exception {
        directorService.delete(id);
        return "redirect:/director";
    }

    @GetMapping("/updateDirector/{id}")
    public String update(@PathVariable int id, Model model){

        model.addAttribute("currentDirector", directorService.directorWithMovies(id));
        model.addAttribute("movies", movieService.findAll());
        return "views-admin-updateDirector";

    }
    @PostMapping("/updateDirector/{id}")
    public String update(@PathVariable int id, @RequestParam String name, @RequestParam String about,
                         @RequestParam MultipartFile image, Model model) throws Exception {

        Director director = directorService.findOne(id);
        director.setName(name);
        director.setAbout(about);
        try {
            directorService.update(director, name, about, image);
        }catch (Exception e){
            if (e.getMessage().equals(DirectorValidatorMessages.EMPTY_NAME_FIELD)){
                model.addAttribute("directorNameException", e.getMessage());
            }else if (e.getMessage().equals(DirectorValidatorMessages.EMPTY_ABOUT_FIELD)){
                model.addAttribute("directorAboutException", e.getMessage());
            }

            model.addAttribute("currentDirector", director);



            return "views-admin-updateDirector";
        }
        return "redirect:/director";
    }

}
