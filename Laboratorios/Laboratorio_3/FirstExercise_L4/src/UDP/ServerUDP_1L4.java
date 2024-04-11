/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Carlos
 */
public class ServerUDP_1L4 {

  public static void main(String args[]) {
    int port = 6789;
    try {
      DatagramSocket socketUDP = new DatagramSocket(port);
      byte[] bufer = new byte[1000];

      while (true) {
        DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);
        socketUDP.receive(peticion);

        System.out.print("Datagrama recibido del host: " + peticion.getAddress());
        System.out.println(" desde el puerto remoto: " + peticion.getPort());

        String cadena = new String(peticion.getData(), 0, peticion.getLength());
        //System.out.println(cadena);
        int valor = Integer.parseInt(cadena.trim());

        String response = esPrimo(valor) ? "Es primo" : "No es primo";
        byte[] mensaje = response.getBytes();

        DatagramPacket respuesta = new DatagramPacket(mensaje, mensaje.length, peticion.getAddress(), peticion.getPort());
        socketUDP.send(respuesta);
      }
    } catch (SocketException e) {
      System.out.println("Socket: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
  }

  private static boolean esPrimo(int numero) {
    if (numero <= 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(numero); i++) {
      if (numero % i == 0) {
        return false;
      }
    }
    return true;
  }
}

    

