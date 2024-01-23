package presentacion;

import java.util.Scanner;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasArchivo;
//1import servicio.ServicioPeliculasLista;

public class CatalogoPeliculasApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        //IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivo();
        while (!salir) {
            try{
                mostrarMenu();
                salir = ejecutarOpciones(consola, servicioPeliculas);
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static boolean ejecutarOpciones(Scanner consola, IServicioPeliculas servicioPeliculas) {
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion) {
            case 1 -> {
                System.out.print("Introduce el nombre de la pelicula: ");
                var nombrePelicula = consola.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));
            }
            case 2 -> {
                servicioPeliculas.listarPeliculas();
            }
            case 3 -> {
                System.out.print("Pelicula a buscar: ");
                var buscar = consola.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscar));
            }
            case 4 -> {
                System.out.println("Goodbye!");
                salir = true;
            }
            default -> System.out.println("Opcion no reconocida.");
        }
        return salir;
    }

    private static void mostrarMenu() {
        System.out.println("""
                *** Catalogo de Peliculas ***
                1. Agregar pelicula
                2. Listar Peliculas
                3. Buscar pelicula
                4. Salir
                """);
    }
    
}
