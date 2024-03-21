/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author Carlos
 */
public class ServerTCP_2L4 {

    private static final String[] palabras = {"PROGRAMACION", "AHORCADO", "JAVA", "SERVIDOR", "CLIENTE"};
    private static final int intentosMaximos = 6; // Número máximo de intentos

    public static void main(String[] args) {
        int port = 5002;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Servidor iniciado con éxito");

            while (true) {
                try (Socket client = server.accept();
                     BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                     PrintStream toClient = new PrintStream(client.getOutputStream())) {

                    System.out.println("Cliente conectado");
                    String nombre = fromClient.readLine(); // Lee el nombre del cliente
                    System.out.println("Nombre del cliente: " + nombre);
                    toClient.println(nombre.toUpperCase() + ", BIENVENIDO AL JUEGO DEL AHORCADO!");

                    // Selección de palabra al azar para el juego
                    String palabra = palabras[new Random().nextInt(palabras.length)];
                    char[] palabraAdivinada = new char[palabra.length()];
                    for (int i = 0; i < palabra.length(); i++) {
                        palabraAdivinada[i] = '-';
                    }

                    int intentos = intentosMaximos;
                    boolean juegoActivo = true;

                    while (juegoActivo && intentos > 0) {
                        String entrada = fromClient.readLine().toUpperCase();
                        if (entrada.length() == 1) { // Asegura que el cliente envíe solo una letra
                            char letra = entrada.charAt(0);
                            boolean acierto = false;
                            for (int i = 0; i < palabra.length(); i++) {
                                if (palabra.charAt(i) == letra) {
                                    palabraAdivinada[i] = letra;
                                    acierto = true;
                                }
                            }
                            if (!acierto) {
                                intentos--;
                            }

                            String estadoPalabra = new String(palabraAdivinada);
                            if (estadoPalabra.contains("-")) {
                                toClient.println(estadoPalabra + ":" + intentos);
                            } else {
                                toClient.println(estadoPalabra + "¡Has ganado!");
                                juegoActivo = false;
                            }
                        }

                        if (intentos <= 0) {
                            toClient.println("GAME OVER. La palabra era: " + palabra);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error con el cliente: " + e.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println("Error al iniciar el servidor: " + ex.getMessage());
        }
    }
}
