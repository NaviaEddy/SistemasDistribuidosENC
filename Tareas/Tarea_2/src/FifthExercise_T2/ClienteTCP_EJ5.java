package FifthExercise_T2;

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
public class ClienteTCP_EJ5 {
    public static void main(String[] args) {
        {
            Scanner sc=new Scanner(System.in);
            int port = 5002;
            try {
                Socket client = new Socket("localhost", port);
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("Introduce el nombre del archivo a crear:");
                String fileName = sc.nextLine();
                toServer.println(fileName);
                String response = fromServer.readLine();
                System.out.println("Respuesta del RMI.servidor: " + response);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }
}
