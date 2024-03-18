/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstExercise_L2;
import FirstExercise_L2.ClientHandler_1L2;
/**
 *
 * @author Carlos
 */
// Java implementation of Server side
// It contains two classes : Server and ClientHandler
// Save file as Server.java

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.*;
import java.net.*;
import java.util.*;

// Server class
public class ServerMultihilo_1L2
{
	static ArrayList<ClientHandler_1L2> clientes = new ArrayList<>();

	public static void main(String[] args) throws IOException
	{
		// Escuchandoen el puerto 5056
		ServerSocket ss = new ServerSocket(8000);
		
		//ciclo al infinito
		while (true)
		{
			Socket s = null;
			
			try
			{
				// Coneccion del RMI.cliente
				s = ss.accept();
				
				System.out.println("un nuevo RMI.cliente se ha conectado : " + s);
				
				// obtener su entrada y salida de stream
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				
				System.out.println("Nuevo hilo asignado para el RMI.cliente");

				ClientHandler_1L2 nuevoCliente = new ClientHandler_1L2(s, dis, dos);
				clientes.add(nuevoCliente);

				// create a new thread object
				Thread t = new Thread(nuevoCliente);

				// Invoking the start() method
				t.start();

			}
			catch (Exception e){
				s.close();
				e.printStackTrace();
			}
		}

	}

	public static void broadcast(String mensaje, ClientHandler_1L2 sender) {
		for (ClientHandler_1L2 cliente : clientes) {
			if (cliente != sender) {
				try {
					cliente.dos.writeUTF(mensaje);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

