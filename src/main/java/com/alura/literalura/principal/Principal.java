package com.alura.literalura.principal;

import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {


    public void menu() {
        Scanner lectura = new Scanner(System.in);
        ConsumoAPI consumoAPI = new ConsumoAPI();
        ConvierteDatos convertirJacksonAClase = new ConvierteDatos();

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

                switch (opcionMenu){

                    case 1:
                        System.out.println("LIBROS POR TITULOS");
                        System.out.println("Ingrese titulo de libro a buscar: ");
                        var libroBuscado = lectura.nextLine();

                }

            } catch (Exception e) {
                System.out.println("ERROR | Ingrese opcion valida");
            }
        }
    }
}
