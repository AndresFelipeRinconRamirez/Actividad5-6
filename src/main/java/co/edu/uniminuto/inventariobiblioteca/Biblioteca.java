package co.edu.uniminuto.inventariobiblioteca;

import co.edu.uniminuto.dao.libroDao.libroDao;
import co.edu.uniminuto.entity.Libro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {
        List<Libro> listLibros = new ArrayList<>();
        libroDao dao = new libroDao();

        Scanner scanner = new Scanner(System.in);
        int opcion;
        int idActualizar;
        String nuevoTitulo;
        String nuevoAutor;
        String nuevoGenero;
        int nuevaCantidad;
        
        do {
            System.out.print("Elija la opción que desea realizar: ");
            System.out.println("\n1. Agregar libro");
            System.out.println("2. Ver libros");
            System.out.println("3. Actualizar libro");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    
                    System.out.println("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.println("Autor: ");
                    String autor = scanner.nextLine();

                    System.out.println("Género: ");
                    String genero = scanner.nextLine();

                    System.out.println("Cantidad: ");
                    int cantidad = scanner.nextInt();
                try { 
                    System.out.println("Libro registrado");
                    Libro libro = new Libro(titulo, autor, genero, cantidad);
                    listLibros.add(libro);
                    dao.registrarLibro(libro);
                } catch (Exception e) {
                    System.out.println("Error en captura de datos:" + e.getMessage());
                }

                break;

                case 2:
                    for (Libro l : dao.obtenerLibros()) {
                        System.out.println(l);
                    }
                    break;
                    
                case 3:
                    
                    System.out.println("ID del libro a actualizar: ");
                    idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nuevo título: ");
                    nuevoTitulo = scanner.nextLine();
                    System.out.println("Nuevo autor: ");
                    nuevoAutor = scanner.nextLine();
                    System.out.println("Nuevo género: ");
                    nuevoGenero = scanner.nextLine();
                    System.out.println("Nueva cantidad: ");
                    nuevaCantidad = scanner.nextInt();
                    try {
                    Libro libroActualizado = new Libro(nuevoTitulo, nuevoAutor, nuevoGenero, nuevaCantidad);
                    libroActualizado.setId(idActualizar);
                    dao.actualizarLibro(libroActualizado);
                     } catch (Exception e) {
                         System.out.println("Error en captura de datos:"+ e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 4);

    }
}
