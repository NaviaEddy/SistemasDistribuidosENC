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
// Java implementation of Server side
// It contains two classes : Server and ClientHandler
// Save file as Server.java

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

// Server class
public class ServerMultihilo_3L2
{
	static ArrayList<ClientHandler_3L2> clientes = new ArrayList<>();
	static ArrayList<task> tasks = new ArrayList<>();
	static int taskIdCounter = 1;

	public static void main(String[] args) throws IOException {


		// Escuchando en el puerto 11000
		ServerSocket ss = new ServerSocket(11000);

		// Ciclo al infinito para aceptar clientes
		while (true) {
			Socket s = null;
			try {
				// Acepta la conexión del cliente
				s = ss.accept();
				System.out.println("Un nuevo jugador se ha conectado: " + s);

				// Obtener su entrada y salida de stream
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());

				// Asignar un nuevo hilo para el cliente
				ClientHandler_3L2 nuevoCliente = new ClientHandler_3L2(s, dis, dos);
				clientes.add(nuevoCliente);

				// Crear un nuevo hilo para el cliente
				Thread t = new Thread(nuevoCliente);
				t.start();

			} catch (Exception e) {
				if (s != null)
					s.close();
				e.printStackTrace();
			}
		}
	}

	// Método para agregar una tarea
	public static synchronized void addTask(String description) {
		task newTask = new task(taskIdCounter++, description);
		tasks.add(newTask);
	}

	// Método para eliminar una tarea
	public static synchronized void removeTask(int taskId) {
		tasks.removeIf(task -> task.getId() == taskId);
	}

	// Método para listar todas las tareas
	public static synchronized ArrayList<task> getTasks() {
		return new ArrayList<>(tasks);
	}


}

