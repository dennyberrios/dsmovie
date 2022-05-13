package com.myproject.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.dsmovie.entities.Score;
import com.myproject.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
