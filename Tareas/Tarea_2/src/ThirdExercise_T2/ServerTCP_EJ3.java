/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ThirdExercise_T2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.*;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 *
 * @author Carlos
 */
public class ServerTCP_EJ3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int port = 5002;
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
                String urlStr = fromClient.readLine();
                boolean isAvailable = checkURL(urlStr);
                String result = isAvailable ? "disponible" : "no disponible";
                toClient = new PrintStream(client.getOutputStream());
                toClient.println(result);

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static boolean checkURL(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            return (responseCode == HttpURLConnection.HTTP_OK);
        } catch (IOException e) {
            return false;
        }
    }
}
