/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstExercise_L2;

/**
 *
 * @author Carlos
 */
// Java implementation for a client
// Save file as Client.java
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.*;

// Client class
public class ClienteMultihilo_1L2 {

    public static void main(String[] args) throws IOException {
        try {
            Scanner scn = new Scanner(System.in);

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            // establish the connection with server port 5056
            Socket s = new Socket(ip, 8000);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            //Creamos un nuevo hilo para recibir los mensajes
            Thread recibirmensajes = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            // Recibir y mostrar mensajes del RMI.servidor
                            String mensaje = dis.readUTF();
                            System.out.println(mensaje);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            recibirmensajes.start();


            while (true) {
                // the following loop performs the exchange of
                // information between client and client handler
                System.out.println("Escribe tu mensaje o escribe exit para terminar la conexion");
                String mensaje = scn.nextLine();
                String mandar = mensaje.toLowerCase();
                dos.writeUTF(mandar);

                if (mandar.equals("exit")) {
                    System.out.println("Closing this connection : " + s);
                    s.close();
                    System.out.println("Connection closed");
                    break;
                }
            }

            // closing resources
            scn.close();
            dis.close();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
