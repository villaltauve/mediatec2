package mediateca_v01;

public class Revista extends Material {
    private String editorial;
    private String periodicidad;
    private String fechaPublicacion;

    public Revista(String id, String titulo, String editorial, String periodicidad, String fechaPublicacion, int unidadesDisponibles) {
        super(id, titulo, unidadesDisponibles);
        this.editorial = editorial;
        this.periodicidad = periodicidad;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setperiodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getfechaPublicacion() {
        return fechaPublicacion;
    }

    public void setfechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String getDetalles() {
        return "Revista: " + titulo + ", Editorial: " + editorial + ", Periodicidad: " + periodicidad + ", Publicada el: " + fechaPublicacion;
    }
}


