package servicio;

import java.util.ArrayList;
import java.util.List;

import dominio.Pelicula;

public class ServicioPeliculasLista implements IServicioPeliculas {

    private final List<Pelicula> peliculas;
    

    public ServicioPeliculasLista() {
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var indice = peliculas.indexOf(pelicula);
        if (indice >= 0){
            System.out.println("Pelicula en el indice " + indice);
        }else{
            System.out.println("Pelicula no encontrada");
        }
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado de Peliculas...");
        peliculas.forEach(System.out::println);        
    }

    public static void main(String[] args) {
        var pelicula1 = new Pelicula("Batman");
        var pelicula2 = new Pelicula("Superman");

        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);
        servicioPeliculas.buscarPelicula(pelicula1);
        servicioPeliculas.listarPeliculas();
    }
    
}
