package PrimerExamenPractico;

import EjercicioPrimerParcial.Banco;
import EjercicioPrimerParcial.Cuenta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario  {
    public static void main(String[] args) {

        ArrayList<Deuda> lista = null;
        Impuesto impuesto;
        String ci = "", nombres = " ", apellidos = " ";
        String result = "", Ci = " ";
        Scanner sc = new Scanner(System.in);
        try {



            int op = 0;
            while (op != 3) {
                System.out.println("1.- Consultar Deuda");
                System.out.println("2.- Pagar Deuda ");
                System.out.println("3.- Salir ");
                System.out.println("Elija opcion ");
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("Introduzca ci");
                        Ci = sc.next();
                        sc.nextLine();
                        String dato = "Deuda:"+Ci;
                        Socket client = new Socket("localhost", 5002);
                        PrintStream toServer = new PrintStream(client.getOutputStream());
                        BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        //Mandamos el mensaje al servidor
                        toServer.println(dato);
                        //Recibimos la respuesta del servidor
                        result = fromServer.readLine();
                        System.out.println(result);
                        break;
                    case 2:
                        if (result != null) {
                            System.out.println("Introduzca el ci");
                            Ci = sc.next();
                            sc.nextLine();
                            //Cuenta cuenta = lista.get(op_retener - 1);
                            System.out.println("Introduzca el anio");
                            int anio = sc.nextInt();
                            System.out.println("Introduzca el tipo de impuesto");



                        }else{
                            System.out.println("No tiene cuentas.");
                        }
                        break;
                }
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
