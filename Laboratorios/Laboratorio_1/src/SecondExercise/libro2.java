package SecondExercise;

public class libro2 {
    private final String Titulo;
    private final autor Autor;
    public boolean Prestado;

    public libro2(String titulo, autor autor) {
        this.Titulo = titulo;
        this.Autor = autor;
        this.Prestado = false;
    }

    public String getTitulo() {
        return Titulo;
    }

    public autor getAutor() {
        return Autor;
    }

    public void prestar() {
        Prestado = true;
    }

    public void devolver() {
        Prestado = false;
    }
}
