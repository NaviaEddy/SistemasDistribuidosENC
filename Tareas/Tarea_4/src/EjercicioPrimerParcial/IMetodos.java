package EjercicioPrimerParcial;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMetodos extends Remote {
    public String BuscarCuenta(String Solicitud) throws RemoteException;
    public String Congelar(String Solicitud) throws RemoteException;

}
