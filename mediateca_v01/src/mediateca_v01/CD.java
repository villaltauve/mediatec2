package mediateca_v01;

public class CD extends Material {
    private String artista;
    private String genero;
    private int duracion;
    private int numCanciones;

    public CD(String id, String titulo, String artista, String genero, int duracion, int numCanciones, int unidadesDisponibles) {
        super(id, titulo, unidadesDisponibles);
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
        this.numCanciones = numCanciones;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
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

    public int getNumCanciones() {
        return numCanciones;
    }

    public void setNumSongs(int numCanciones) {
        this.numCanciones = numCanciones;
    }

    @Override
    public String getDetalles() {
        return "CD: " + titulo + " de " + artista + ", Genero: " + genero + ", Duracion: " + duracion + " minutos, Canciones: " + numCanciones;
    }
}


