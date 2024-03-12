/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecondExercise_L2;

/**
 *
 * @author Carlos
 */
// Java implementation for a client
// Save file as Client.java

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

// Client class
public class ClienteMultihilo_2L2 {

    public static void main(String[] args) throws IOException {
        try {
            Scanner scn = new Scanner(System.in);
            InetAddress ip = InetAddress.getByName("localhost");
            Socket s = new Socket(ip, 11000);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            // Crear un nuevo hilo para recibir los mensajes del servidor
            Thread recibirMensajes = new Thread(() -> {
                try {
                    while (true) {
                        // Recibir mensajes del servidor y mostrarlos en consola
                        String mensajeRecibido = dis.readUTF();
                        System.out.println(mensajeRecibido);
                        if (mensajeRecibido.equals("FIN_JUEGO")) {
                            // Recibir el puntaje final
                            int puntajeFinal = dis.readInt();
                            System.out.println("El puntaje final es: " + puntajeFinal);
                            break; // Salir del bucle después de recibir el mensaje FIN_JUEGO
                        }
                    }
                    // Cerrar los flujos de entrada y salida
                    s.close();
                    dis.close();
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            recibirMensajes.start();

            // Manejar el envío de mensajes desde el cliente
            try {
                while (true) {
                    // Leer el mensaje desde la consola y enviarlo al servidor
                    String mensaje = scn.nextLine();
                    dos.writeUTF(mensaje);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}