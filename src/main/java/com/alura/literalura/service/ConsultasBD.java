package com.alura.literalura.service;

import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Libro;
import com.alura.literalura.repositorio.AutorRepository;
import com.alura.literalura.repositorio.LibroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConsultasBD {

    private final LibroRepository bookRepository;
    private final AutorRepository authorRepository;

    public ConsultasBD(LibroRepository bookRepository, AutorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Libro> searchBooksByName(String nombreLibro) {
        return bookRepository.findByTitleContainingIgnoreCase(nombreLibro);
    }

    public List<Libro> listaCompletaDeLibros() {
        return bookRepository.findAll();
    }

    public List<Autor> ListaCompletaDeAutores() {
        return authorRepository.findAll();
    }

    public List<Autor> AutoresVivos(int year) {
        return authorRepository.findByDeathDateAfterOrDeathDateIsNull(LocalDate.of(year, 1, 1));
    }

    public List<Libro> LibrosPorIdioma(String language) {
        return bookRepository.findByLanguage(language);
    }
}
