package biblioteca;

import java.util.ArrayList;


public class Armario {
    TipoArmario tipoArmario;
    String codigo, del;
    ArrayList<Libro> listaLibros;

    public Armario(TipoArmario tipoArmario, String codigo) {
        this.tipoArmario = tipoArmario;
        this.codigo = codigo;
        this.listaLibros = new ArrayList<>();
    }

    public TipoArmario getTipoArmario() {
        return tipoArmario;
    }

    public void setTipoArmario(TipoArmario tipoArmario) {
            this.tipoArmario = tipoArmario;
        }
    public String getCodigo() {
            return codigo;
        }
    public void setCodigo(String codigo) {
            this.codigo = codigo;
        }
    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public void addLibro(Libro libro)
    {
        this.listaLibros.add(libro);
    }


    @Override
    public String toString() {
        return "Armario{" + "tipoArmario=" + tipoArmario + ", codigo=" + codigo + ", listaLibros=" +  listaLibros + "}";
    }

}
