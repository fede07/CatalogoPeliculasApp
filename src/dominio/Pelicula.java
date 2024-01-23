package dominio;

public class Pelicula {
    private String nombreString;
    
    public Pelicula(){}

    public Pelicula(String nombreString) {
        this.nombreString = nombreString;
    }

    public String getNombreString() {
        return nombreString;
    }

    public void setNombreString(String nombreString) {
        this.nombreString = nombreString;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombreString == null) ? 0 : nombreString.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pelicula other = (Pelicula) obj;
        if (nombreString == null) {
            if (other.nombreString != null)
                return false;
        } else if (!nombreString.equals(other.nombreString))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.nombreString;
    }
    
    public static void main(String[] args) {
        var peliculaTest = new Pelicula("Pelicula Test");
        System.out.println(peliculaTest);
    }
    
}
