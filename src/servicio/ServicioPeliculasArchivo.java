package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import dominio.Pelicula;

public class ServicioPeliculasArchivo implements IServicioPeliculas {

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo() {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            if (archivo.exists()) {
                System.out.println("El archivo ya existe!");
            }else{
                var salida = new PrintWriter(archivo);
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            System.out.println("Listado de peliculas");
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            while (linea != null) {
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agrego la pelicula " + pelicula);
        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            var indice = 0;
            var encontrada = false;
            var peliculaBuscar = pelicula.getNombreString();
            while (linea != null && !encontrada) {
                indice++;
                if(pelicula != null && peliculaBuscar.equalsIgnoreCase(linea)){
                    encontrada = true;
                }
                linea = entrada.readLine();
            }
            if(encontrada){
                System.out.println("Pelicula en el indice " + indice);
            }else{
                System.out.println("Pelicula no encontrada");
            }
            entrada.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }
    
}
