package FirstExercise;

public class producelec {
    String Nombre;
    String Tipoproducto;
    String Marca;
    int Precio;


    public producelec(String nombre, String tipoproducto, String marca, int precio){
        this.Nombre = nombre;
        this.Tipoproducto = tipoproducto;
        this.Marca = marca;
        this.Precio = precio;
    }

    public String get_nombre(){
        return Nombre;
    }

    public String get_tproducto(){
        return Tipoproducto;
    }

    public String getMarca() {
        return Marca;
    }

    public int getPrecio() {
        return Precio;
    }

    @Override
    public String toString() {
        return "Productos: {" + "Nombre=" + Nombre + ", TipoProducto=" + Tipoproducto + ", Marca=" +  Marca + ", Precio=" +  Precio +" }";
    }

}
