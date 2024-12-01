package com.alura.literalura.repositorio;

import com.alura.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTitleContainingIgnoreCase(String title);
    //Busca por titulo ignorando tipo de letra
    List<Libro> findByLanguage(String language);



}
