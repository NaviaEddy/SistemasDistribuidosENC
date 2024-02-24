package FourthExercise;

import java.util.ArrayList;

public class stock2 {
    ArrayList<producto> stock2;
    public stock2(){
        this.stock2 = new ArrayList<>();
    }

    public ArrayList<producto> getStock2() {
        return stock2;
    }

    @Override
    public String toString() {
        return "Inventario {" + stock2 + "}";
    }

    public void addStock2(producto Producto){
        this.stock2.add(Producto);
    }

    public producto venderProducto(String nombre, int cantidad) {
        for (producto producto : stock2) {
            if (producto.get_nombre().equals(nombre) && producto.getCantidadStock() >= cantidad) {
                producto.setCantidadStock(producto.getCantidadStock() - cantidad);
                return producto;
            }
        }
        return null;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (producto producto : stock2) {
            total += producto.getPrecio() * producto.getCantidadStock();
        }
        return total;
    }

}
