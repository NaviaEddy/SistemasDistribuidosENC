package FirstExercise;

import java.util.Scanner;

//4. Crea un sistema en Java para gestionar una tienda de productos electrónicos. Define
//clases para representar productos como teléfonos móviles, laptops, etc. Implementa
//funcionalidades para agregar productos al inventario, mostrar el inventario y calcular el
//precio total de los productos en stock.
public class first_main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        producelec productoElectronico = null;
        stock inventario = new stock();
        String np, tp, mc;
        int pc;
        double pt = 0;

        int opcion = 0;
        while (opcion != 4){
            System.out.println("\nMenu:");
            System.out.println("1. Agregar producto al inventario");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Calcular precio total del inventario");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Ingresa el nombre del producto: ");
                    np = sc.nextLine();
                    System.out.println("Ingresa el nombre el tipo de producto: ");
                    tp = sc.nextLine();
                    System.out.println("Ingresa la marca del producto: ");
                    mc = sc.nextLine();
                    System.out.println("Ingresa el precio del producto: ");
                    pc = sc.nextInt();
                    productoElectronico = new producelec(np, tp, mc, pc);
                    inventario.addStock(productoElectronico);
                    System.out.println("El producto se agrego correctamente");
                    break;
                case 2:
                    System.out.println(inventario.toString());
                    break;
                case 3:
                    for (producelec producto1 : inventario.getStock()) {
                        pt += producto1.getPrecio();
                    }
                    System.out.println("El precio total de todos los productos en el stock es: " + pt);
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
