/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirdExercise_L2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class ClientHandler_3L2 extends Thread {
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    public ClientHandler_3L2(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int request = dis.readInt();
                switch (request) {
                    case 1: {
                        String description = dis.readUTF();
                        ServerMultihilo_3L2.addTask(description);
                        sendTaskList();
                        break;
                    }
                    case 2: {
                        int taskId = dis.readInt();
                        ServerMultihilo_3L2.removeTask(taskId);
                        sendTaskList();
                        break;
                    }
                    case 3: {
                        sendTaskList();
                        break;
                    }
                    case 4: {
                        s.close();
                        return; // Salir del bucle de manejo de solicitudes
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendTaskList() throws IOException {
        // Obtener la lista de tareas del servidor
        ArrayList<task> tasks = ServerMultihilo_3L2.getTasks();
        // Enviar el número de tareas al cliente
        dos.writeInt(tasks.size());
        // Enviar cada tarea al cliente
        for (task task : tasks) {
            dos.writeInt(task.getId());
            dos.writeUTF(task.getDescription());
        }
    }

}