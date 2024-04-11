package EjercicioPrimerParcial;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BancoBCP extends UnicastRemoteObject implements IMetodos{
    public BancoBCP() throws RemoteException {
        super();
    }

    @Override
    public String BuscarCuenta(String Solicitud) {
        String cuentas = " ";

        String[] comandos = Solicitud.split(":");
        String[] datos = comandos[1].split("-");

        if (datos[0].equals("1") && datos[1].equals("Juan") && datos[2].equals("Segobia")) {
            cuentas = "657654-2000";
            return cuentas;
        }
        if (datos[0].equals("3") && datos[1].equals("Ricardo") && datos[2].equals("Centellas")) {
            cuentas = "657255-5890";
            return cuentas;
        }

        return "no:encontrado";
    }

    @Override
    public String Congelar(String Solicitud) {

        String retenido = " ";

        String[] comandos = Solicitud.split(":");
        String[] datos = comandos[1].split("-");

        if (datos[0].equals("657654") || datos[0].equals("657255")) {
            retenido = "congelado";
            return retenido;
        }

        return "no:retenido";
    }
}
