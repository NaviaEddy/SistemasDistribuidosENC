/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejer3_rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author Eddy Navía Condori
 */
public class ClienteRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
       
        int op = 0;
        String cadena = "";
        int espacios = 0;
        
        Scanner sc = new Scanner(System.in);
        
        
        IServidorRMI sr;
        sr = (IServidorRMI) Naming.lookup("rmi://localhost/SERVIDOR");
        
        System.out.println("-------------------EJER3-------------------");
        System.out.println("Bienvenido, que desea realizar?");
        System.out.println("1. Introducir");
        System.out.println("2. Invertir");
        System.out.println("3. Aumentar espacio");
        System.out.println("4. Aumentar");
        System.out.print("Ingrese las opciones que desea realizar: ");
        op = sc.nextInt();
        System.out.println("");
        sc.nextLine();
        switch (op) {
            
            case 1:
                System.out.print("Ingrese la cadena:");
                cadena = sc.next();
                System.out.println("");
                boolean resultado1 = sr.introducirvalor(cadena);
                System.out.println(resultado1);
                break;
                
            case 2:
                String resultado2 = sr.invertir();
                System.out.println(resultado2);
                break;
                
            case 3:
                System.out.print("Ingrese de espacios:");
                espacios = sc.nextInt();
                String resultado3 = sr.aumentarespacios(espacios);
                System.out.println(resultado3);
                break;
                
                
            case 4:
                System.out.print("Ingrese la cadena a aumentar:");
                cadena = sc.next();
                String resultado4 = sr.aumentar(cadena);
                System.out.println(resultado4);
                break;
                
            default:
                System.out.println("Opcion invalida");
        }
    }
    
}
