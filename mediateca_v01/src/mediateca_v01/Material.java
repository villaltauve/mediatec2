package mediateca_v01;

public abstract class Material {
    protected String id;
    protected String titulo;
    protected int unidadesDisponibles;

    public Material(String id, String titulo, int unidadesDisponibles) {
        this.id = id;
        this.titulo = titulo;
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitle(String titulo) {
        this.titulo = titulo;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public abstract String getDetalles();
}
