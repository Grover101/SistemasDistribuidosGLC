package com.parcial2.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parcial2.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
