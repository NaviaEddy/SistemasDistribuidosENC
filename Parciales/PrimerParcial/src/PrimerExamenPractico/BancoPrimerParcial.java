package PrimerExamenPractico;

import EjercicioPrimerParcial.BancoBCP;
import EjercicioPrimerParcial.IAsfi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class BancoPrimerParcial {
    public static void main(String[] args) {
        int port = 5002;
        ServerSocket server;
        try {
            ArrayList<Deuda> solicitud = new ArrayList<>();
            server = new ServerSocket(port);
            while (true) {
                Socket client;
                PrintStream toClient;
                client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                String recibido = fromClient.readLine();
                //System.out.println(recibido);
                String[] operacion = recibido.split(":");
                if(operacion[0].equals("Deuda")){
                    //System.out.println(operacion[1]);
                    solicitud = ConsultaDeudaRuat(operacion[1]);
                    toClient = new PrintStream(client.getOutputStream());
                    toClient.println(solicitud);
                }//else{
                    //solicitud = bcp.Congelar(recibido);
                //}


            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Deuda> ConsultaDeudaRuat(String ci) throws RemoteException, MalformedURLException, NotBoundException {
        ArrayList<Deuda> auxiliar = new ArrayList<>();
        IRuat ruat;
        ruat = (IRuat) Naming.lookup("rmi://localhost/RUAT");

        auxiliar = ruat.ConsultarDeuda(ci);
        return auxiliar;
    }

    public String PagarDeuda(){
        return "";
    }

}
