/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

/**
 *
 * @author Carlos
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class ClientUDP_1L4 {

  // Los argumentos proporcionan el mensaje y el nombre del servidor
  public static void main(String args[]) {
    int puerto = 6789;
    Scanner sc = new Scanner(System.in);
    try {
      System.out.print("Introduzca un valor: ");
      String dato = sc.next();
      String ip = "localhost";
      DatagramSocket socketUDP = new DatagramSocket();
      byte[] mensaje = dato.getBytes();
      InetAddress hostServidor = InetAddress.getByName(ip);

      DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, hostServidor, puerto);
      socketUDP.send(peticion);

      byte[] bufer = new byte[1000];
      DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length);
      socketUDP.receive(respuesta);

      System.out.println("Respuesta: " + new String(respuesta.getData(), 0, respuesta.getLength()));
      socketUDP.close();

    } catch (SocketException e) {
      System.out.println("Socket: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    } finally {
      sc.close();
    }
  }
}

