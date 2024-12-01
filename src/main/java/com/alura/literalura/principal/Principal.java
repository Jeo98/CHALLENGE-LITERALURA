package com.alura.literalura.principal;

//import com.alura.literalura.model.Datos;

import com.alura.literalura.model.Datos;
import com.alura.literalura.model.Libro;
import com.alura.literalura.repositorio.AutorRepository;
import com.alura.literalura.repositorio.LibroRepository;
import com.alura.literalura.service.ConsultasBD;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static java.lang.System.exit;

public class Principal {
    private final String APIURL = "https://gutendex.com/books/";
    private ConsumoAPI API = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<Libro> listaDelibros = new ArrayList<>();
    Scanner lectura = new Scanner(System.in);
    String datosAPI = API.obtenerDatos(APIURL); //obtengo los datos de la API que contiene la informacion
    //convierto los datos que trae el metodo obtenerDatos,
    //los cuales son datos json convertidos a clase record Datos

    private LibroRepository libroRepositorio;
    private AutorRepository autorReporistorio;

    List<Libro> libros;
    private Optional<Libro> libroBuscado;

    public Principal(LibroRepository librorepositorio, AutorRepository autorreporistorio) {
        this.autorReporistorio = autorreporistorio;
        this.libroRepositorio = librorepositorio;
    }


    public void menu() {
        var datos = conversor.obtenerDatos(datosAPI, Datos.class);

        int opcion = -1;

        while (opcion == -1) {
            try {
                var menu =
                        """
                                    1 - Buscar libros por titulo
                                    2 - Ver libros registrados
                                    3 - Listar Autores registrados
                                    4 - Listar autores vivos en un determinado anio
                                    5 - Listar libros por idioma
                                    ----------
                                    0 - Salir
                                    ----------
                                """;
                System.out.println(menu);
                var opcionMenu = lectura.nextInt();
                lectura.nextLine();

                switch (opcionMenu) {

                    case 1:
                        buscarLibroPorTitulo();
                        break;

                    case 2:
                        verLibrosRegistrados();
                        break;

                    case 3:
                        verAutoresRegistrados();
                        break;

                    case 4:
                        autoresVivosEnAnio();
                        break;

                    case 5:
                        listarLibrosPorIdioma();
                        break:



                    case 0:
                        System.out.println("SALIDA | Gracias por utilizar LITERALURA!");
                        lectura.close();
                        opcion = 0;
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("ERROR | Ingrese opcion valida");
            }
        }
    }

    private void listarLibrosPorIdioma() {
        System.out.println("Ingresar IDIOMA(primeras dos letras): ");
        var idioma= lectura.nextLine();
        libroRepositorio.findByLanguage(idioma);
    }

    private void autoresVivosEnAnio() {
    }

    private void verAutoresRegistrados() {
    }

    private void verLibrosRegistrados() {
    }

    public void buscarLibroPorTitulo() {
        System.out.println("Ingresar titulo de libro a buscar: ");
        var libroBuscado = lectura.nextLine();
        libroRepositorio.findByTitleContainingIgnoreCase(libroBuscado).forEach(System.out::println);


    }
}
