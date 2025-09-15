import java.io.Serializable;

public class Libro implements Serializable {
    private String titulo;
    private String autor;
    private int añoDePublic;
    private String genero;
    private boolean disponible;

    public Libro(String titulo, String autor, int añoDePublic, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoDePublic = añoDePublic;
        this.genero = genero;
        this.disponible = true;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAñoDePublic() { return añoDePublic; }
    public String getGenero() { return genero; }
    public boolean isDisponible() { return disponible; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setAñoDePublic(int añoDePublic) { this.añoDePublic = añoDePublic; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setDisponible(Boolean disponible) {this.disponible = disponible;}

    public boolean prestar() {
        boolean result = false;
        if (disponible) {
            disponible = false;
            result = true;
        }
        return result;
    }

    public void devolver() {
        disponible = true;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Año: " + añoDePublic + ", Género: " + genero + ", Disponible: " + (disponible ? "Sí" : "No");
    }
}
