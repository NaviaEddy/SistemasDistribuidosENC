/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketMultihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Carlos
 */
class ClientHandler extends Thread {

    static int n1, n2, resp;
    //DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    //DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        String received, resultado;
        String toreturn;
        while (true) {
            try {

                // Ask user what he wants
                dos.writeUTF("Escribir la operacion: [iniciar:suma | iniciar:resta]");


                // receive the answer from client
                received = dis.readUTF();
                String operacion = received.toLowerCase();

                if (operacion.equals("exit")) {
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }

                dos.writeUTF(procesar_peticion(operacion));

                dos.writeUTF("Escribir el resultado: [respuesta:valor]");
                resultado = dis.readUTF();
                dos.writeUTF(CompararResultadoCliente(resultado));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            // closing resources
            this.dis.close();
            this.dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String procesar_peticion(String solicitud){
        String[] accion=solicitud.split(":");
        if(accion[1].equals("suma")){
            n1= new Random().nextInt(100);
            n2 = new Random().nextInt(100);
            resp=n1+n2;
            return "Ej:"+n1+"+"+n2;
        } else if (accion[1].equals("resta")) {
            n1= new Random().nextInt(100);
            n2 = new Random().nextInt(100);
            resp=n1-n2;
            return "Ej:"+n1+"-"+n2;
        } else{
            return "primero inicia una operacion";
        }
    }

    public static String CompararResultadoCliente(String ResultadoCliente){
        String[] resultado=ResultadoCliente.split(":");
        if(resultado[0].equals("respuesta")){
            if(Objects.equals(resultado[1], String.valueOf(resp))){
                return "Correcto";
            }else{
                return "Incorrecto";
            }
        }else{
            return "primero inicia una operacion";
        }
    }
}


