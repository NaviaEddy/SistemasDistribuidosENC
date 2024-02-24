package ThirdExercise;

import java.util.Scanner;

public class third_main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        GestorTareas gestorTareas = new GestorTareas();
        String des, fech;

        int opcion = 0;
        while (opcion != 5){
            System.out.println("\nMenu:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Mostrar lista de tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la descripción de la tarea: ");
                    des = sc.nextLine();
                    System.out.print("Ingrese la fecha límite de la tarea: ");
                    fech = sc.nextLine();
                    tarea newtarea = new tarea(des, fech);
                    gestorTareas.agregarTarea(newtarea);
                    System.out.println("Tarea agregada correctamente.");
                    break;
                case 2:
                    gestorTareas.mostrarTareas();
                    break;
                case 3:
                    System.out.print("Ingrese el índice de la tarea que desea marcar como completada: ");
                    int indice = sc.nextInt();
                    gestorTareas.marcarTareaComoCompletada(indice - 1);
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
