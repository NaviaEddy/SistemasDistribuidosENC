/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package soquettcp;

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
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");
            Socket client;
            PrintStream toClient;
            client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            String recibido=fromClient.readLine();
            System.out.println(recibido);
            toClient = new PrintStream(client.getOutputStream());
            toClient.println("Hola recibi:"+recibido);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


//Realizar un programa que utilizando la tecnologia socket tcp, pueda simular el funcionamiento de una calculadora
//para dos numeros, el cliente mandara una cadena con la operacion y el servidor respondera la solucion. Ej: cliente
//manda la cadena 3+4 y el servidor manda la cadena 7, cliente manda la cadena 5-3, servidor manda la cadena 2.
//Solo dos digitos y solo las operaciones +,-,*,/