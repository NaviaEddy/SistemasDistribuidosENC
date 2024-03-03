/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FifthExercise_T2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;



/**
 *
 * @author Carlos
 */
public class ServerTCP_EJ5 {

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
            System.out.println("Se inicio el servidor con éxito");
            while(true){
                Socket client;
                PrintStream toClient;
                client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");
                String fileName = fromClient.readLine();
                boolean created = createFile(fileName);
                toClient = new PrintStream(client.getOutputStream());
                if (created) {
                    toClient.println("Archivo " + fileName + " creado exitosamente.");
                } else {
                    toClient.println("Error al crear el archivo.");
                }

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private static boolean createFile(String fileName) {
        try {
            File directory = new File("D:\\USFX\\6to Semestre - CICO\\SIS258\\SistemasDistribuidosENC\\Tareas\\Tarea_2\\src\\FifthExercise_T2\\Creados");
            if (!directory.exists()) {
                directory.mkdirs(); // Crea el directorio si no existe
            }
            File file = new File(directory, fileName);
            return file.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }
}

