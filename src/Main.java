import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n Sistema de Gestión de Biblioteca ");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Listar todos los libros");
            System.out.println("4. Listar libros por género");
            System.out.println("5. Listar libros por disponibilidad");
            System.out.println("6. Prestar libro");
            System.out.println("7. Devolver libro");
            System.out.println("8. Listar usuarios");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Año de publicación: ");
                    int año = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Género: ");
                    String genero = scanner.nextLine();
                    Libro libro = new Libro(titulo, autor, año, genero);
                    biblioteca.registrarLibro(libro);
                    System.out.println("Libro registrado correctamente.");
                    break;

                case 2:
                    System.out.print("ID del usuario: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    Usuario usuario = new Usuario(id, nombre);
                    biblioteca.registrarUsuario(usuario);
                    System.out.println("Usuario registrado correctamente.");
                    break;

                case 3:
                    System.out.println("\nLista de libros ");
                    for (Libro l : biblioteca.listarTodosLosLibros()) {
                        System.out.println(l);
                    }
                    break;

                case 4:
                    System.out.print("Ingrese género: ");
                    String gen = scanner.nextLine();
                    System.out.println("\n Libros por género ");
                    for (Libro l : biblioteca.listarLibrosPorGenero(gen)) {
                        System.out.println(l);
                    }
                    break;

                case 5:
                    System.out.print("¿Mostrar disponibles? (true/false): ");
                    boolean disp = scanner.nextBoolean();
                    System.out.println("\nLibros por disponibilidad ");
                    for (Libro l : biblioteca.listarLibrosPorDisponibilidad(disp)) {
                        System.out.println(l);
                    }
                    break;

                case 6:
                    System.out.print("ID del usuario: ");
                    int idPrestamo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Título del libro: ");
                    String tituloPrestamo = scanner.nextLine();
                
                    if (biblioteca.prestarLibro(idPrestamo, tituloPrestamo)) {
                        System.out.println("Préstamo realizado.");
                    } else {
                        System.out.println("No se pudo realizar el préstamo.");
                    }
                    break;

                case 7:
                    System.out.print("ID del usuario: ");
                    int idDevolucion = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Título del libro: ");
                    String tituloDevolucion = scanner.nextLine();

                    if (biblioteca.devolverLibro(idDevolucion, tituloDevolucion)) {

                        System.out.println("Devolución realizada.");
                    } else {
                        System.out.println("No se pudo realizar la devolución.");
                    }
                    break;

                case 8:
                    System.out.println("\nLista de usuarios ");
                    for (Usuario u : biblioteca.listarTodosLosUsuarios()) {
                        System.out.println(u);
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        scanner.close();
    }
}