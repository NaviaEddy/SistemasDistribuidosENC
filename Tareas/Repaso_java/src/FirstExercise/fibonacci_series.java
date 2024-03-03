package FirstExercise;

import java.util.Scanner;

public class fibonacci_series {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        operations operacion = null;
        int opcion = 0;
        int numero;

        while (opcion != 4){
            System.out.println("*********************");
            System.out.println("1. Introducir n");
            System.out.println("2. Calcular el Fibonacci");
            System.out.println("3. Calcular el factorial");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.print("Introduzca un numero: ");
                    numero = sc.nextInt();
                    operacion = new operations(numero);
                    break;
                case 2:
                    System.out.println("el fibonacci es " + operacion.Fibonacci());
                    break;
                case 3:
                    System.out.println("el Factorial es " + operacion.Factorial());
                    break;
                case 4:
                    System.out.println("Que tengas un buen dia");
                    break;
                default:
                    System.out.println("Opcion no válida.");
            }
        }
    }
}
