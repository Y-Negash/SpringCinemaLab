package com.example.cinema.services;

import com.example.cinema.models.Movie;
import com.example.cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;


    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(long id) {
        return movieRepository.findById(id).get();
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void updateMovie(Movie movie, long id) {
        movie.setTitle(movie.getTitle());
        movie.setRating(movie.getRating());
        movie.setDuration(movie.getDuration());
        movie.setId(id);
        movieRepository.save(movie);
    }

    public Movie deleteMovie(Movie movie) {
        movieRepository.delete(movie);
        return movie;
    }

//    public Movie getShorterMovies(int maxDuration) {
//      if movie duration is greater than maxDuration, save movie
//          else delete from database
//           return just the movies less than maxDuration
//    }

}
