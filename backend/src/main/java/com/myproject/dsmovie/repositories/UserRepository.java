package com.myproject.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
