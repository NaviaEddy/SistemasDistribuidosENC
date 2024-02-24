package SecondExercise;

import java.util.ArrayList;
import java.util.Scanner;

//6. Escribe un
//sistema en Java para gestionar una biblioteca virtual. Implementa clases para representar
//libros, autores y usuarios. Proporciona funcionalidades para agregar libros, buscar libros
//por autor, prestar libros a usuarios y devolver libros.
public class second_main {
    public static void main(String[] args){

        bibliotec biblioteca = new bibliotec();

        Scanner sc = new Scanner(System.in);
        String na, nl, nu;

        int opcion = 0;
        while (opcion != 5){
            System.out.println("\nMenu:");
            System.out.println("1. Agregar libros a la biblioteca");
            System.out.println("2. Buscar libro por autor");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Ingresa el nombre del autor: ");
                    na = sc.nextLine();
                    autor autor = new autor(na);
                    System.out.println("Ingresa el nombre del libro: ");
                    nl = sc.nextLine();
                    libro2 newlibro = new libro2(nl, autor);
                    biblioteca.agregarLibro(newlibro);
                    System.out.println("El libro se agrego correctamente a la biblioteca");
                    break;
                case 2:
                    System.out.println("Autores:");
                    System.out.println(biblioteca.getAutores());
                    System.out.println("Ingresa el nombre del autor a buscar: ");
                    na = sc.nextLine();
                    ArrayList<libro2> librobuscar = biblioteca.buscarLibrosPorAutor(na);
                    for (libro2 encontrado : librobuscar) {
                        System.out.println("- " + encontrado.getTitulo());
                    }
                    break;
                case 3:
                    System.out.println("Crea tu nombre de usuario:");
                    nu = sc.nextLine();
                    usuario usuario1 = new usuario(nu);
                    System.out.println("Libros disponibles:");
                    System.out.println(biblioteca.getLibrosBiblioteca());
                    System.out.println("Ingresa el nombre del libro:");
                    nl = sc.nextLine();
                    biblioteca.prestarLibro(nl, usuario1);
                    break;
                case 4:
                    System.out.println("Ingresa el nombre del libro:");
                    nl = sc.nextLine();
                    System.out.println("Ingresa tu nombre de usuario:");
                    nu = sc.nextLine();
                    biblioteca.devolverLibro(nl, nu);
                    break;
                case 5:
                    System.out.println("Que tenga buen dia!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        }
    }
}
