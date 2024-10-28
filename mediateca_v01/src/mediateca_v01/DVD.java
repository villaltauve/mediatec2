package mediateca_v01;

public class DVD extends Material {
    private String director;
    private String genero;
    private int duracion;

    public DVD(String id, String titulo, String director, int duracion, String genero) {
        super(id, titulo, 0);
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String getDetalles() {
        return "DVD: " + titulo + ", Dirigida por: " + director + ", Genero: " + genero + ", Duracion: " + duracion + " minutos";
    }
}


