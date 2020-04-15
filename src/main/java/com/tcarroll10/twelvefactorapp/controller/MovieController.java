package com.tcarroll10.twelvefactorapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcarroll10.twelvefactorapp.model.Movie;
import com.tcarroll10.twelvefactorapp.repository.MovieRepo;

@RestController
public class MovieController {

	private static Logger LOG = LoggerFactory.getLogger(MovieController.class);

	@Autowired
	private MovieRepo movieRepo;

	@PostMapping("/movies")
	public ResponseEntity<?> create(@RequestBody Iterable<Movie> movies) {
		LOG.info("Input Movie: {}", movies);
		return new ResponseEntity<>(movieRepo.saveAll(movies), HttpStatus.OK);
	}

	@GetMapping("/movies")
	public Iterable<Movie> retrieveAllMovies() {
		return movieRepo.findAll();
	}

}
