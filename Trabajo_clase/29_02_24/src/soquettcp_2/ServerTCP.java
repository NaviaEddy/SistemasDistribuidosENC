/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package soquettcp_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;



/**
 *
 * @author Carlos
 */
public class ServerTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int port = 5002;
        int result;
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            System.out.println("Se inicio el RMI.servidor con éxito");
            while(true){
                Socket client;
                PrintStream toClient;
                client = server.accept(); //conexion entre RMI.cliente y RMI.servidor para comunicacion bidireccional
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");
                String recibido=fromClient.readLine();
                if(recibido.contains("+")){
                    String[] suma = recibido.split("\\+");
                    result = Integer.parseInt(suma[0]) + Integer.parseInt(suma[1]);
                } else if (recibido.contains("-")) {
                    String[] resta = recibido.split("-");
                    result = Integer.parseInt(resta[0]) - Integer.parseInt(resta[1]);
                } else if (recibido.contains("*")) {
                    String[] mult = recibido.split("\\*");
                    result = Integer.parseInt(mult[0]) * Integer.parseInt(mult[1]);
                }else{
                    String[] div = recibido.split("/");
                    result = Integer.parseInt(div[0]) / Integer.parseInt(div[1]);
                }
                //System.out.println(suma[0]);
                toClient = new PrintStream(client.getOutputStream());
                toClient.println("El resultado es:"+ result);

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


//Realizar un programa que utilizando la tecnologia socket tcp, pueda simular el funcionamiento de una calculadora
//para dos numeros, el RMI.cliente mandara una cadena con la operacion y el RMI.servidor respondera la solucion. Ej: RMI.cliente
//manda la cadena 3+4 y el RMI.servidor manda la cadena 7, RMI.cliente manda la cadena 5-3, RMI.servidor manda la cadena 2.
//Solo dos digitos y solo las operaciones +,-,*,/