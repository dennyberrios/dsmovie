package com.myproject.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
