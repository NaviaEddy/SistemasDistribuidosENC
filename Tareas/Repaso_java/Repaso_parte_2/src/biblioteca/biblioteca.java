package biblioteca;

import java.util.ArrayList;
public class biblioteca {
    private String nombre;
    private Double tamanio;
    private ArrayList<Armario>listaArmarios;

        public biblioteca(String nombre, Double tamanio) {
            this.nombre = nombre;
            this.tamanio = tamanio;
            this.listaArmarios = new ArrayList<>();
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Double getTamanio() {
            return tamanio;
        }

        public void setTamanio(Double tamanio) {
            this.tamanio = tamanio;
        }

        public ArrayList<Armario> getListaArmarios() {
            return listaArmarios;
        }

        public void setListaArmarios(ArrayList<Armario> listaArmarios) {
            this.listaArmarios = listaArmarios;
        }

        @Override
        public String toString() {
            return "Biblioteca{" + "nombre=" + nombre + ", tamanio=" + tamanio + ", listaArmarios=" + listaArmarios + '}';
        }
        public void addArmario(Armario armario)
        {
            this.listaArmarios.add(armario);
        }
}
