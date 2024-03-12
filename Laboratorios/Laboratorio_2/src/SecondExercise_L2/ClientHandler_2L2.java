/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecondExercise_L2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Carlos
 */
public class ClientHandler_2L2 extends Thread {
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    private int puntaje = 0;


    public ClientHandler_2L2(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        try {

            // Juego de preguntas
            String[] preguntas = {
                    "¿Cuál es la capital de Francia?",
                    "¿Cuál es el río más largo del mundo?",
                    "¿Cuál es la capital de Bolivia?"
            };

            String[] respuestas = {
                    "paris",
                    "amazonas",
                    "sucre"
            };

            // Enviamos las preguntas
            for (int i = 0; i < preguntas.length; i++) {
                dos.writeUTF(preguntas[i]);
                String respuesta = dis.readUTF();

                // Verificar si la respuesta es correcta
                if (respuesta.equalsIgnoreCase(respuestas[i])) {
                    puntaje++;
                    dos.writeUTF("¡Respuesta correcta!");
                } else {
                    dos.writeUTF("Respuesta incorrecta.");
                }
            }

            // Enviar puntaje final
            dos.writeUTF("FIN_JUEGO");
            dos.writeInt(puntaje);

            // Cerrar los flujos de entrada y salida
            dis.close();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}