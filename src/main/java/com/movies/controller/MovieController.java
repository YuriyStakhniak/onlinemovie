package com.movies.controller;


import com.movies.service.DirectorService;
import com.movies.validator.movieValidator.MovieValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.movies.entity.Movie;
import com.movies.service.GenreService;
import com.movies.service.MovieService;
import com.movies.service.StarService;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;


@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private GenreService genreservice;
    @Autowired
    private StarService starservice;
    @Autowired
    private DirectorService directorService;




    @GetMapping("/movie")
    public String movie(Model model) {


        model.addAttribute("movies", movieService.moviesWithGenresAndStarsAndDirectors());
        model.addAttribute("directors", directorService.findAll());
        model.addAttribute("genres", genreservice.findAll());
        model.addAttribute("stars", starservice.findAll());

        return "views-admin-movie";

    }

    @PostMapping("/movie")
    public String movie(@RequestParam String title,
                        @RequestParam("genresId") ArrayList<Integer> genresId,
                        @RequestParam ArrayList<Integer> starsId,
                        @RequestParam String yearMovie,
                        @RequestParam String imdbRatingMovie,
                        @RequestParam String descriptionMovie,
                        @RequestParam MultipartFile image,
                        @RequestParam ArrayList<Integer> directorsId,
                        Model model) throws Exception {


        Movie movieIn = new Movie(title, yearMovie, imdbRatingMovie, descriptionMovie);


        try {
            movieService.save(movieIn, genresId, starsId, image, directorsId);
        } catch (Exception e) {

            if ((e.getMessage().equals(MovieValidatorMessages.EMPTY_MOVIE_TITLE_FIELD)) ||
                    (e.getMessage().equals(MovieValidatorMessages.MOVIE_TITLE_ALREADY_EXISTS))) {

                model.addAttribute("movieTitleException", e.getMessage());
            } else if (e.getMessage().equals(MovieValidatorMessages.EMPTY_IMDB_RATING_FIELD)) {
                model.addAttribute("imdbRaitingException", e.getMessage());
            } else if (e.getMessage().equals(MovieValidatorMessages.EMPTY_MOVIE_DESCRIPTION_FIELD)) {
                model.addAttribute("descriptionException", e.getMessage());
            } else if (e.getMessage().equals(MovieValidatorMessages.EMPTY_YEAR_FIELD)) {
                model.addAttribute("yearException", e.getMessage());
            } else if (e.getMessage().equals(MovieValidatorMessages.NO_GENRES_SELECTED)) {
                model.addAttribute("genreException", e.getMessage());
            } else if (e.getMessage().equals(MovieValidatorMessages.NO_STAR_SELECTED))
                model.addAttribute("starException", e.getMessage());


            model.addAttribute("movies", movieService.moviesWithGenresAndStarsAndDirectors());
            model.addAttribute("genres", genreservice.findAll());
            model.addAttribute("stars", starservice.findAll());
            model.addAttribute("directors", directorService.findAll());

            return "views-admin-movie";
        }

        return "redirect:/movie";

    }

    @GetMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable int id) {

        movieService.delete(id);

        return "redirect:/movie";
    }

    @GetMapping("/updateMovie/{id}")
    public String update(@PathVariable int id, Model model) {

        Movie movie = movieService.findMovieWithDirectorsAndMoviesAndStars(id);
        model.addAttribute("currentMovie", movie);
        model.addAttribute("genres", genreservice.findAll());
        model.addAttribute("stars", starservice.findAll());
        model.addAttribute("directors", directorService.findAll());

        return "views-admin-updateMovie";
    }


    @PostMapping("/updateMovie/{id}")
    public String update(@PathVariable int id, @RequestParam String title,
                         @RequestParam ArrayList<Integer> genresId,
                         @RequestParam ArrayList<Integer> starsId, @RequestParam String year,
                         @RequestParam String imdbRating, @RequestParam String description,
                         @RequestParam MultipartFile image,
                         @RequestParam ArrayList<Integer> directorsId, Model model) throws Exception {

        Movie movie = movieService.findMovieWithDirectorsAndMoviesAndStars(id);
        movie.setTitle(title);
        movie.setYear(year);
        movie.setImdbRating(imdbRating);
        movie.setDescription(description);
        movie.setId(id);
        try {

            movieService.update(movie, title, genresId, starsId, year, imdbRating, description, image, directorsId);

        } catch (Exception e) {

            if ((e.getMessage().equals(MovieValidatorMessages.EMPTY_MOVIE_TITLE_FIELD))) {
                model.addAttribute("movieTitleException", e.getMessage());
            } else if (e.getMessage().equals(MovieValidatorMessages.EMPTY_IMDB_RATING_FIELD)) {
                model.addAttribute("imdbRaitingException", e.getMessage());
            } else if (e.getMessage().equals(MovieValidatorMessages.EMPTY_MOVIE_DESCRIPTION_FIELD)) {
                model.addAttribute("descriptionException", e.getMessage());
            } else if (e.getMessage().equals(MovieValidatorMessages.EMPTY_YEAR_FIELD)) {
                model.addAttribute("yearException", e.getMessage());
            }


            model.addAttribute("currentMovie", movie);
            model.addAttribute("genres", genreservice.findAll());
            model.addAttribute("stars", starservice.findAll());
            model.addAttribute("directors", directorService.findAll());

            return "views-admin-updateMovie";
        }

        return "redirect:/movie";

    }


}
