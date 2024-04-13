package PrimerExamenPractico;

import EjercicioPrimerParcial.Banco;
import EjercicioPrimerParcial.Cuenta;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Ruat extends UnicastRemoteObject implements IRuat{
    protected Ruat() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Deuda> ConsultarDeuda(String ci) throws RemoteException {
        ArrayList<Deuda> auxiliar = new ArrayList<>();
        int puerto = 6789;
        int anio;
        Impuesto impuesto;
        double monto;
        try {
            DatagramSocket socketUDP = new DatagramSocket();
            String dato = ci;
            byte[] mensaje = dato.getBytes();
            InetAddress hostServidor = InetAddress.getByName("localhost");

            DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, hostServidor, puerto);
            socketUDP.send(peticion);

            byte[] bufer = new byte[1000];
            DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length);
            //Recibimos la respuesta
            socketUDP.receive(respuesta);
            String respuesta_server = new String(respuesta.getData(), 0, respuesta.getLength());

            if(ci.equals("1234567")){

                Deuda deuda = new Deuda(ci, 2451.0, 2022, Impuesto.Vehiculo, respuesta_server);
                auxiliar.add(deuda);
                Deuda deuda2 = new Deuda(ci, 2500.0, 2022, Impuesto.Inmueble, respuesta_server);
                auxiliar.add(deuda2);
            }
            if(ci.equals("555587")){

                Deuda deuda = new Deuda(ci, 5000.0, 2021, Impuesto.Vehiculo, respuesta_server);
                auxiliar.add(deuda);

            }
            if(ci.equals("333357")){

                Deuda deuda = new Deuda(ci, 24547.0, 2023, Impuesto.Inmueble, respuesta_server);
                auxiliar.add(deuda);

            }

            socketUDP.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return auxiliar;
    }

    @Override
    public Boolean PagarDeuda(Deuda deuda) throws RemoteException {
        return null;
    }

}
