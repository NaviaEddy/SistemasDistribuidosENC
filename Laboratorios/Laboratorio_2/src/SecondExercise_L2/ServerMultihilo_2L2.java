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
// Java implementation of Server side
// It contains two classes : Server and ClientHandler
// Save file as Server.java

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

// Server class
public class ServerMultihilo_2L2
{
	static ArrayList<ClientHandler_2L2> clientes = new ArrayList<>();

	public static void main(String[] args) throws IOException {


		// Escuchando en el puerto 11000
		ServerSocket ss = new ServerSocket(11000);

		// Ciclo al infinito para aceptar clientes
		while (true) {
			Socket s = null;
			try {
				// Acepta la conexión del RMI.cliente
				s = ss.accept();
				System.out.println("Un nuevo jugador se ha conectado: " + s);

				// Obtener su entrada y salida de stream
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());

				// Asignar un nuevo hilo para el RMI.cliente
				ClientHandler_2L2 nuevoCliente = new ClientHandler_2L2(s, dis, dos);
				clientes.add(nuevoCliente);

				// Crear un nuevo hilo para el RMI.cliente
				Thread t = new Thread(nuevoCliente);
				t.start();

			} catch (Exception e) {
				if (s != null)
					s.close();
				e.printStackTrace();
			}
		}
	}
}