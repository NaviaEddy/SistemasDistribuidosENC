package TCP;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


/**
 *
 * @author Carlos
 */
public class ClienteTCP_2L4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int port = 5002;
        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            System.out.println("Introduce tu nombre:");
            String nombre = sc.nextLine();
            toServer.println(nombre); // Envía el nombre al servidor

            String bienvenida = fromServer.readLine(); // Lee el mensaje de bienvenida
            System.out.println(bienvenida);

            boolean juegoActivo = true;
            while (juegoActivo) {
                System.out.println("Introduce una letra:");
                String letra = sc.nextLine();
                toServer.println(letra); // Envía la letra al servidor

                String respuesta = fromServer.readLine(); // Espera la respuesta del servidor
                System.out.println(respuesta);
                if (respuesta.contains("¡Has ganado!") || respuesta.contains("GAME OVER")) {
                    juegoActivo = false; // Finaliza el juego
                }
            }
        } catch (IOException ex) {
            System.out.println("Error al conectar con el servidor: " + ex.getMessage());
        } finally {
            sc.close();
        }
    }
}
