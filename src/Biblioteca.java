import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Biblioteca {
    private Map<String, Libro> libros;
    private Map<Integer, Usuario> usuarios;
    private static final String ARCHIVO_LIBROS = "libros.dat";
    private static final String ARCHIVO_USUARIOS = "usuarios.dat";

    public Biblioteca() {
        this.libros = new HashMap<>();
        this.usuarios = new HashMap<>();
        cargarDatos();
    }

    public void registrarLibro(Libro libro) {
        libros.put(libro.getTitulo().toLowerCase(), libro);
        guardarDatos();
    }

    public Libro buscarLibro(String titulo) {
        return libros.get(titulo.toLowerCase());
    }

    public List<Libro> listarTodosLosLibros() {
        return new ArrayList<>(libros.values());
    }

    public List<Libro> listarLibrosPorDisponibilidad(boolean disponible) {
        return libros.values().stream()
                .filter(libro -> libro.isDisponible() == disponible)
                .collect(Collectors.toList());
    }

    public List<Libro> listarLibrosPorGenero(String genero) {
        return libros.values().stream()
                .filter(libro -> libro.getGenero().equalsIgnoreCase(genero))
                .collect(Collectors.toList());
    }

    public void registrarUsuario(Usuario usuario) {
        if (usuarios.containsKey(usuario.getId())) {
            System.out.println("Ya existe un usuario con este ID: " + usuario.getId());
        } else {
            usuarios.put(usuario.getId(), usuario);
            guardarDatos();
        }
    }


    public Usuario buscarUsuario(int id) {
        return usuarios.get(id);
    }

    public List<Usuario> listarTodosLosUsuarios() {
        return new ArrayList<>(usuarios.values());
    }

    public boolean prestarLibro(int idUsuario, String tituloLibro) {
        Libro libro = buscarLibro(tituloLibro);
        Usuario usuario = buscarUsuario(idUsuario);

        if (libro != null && usuario != null && libro.isDisponible()) {
            libro.setDisponible(false);
            usuario.prestarLibro(libro);
            guardarDatos();
            return true;
        }
        return false;
    }

    public boolean devolverLibro(int idUsuario, String tituloLibro) {
        Libro libro = buscarLibro(tituloLibro);
        Usuario usuario = buscarUsuario(idUsuario);

        if (libro != null && usuario != null && !libro.isDisponible()) {
            libro.setDisponible(true);
            usuario.devolverLibro(libro);
            guardarDatos();
            return true;
        }
        return false;
    }

    private void guardarDatos() {
        try (ObjectOutputStream oosLibros = new ObjectOutputStream(new FileOutputStream(ARCHIVO_LIBROS));
             ObjectOutputStream oosUsuarios = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS))) {
            oosLibros.writeObject(new HashMap<>(libros));
            oosUsuarios.writeObject(new HashMap<>(usuarios));
            System.out.println("Datos guardados exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    private void cargarDatos() {
        File fileLibros = new File(ARCHIVO_LIBROS);
        File fileUsuarios = new File(ARCHIVO_USUARIOS);

        if (fileLibros.exists() && fileUsuarios.exists()) {
            try (ObjectInputStream oisLibros = new ObjectInputStream(new FileInputStream(fileLibros));
                 ObjectInputStream oisUsuarios = new ObjectInputStream(new FileInputStream(fileUsuarios))) {
                libros = (Map<String, Libro>) oisLibros.readObject();
                usuarios = (Map<Integer, Usuario>) oisUsuarios.readObject();
                System.out.println("Datos cargados exitosamente.");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al cargar los datos: " + e.getMessage());
            }
        }
    }
}
