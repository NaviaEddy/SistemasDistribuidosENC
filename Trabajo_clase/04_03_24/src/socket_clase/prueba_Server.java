/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package socket_clase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author CESAR ALVARO MIRANDA GUTIERREZ
 * TAREA 2
 */

public class prueba_Server {
 static int n1, n2, resp;
    public static void main(String[] args) {
     
        // TODO code application logic here
        int port = 5002;
        ServerSocket server;

        try {
            server = new ServerSocket(port);
            System.out.println("encendido");
            
            while (true) {
                Socket client;
                PrintStream toClient;
                client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional, de aqui pasa cuando hay conexion al cliente
                System.out.println("1 cliente conectado");
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                toClient = new PrintStream(client.getOutputStream()); //crear instancia para enviar a cliente.
                
            String solicitud;
            while ((solicitud = fromClient.readLine()) != null && !solicitud.equals("salir")) {
                String ejercicio = procesar_peticion(solicitud);
                toClient.println(ejercicio);
                String ResultadoCliente = fromClient.readLine();
                if (ResultadoCliente != null) {
                    String Respuesta = CompararResultadoCliente(ResultadoCliente.toLowerCase());
                    toClient.println(Respuesta);
                } else {
                    // Tratar la situación en la que la respuesta del cliente es nula
                    System.out.println("La respuesta del cliente es nula.");
                }
            }

                System.out.println("El cliente se ha desconectado");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
    public static String procesar_peticion(String solicitud){
        String[] accion=solicitud.split(":");
        if(accion[0].equals("iniciar")){
            n1= new Random().nextInt(100);
            n2 = new Random().nextInt(100);
            resp=n1+n2;
            return "Ej:"+n1+"+"+n2;
        }else{
            return "primero inicia una operacion";
        }
    }
    
    public static String CompararResultadoCliente(String ResultadoCliente){
                String[] resultado=ResultadoCliente.split(":");
        if(resultado[0].equals("respuesta")){
            return String.valueOf(resp);
        }else{
            return "primero inicia una operacion";
        }        
    }
}
