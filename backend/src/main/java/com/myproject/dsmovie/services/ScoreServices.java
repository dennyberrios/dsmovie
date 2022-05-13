package com.myproject.dsmovie.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dsmovie.dto.MovieDTO;
import com.myproject.dsmovie.dto.ScoreDTO;
import com.myproject.dsmovie.entities.Movie;
import com.myproject.dsmovie.entities.Score;
import com.myproject.dsmovie.entities.User;
import com.myproject.dsmovie.repositories.MovieRepository;
import com.myproject.dsmovie.repositories.ScoreRepository;
import com.myproject.dsmovie.repositories.UserRepository;
@Service
public class ScoreServices {
	
	@Autowired
    private MovieRepository movieRepository;
    
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user =userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
}