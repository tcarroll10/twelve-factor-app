package com.tcarroll10.twelvefactorapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.tcarroll10.twelvefactorapp.model.Movie;

public interface MovieRepo extends CrudRepository<Movie, String> {

}
