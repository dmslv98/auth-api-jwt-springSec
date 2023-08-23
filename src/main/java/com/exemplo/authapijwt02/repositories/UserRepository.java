package com.exemplo.authapijwt02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.exemplo.authapijwt02.entities.user.User;



public interface UserRepository extends JpaRepository<User, String> {

	UserDetails findByLogin(String login);
}
