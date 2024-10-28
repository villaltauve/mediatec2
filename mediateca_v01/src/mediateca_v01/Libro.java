package mediateca_v01;
public class Libro extends Material {
    private String autor;
    private int paginas;
    private String editorial;
    private String isbn;
    private int anio;

    public Libro(String id, String titulo, String autor, int paginas, String editorial, String isbn, int anio, int unidadesDisponibles) {
        super(id, titulo, unidadesDisponibles);
        this.autor = autor;
        this.paginas = paginas;
        this.editorial = editorial;
        this.isbn = isbn;
        this.anio = anio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPages(int paginas) {
        this.paginas = paginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override 
    public String getDetalles() {
        return "Libro: " + titulo + " de " + autor + " (" + anio + "), ISBN: " + isbn + ", Paginas: " + paginas + ", editorial: " + editorial;
    }
}
