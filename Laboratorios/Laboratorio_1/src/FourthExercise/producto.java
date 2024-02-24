package FourthExercise;

public class producto {

    String Nombre;
    int Precio, CantidadStock;


    public producto(String nombre, int precio, int cantidadstock){
        this.Nombre = nombre;
        this.Precio = precio;
        this.CantidadStock = cantidadstock;
    }

    public String get_nombre(){
        return Nombre;
    }

    public int getPrecio() {
        return Precio;
    }

    public int getCantidadStock() {
        return CantidadStock;
    }

    public void setCantidadStock(int cantidad) {
        this.CantidadStock = cantidad;
    }

    @Override
    public String toString() {
        return "Producto: {" + "Nombre=" + Nombre + ", Precio=" +  Precio + " , Precio=" + CantidadStock + " }";
    }
}
