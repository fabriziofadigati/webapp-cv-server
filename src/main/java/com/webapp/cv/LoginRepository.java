package com.webapp.cv;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {

	

	Optional<Login> findByUsername(String username);

	Optional<Login> findByPassword(String password);

	
	

}
