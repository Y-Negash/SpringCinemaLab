package com.example.cinema.controllers;

import com.example.cinema.models.Movie;

import com.example.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping()
    public ResponseEntity<List<Movie>> findMovies(){
        List<Movie> movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
}
    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> findMoviesById(@PathVariable long id){
        Movie movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable long id){
        movieService.updateMovie(movie, id);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable long id){
        Movie movie = movieService.deleteMovie(movieService.getMovieById(id));
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

//    Advanced extension

//    @GetMapping()
//    public ResponseEntity<Movie> findMovies(@RequestParam int maxDuration){
//        movieService.getShorterMovies(maxDuration);
//        return new ResponseEntity<>(movie, HttpStatus.OK);
//}
}
