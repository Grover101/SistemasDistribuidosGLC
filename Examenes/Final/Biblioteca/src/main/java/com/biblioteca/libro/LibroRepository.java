package com.biblioteca.libro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    //User findByUsername(String username);
}
