package FirstExercise;

import java.util.ArrayList;
public class stock {

    ArrayList<producelec> stock;
    public stock(){
        this.stock = new ArrayList<>();
    }

    public ArrayList<producelec> getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Inventario {" + stock + "}";
    }

    public void addStock(producelec productoElectronico){
        this.stock.add(productoElectronico);
    }
}
