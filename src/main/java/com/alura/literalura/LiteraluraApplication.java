package com.alura.literalura;

import com.alura.literalura.principal.Principal;
import com.alura.literalura.repositorio.AutorRepository;
import com.alura.literalura.repositorio.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository librorepositorio;

	@Autowired  // Añadido para asegurar la inyección
	private AutorRepository autorrepositorio;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Creación del objeto principal con inyección de dependencias
		Principal principal = new Principal(librorepositorio, autorrepositorio);
		principal.menu();
	}
}
