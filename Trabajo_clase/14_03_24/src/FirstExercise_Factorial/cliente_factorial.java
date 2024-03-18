package FirstExercise_Factorial;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class cliente_factorial {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        Scanner sc = new Scanner(System.in);

        try {
            IOperaciones operaciones = (IOperaciones)Naming.lookup("rmi://localhost/RMI.Operaciones");

            System.out.print("Ingrese un número para calcular su factorial: ");
            int numero = sc.nextInt();

            System.out.println("Factorial de " + numero + ": " + operaciones.CalcularFactorial(numero));
        } catch (InputMismatchException e) {
            System.err.println("El valor ingresado no es un número entero válido.");
        } finally {
            sc.close();
        }
    }
}
