package EjercicioPrimerParcial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBCP {
    public static void main(String[] args) {
        int port = 5002;
        ServerSocket server;

        try {
            String solicitud = " ";
            BancoBCP bcp = new BancoBCP();
            server = new ServerSocket(port);
            while (true) {
                Socket client;
                PrintStream toClient;
                client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                String recibido = fromClient.readLine();

                String[] operacion = recibido.split(":");
                if(operacion[0].equals("Buscar")){
                    solicitud = bcp.BuscarCuenta(recibido);
                }else{
                    solicitud = bcp.Congelar(recibido);
                }

                toClient = new PrintStream(client.getOutputStream());
                toClient.println(solicitud);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
