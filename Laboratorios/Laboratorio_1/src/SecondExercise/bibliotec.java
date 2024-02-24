package SecondExercise;

import java.util.ArrayList;

public class bibliotec {
    private final ArrayList<libro2> libros;

    public bibliotec() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(libro2 libro) {
        libros.add(libro);
    }

    public ArrayList<libro2> getLibrosBiblioteca() {
        return libros;
    }
    public ArrayList<autor> getAutores() {
        ArrayList<autor> autores = new ArrayList<>();
        for (libro2 libro : libros) {
            autores.add(libro.getAutor());
        }
        return autores;
    }

    public ArrayList<libro2> buscarLibrosPorAutor(String autor) {
        ArrayList<libro2> librosAutor = new ArrayList<>();
        for (libro2 libro1 : libros) {
            if (libro1.getAutor().equals(autor)) {
                librosAutor.add(libro1);
            }
        }
        return librosAutor;
    }

    public void prestarLibro(String libro, usuario usuario) {
        System.out.println("El libro \"" + libro + "\" ha sido prestado a " + usuario.getNombre());
    }

    public void devolverLibro(String libro, String usuario) {
        System.out.println("El libro \"" + libro + "\" ha sido devuelto por " + usuario);
    }
}
