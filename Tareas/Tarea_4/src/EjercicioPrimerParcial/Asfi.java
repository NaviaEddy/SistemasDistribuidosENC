package EjercicioPrimerParcial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Asfi extends UnicastRemoteObject implements IAsfi {

    public Asfi() throws RemoteException {
        super();
    }


    @Override
    public ArrayList<Cuenta> ConsultarCuentas(String ci, String nombres, String apellidos) throws RemoteException {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        // Consulta UDP al Banco Mercantil
        cuentas.addAll(ConsultaBancoMercantil(ci, nombres, apellidos, "localhost", 6789));
        cuentas.addAll(ConsultaBancoBCP(ci, nombres, apellidos, 5002));

        return cuentas;
    }

    @Override
    public Boolean RetenerMonto(Cuenta cuenta, double montoBs, String glosa) throws RemoteException {
        String bancos = cuenta.getTBancos().toString();
        boolean retenido;
        if(bancos.equals("Mercantil")){
            retenido = RetenerMontoBancoMercantil(cuenta, montoBs, glosa, "localhost", 6789);
        }else{
            retenido = RetenerMontoBancoBCP(cuenta, montoBs, glosa, 5002);
        }
        return retenido;
    }

    private ArrayList<Cuenta> ConsultaBancoMercantil(String ci, String nombres, String apellidos, String ip, int puerto){
        ArrayList<Cuenta> auxiliar = new ArrayList<>();
        try {
            DatagramSocket socketUDP = new DatagramSocket();
            String dato = "Buscar:"+ci+"-"+nombres+"-"+apellidos;
            byte[] mensaje = dato.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);

            DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, hostServidor, puerto);
            socketUDP.send(peticion);

            byte[] bufer = new byte[1000];
            DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(respuesta);
            String respuesta_server = new String(respuesta.getData(), 0, respuesta.getLength());

            String[] comandos=respuesta_server.split(":");
            if (!comandos[0].equals("no"))
            {
                String[] datosCuenta=comandos[0].split("-");
                Cuenta cuentaMercantil=new Cuenta(Banco.Mercantil, datosCuenta[0], ci, nombres, apellidos, Double.parseDouble(datosCuenta[1]));
                auxiliar.add(cuentaMercantil);
            }

            socketUDP.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return auxiliar;
    }

    private ArrayList<Cuenta> ConsultaBancoBCP(String ci, String nombres, String apellidos, int puerto) {
        ArrayList<Cuenta> auxiliar = new ArrayList<>();

        try {
            Socket client = new Socket("localhost", puerto);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String dato = "Buscar:" + ci + "-" + nombres + "-" + apellidos;
            toServer.println(dato);
            String result = fromServer.readLine();
            String[] comandos = result.split(":");
            if (!comandos[0].equals("no")) {
                String[] datosCuenta = comandos[0].split("-");
                Cuenta cuentaMercantil = new Cuenta(Banco.BCP, datosCuenta[0], ci, nombres, apellidos, Double.parseDouble(datosCuenta[1]));
                auxiliar.add(cuentaMercantil);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return auxiliar;
    }

    private boolean RetenerMontoBancoMercantil(Cuenta cuenta, double montoBs, String glosa, String ip, int puerto){

        boolean retenido = false;

        try {
            DatagramSocket socketUDP = new DatagramSocket();
            String dato = "Congelar:"+cuenta.getNroCuenta()+"-"+montoBs+"-"+glosa;
            byte[] mensaje = dato.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);

            DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, hostServidor, puerto);
            socketUDP.send(peticion);

            byte[] bufer = new byte[1000];
            DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(respuesta);
            String respuesta_server = new String(respuesta.getData(), 0, respuesta.getLength());

            String[] comandos=respuesta_server.split(":");
            if (!comandos[0].equals("no"))
            {
                retenido = true;
            }

            socketUDP.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return retenido;
    }

    private boolean RetenerMontoBancoBCP(Cuenta cuenta, double montoBs, String glosa, int puerto){

        boolean retenido = false;

        try {
            Socket client = new Socket("localhost", puerto);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String dato = "Congelar:"+cuenta.getNroCuenta()+"-"+montoBs+"-"+glosa;
            toServer.println(dato);
            String result = fromServer.readLine();
            String[] comandos = result.split(":");
            if (!comandos[0].equals("no")) {
                retenido = true;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return retenido;
    }
}
