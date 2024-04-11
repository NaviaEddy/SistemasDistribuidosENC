package EjercicioPrimerParcial;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BancoMercantil extends UnicastRemoteObject implements IMetodos{

    protected BancoMercantil() throws RemoteException {
        super();
    }

    @Override
    public String BuscarCuenta(String Solicitud) {
        String cuentas = " ";

        String[] comandos = Solicitud.split(":");
        String[] datos = comandos[1].split("-");

        if (datos[0].equals("1") && datos[1].equals("Juan") && datos[2].equals("Segobia")) {
            cuentas = "1112450-5000";
            return cuentas;
        }
        if (datos[0].equals("2") && datos[1].equals("Maria") && datos[2].equals("Parra")) {
            cuentas = "1121454-300";
            return cuentas;
        }

        return "no:encontrado";
    }

    @Override
    public String Congelar(String Solicitud) {

        String retenido = " ";

        String[] comandos = Solicitud.split(":");
        String[] datos = comandos[1].split("-");

        if (datos[0].equals("1112450") || datos[0].equals("1121454")) {
            retenido = "congelado";
            return retenido;
        }

        return "no:retenido";
    }
}
