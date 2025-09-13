public class Libro {
    private String Titulo;
    private String Autor;
    private int AñoDePublic;
    private String Genero;
    private boolean Disponible;

    public Libro(String Titulo, String Autor, int AñoDePublic, String Genero) {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.AñoDePublic = AñoDePublic;
        this.Genero = Genero;
        this.Disponible = true; //
    }

    public String getTitulo() { return Titulo; }
    public String getAutor() { return Autor; }
    public int getAñoDePublic() { return AñoDePublic; }
    public String getGenero() { return Genero; }
    public boolean isDisponible() { return Disponible; }

    public void setTitulo(String Titulo) { this.Titulo = Titulo; }
    public void setAutor(String Autor) { this.Autor = Autor; }
    public void setAñoDePublic(int AñoDePublic) { this.AñoDePublic = AñoDePublic; }
    public void setGenero(String Genero) { this.Genero = Genero; }

    public boolean prestar() {
        boolean result = false;
        if (Disponible) {
            Disponible = false;
            result = true;
        }
        return result;
    }

    public void devolver() {
        Disponible = true;
    }

    @Override
    public String toString() {
        return "Título: " + Titulo + ", Autor: " + Autor + ", Año: " + AñoDePublic + ", Género: " + Genero + ", Disponible: " + (Disponible ? "Sí" : "No");
    }
}
