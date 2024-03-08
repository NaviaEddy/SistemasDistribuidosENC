/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket_clase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author CESAR ALVARO MIRANDA GUTIERREZ
 * TAREA 2
 */
public class prueba_Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int port = 5002;
        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("ESTÁS CONECTADO A UN SERVIDOR");

            String orden;
            do {
                System.out.println("ESCRIBA LA ORDEN: iniciar:suma, respuesta:valor, salir");
                orden = sc.nextLine().toLowerCase(); // ingresar valor por teclado
                toServer.println(orden); // enviar la cadena llamada 'orden' al servidor
                String resultado = fromServer.readLine(); // obtiene desde el servidor el valor de resultado
                System.out.println(resultado);
            } while (!orden.equals("salir"));

            System.out.println("Esperamos su regreso!!");
            client.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}