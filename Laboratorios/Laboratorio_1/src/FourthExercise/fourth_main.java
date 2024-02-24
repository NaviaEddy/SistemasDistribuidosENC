package FourthExercise;

import FirstExercise.producelec;

import java.util.Scanner;

public class fourth_main {
    public static void main(String[] args){

        producto producto = null;
        stock2 inventario = new stock2();
        venta venta = new venta();

        Scanner sc = new Scanner(System.in);
        String np;
        int pc, cp;
        double pt = 0;

        int opcion = 0;
        while (opcion != 4){
            System.out.println("\nMenu:");
            System.out.println("1. Agregar producto al inventario");
            System.out.println("2. Vender productos");
            System.out.println("3. Calcular valor del inventario");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Ingresa el nombre del producto: ");
                    np = sc.nextLine();
                    System.out.println("Ingresa el precio del producto: ");
                    pc = sc.nextInt();
                    System.out.println("Ingresa la cantidad de productos a incluir: ");
                    cp = sc.nextInt();
                    producto = new producto(np, pc, cp);
                    inventario.addStock2(producto);
                    System.out.println(producto.toString());
                    System.out.println("El producto se agrego correctamente");
                    break;
                case 2:
                    System.out.println("LISTA DE PRODUCTOS:");
                    for (producto producto1 : inventario.getStock2()) {
                        System.out.print(producto1.get_nombre());
                        System.out.print(" ");
                        System.out.println(producto1.getCantidadStock() + " unid.");
                    }
                    System.out.println("Que producto deseas?");
                    System.out.print("Ingresa el nombre del producto: ");
                    np = sc.nextLine();
                    System.out.print("Ingresa la cantidad del producto: ");
                    cp = sc.nextInt();
                    venta.quitarProducto(inventario, np, cp);
                    break;
                case 3:
                    System.out.println("Valor total del inventario: " + inventario.calcularValorTotal());
                    break;
                case 4:
                    System.out.println("Que tenga buen dia!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        }
    }
}
