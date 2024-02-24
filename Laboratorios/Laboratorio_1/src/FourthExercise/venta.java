package FourthExercise;

public class venta {
    public void quitarProducto(stock2 inventario, String nombreProducto, int cantidad) {
        producto producto = inventario.venderProducto(nombreProducto, cantidad);
        if (producto != null) {
            System.out.println("Se vendieron " + cantidad + " unidades de " + nombreProducto);
        } else {
            System.out.println("No hay suficientes unidades de " + nombreProducto + " en el inventario.");
        }
    }
}
