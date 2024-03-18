/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FourthExercise_T2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;



/**
 *
 * @author Carlos
 */
public class ServerTCP_EJ4 {

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
                String FileName = fromClient.readLine();
                boolean found = searchFile(FileName);
                toClient = new PrintStream(client.getOutputStream());
                toClient.println(found);

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private static boolean searchFile(String fileName) {
        File directory = new File("C:\\Users\\Eddy Navía Condori\\Downloads\\Telegram Desktop");
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile() && file.getName().equals(fileName)) {
                    return true;
                }
            }
        }
        return false;
    }
}

