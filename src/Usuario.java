import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nombre;
    private ArrayList<Libro> librosPrestados;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    //Devolver y prestar
    public void prestarLibro(Libro libro) {
        librosPrestados.add(libro);
    }

    public void devolverLibro(Libro libro) {
        librosPrestados.remove(libro);
    }

    @Override
    public String toString() {
        return "Usuario: "+"Número de identificación:" + id + ", Nombre:" + nombre + ", librosPrestados:" + librosPrestados.size();
    }
}
