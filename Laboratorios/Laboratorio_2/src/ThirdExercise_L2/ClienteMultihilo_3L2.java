/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirdExercise_L2;

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
public class ClienteMultihilo_3L2 {

    public static void main(String[] args) throws IOException {
        try {
            Scanner scn = new Scanner(System.in);
            InetAddress ip = InetAddress.getByName("localhost");
            Socket s = new Socket(ip, 11000);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            while (true) {
                System.out.println("Selecciona una opción:");
                System.out.println("1. Agregar tarea");
                System.out.println("2. Eliminar tarea");
                System.out.println("3. Listar tareas");
                System.out.println("4. Salir");
                int opcion = scn.nextInt();
                dos.writeInt(opcion);
                scn.nextLine(); // Limpiar el buffer

                if (opcion == 3) {
                    // Leer el número de tareas
                    int numTareas = dis.readInt();
                    System.out.println("Lista de tareas:");
                    for (int i = 0; i < numTareas; i++) {
                        int taskId = dis.readInt();
                        String description = dis.readUTF();
                        System.out.println(taskId + ": " + description);
                    }
                } else if (opcion == 4) {
                    s.close(); // Cerrar conexión
                    return;
                } else {
                    if (opcion == 1) {
                        System.out.println("Ingresa la descripción de la tarea:");
                    } else if (opcion == 2) {
                        System.out.println("Ingresa el ID de la tarea a eliminar:");
                    }
                    String input = scn.nextLine();
                    dos.writeUTF(input);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}