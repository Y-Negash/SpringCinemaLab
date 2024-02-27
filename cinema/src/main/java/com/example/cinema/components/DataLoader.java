package com.example.cinema.components;

import com.example.cinema.models.Movie;
import com.example.cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Movie movie = new Movie("Alien", "18", 117);
        Movie movie1 = new Movie("The Imitation Game", "12A", 114);
        Movie movie2 = new Movie("Iron Man", "12A",126);
        Movie movie3 = new Movie("The Martian", "12A",144);
        Movie movie4 = new Movie("Avengers: Endgame", "12A",181);
        movieRepository.save(movie);
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
        movieRepository.save(movie4);
    }
}
