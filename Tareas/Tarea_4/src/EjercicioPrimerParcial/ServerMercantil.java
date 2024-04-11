package EjercicioPrimerParcial;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerMercantil {
    public static void main(String[] args) {
        int port=6789;
        try {

            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1000];

            while (true) {
                String solicitud = " ";
                BancoMercantil mercantil = new BancoMercantil();

                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket peticion =
                        new DatagramPacket(bufer, bufer.length);

                // Leemos una petición del DatagramSocket
                socketUDP.receive(peticion);
                String cadena =new String (peticion.getData(), 0, peticion.getLength());
                //System.out.println(cadena);

                String[] operacion = cadena.split(":");
                if(operacion[0].equals("Buscar")){
                    solicitud = mercantil.BuscarCuenta(cadena);
                }else{
                    solicitud = mercantil.Congelar(cadena);
                }

                String response = solicitud;
                byte[] mensaje = response.getBytes();

                //Construimos el DatagramPacket para mandar la respuesta
                DatagramPacket respuesta =
                        new DatagramPacket(mensaje, mensaje.length,
                                peticion.getAddress(), peticion.getPort());

                // Enviamos la respuesta, que es un eco
                socketUDP.send(respuesta);
            }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
}
