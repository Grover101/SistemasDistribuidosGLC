package com.biblioteca.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
