package SecondExercise;

import java.util.ArrayList;
import java.util.Scanner;

public class exercise_2 {
    public static void main(String[] args){

        biblioteca biblioteca=new biblioteca("Facultad de Tecnologia",220d);
        BD_Connection conn = new BD_Connection();

        Scanner sc = new Scanner(System.in);
        Armario armario = null;
        Libro libro = null;
        TipoArmario tparmario;

        int opcion = 0;
        int an;
        String nl, cd, at, ed, tarmario;


        while (true) {
            System.out.println("*********************");
            System.out.println("1. Crear Armario");
            System.out.println("2. Ver armarios de la biblioteca");
            System.out.println("3. Crear libro");
            System.out.println("4. Cargar libro al armario");
            System.out.println("5. Guardar");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Armarios disponibles:");
                    for (TipoArmario tipo : TipoArmario.values()) {
                        System.out.println(tipo);
                    }
                    System.out.print("Introduce el tipo de armario: ");
                    tarmario = sc.nextLine();
                    tparmario = TipoArmario.valueOf(tarmario);
                    System.out.print("Introduce el codigo del armario: ");
                    cd = sc.nextLine();
                    armario = new Armario(tparmario, cd);
                    biblioteca.addArmario(armario);
                    System.out.println("!Armario creado y añadido correctamente a la biblioteca¡");
                    break;
                case 2:
                    System.out.println(biblioteca.toString());
                    break;
                case 3:
                    System.out.print("Introduce el nombre del libro: ");
                    nl = sc.nextLine();
                    System.out.print("Introduce el autor del libro " + nl + ": " );
                    at = sc.nextLine();
                    System.out.print("Introduce la editorial del libro " + nl + ": ");
                    ed = sc.nextLine();
                    System.out.print("Introduce el anio del libro " + nl + ": ");
                    an = sc.nextInt();
                    libro = new Libro(nl, at, ed, an);
                    System.out.println("!Se ha creado correctamente el libro¡");
                    break;
                case 4:
                    System.out.println("Armarios disponibles:");
                    for (Armario armario1 : biblioteca.getListaArmarios()) {
                        System.out.print(armario1.getTipoArmario());
                        System.out.print(" ");
                        System.out.println(armario1.getCodigo());
                    }
                    System.out.print("Elija el código del armario: ");
                    cd = sc.nextLine();
                    for (Armario armario1 : biblioteca.getListaArmarios()) {
                        if (armario1.getCodigo().equals(cd)) {
                            armario = armario1;
                            break;
                        }
                    }
                    armario.addLibro(libro);
                    System.out.println("Libro agregado correctamente al armario de código " + armario.getCodigo() + "!");
                    break;
                case 5:
                    conn.Guardar(biblioteca);
                    break;
                case 6:
                    System.out.println("Que tenga buen dia!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
