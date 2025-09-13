import java.util.ArrayList;

public class Usuario {
    private int ID;
    private String Nombre;
    private ArrayList<Libro> LibrosPrestados;

    public Usuario(int id, String nombre) {
        this.ID = id;
        this.Nombre = nombre;
        this.LibrosPrestados = new ArrayList<>();
    }

    public int getId() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public ArrayList<Libro> getLibrosPrestados() {
        return LibrosPrestados;
    }

    public void prestarLibro(Libro libro) {
        LibrosPrestados.add(libro);
    }

    public void devolverLibro(Libro libro) {
        LibrosPrestados.remove(libro);
    }

    @Override
    public String toString() {
        return "Usuario: "+"Número de identificación:" + ID + ", Nombre:" + Nombre + ", librosPrestados=" + LibrosPrestados.size();
    }
}
