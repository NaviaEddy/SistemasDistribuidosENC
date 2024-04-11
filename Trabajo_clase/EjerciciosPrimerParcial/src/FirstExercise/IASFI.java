package FirstExercise;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IASFI extends Remote {
    public ArrayList<Cuenta> ConsultarCuentas(String ci, String nombres, String apellidos) throws RemoteException;
    public Boolean RetenerMonto(Cuenta cuenta, double montoBs, String glosa) throws RemoteException;
}
