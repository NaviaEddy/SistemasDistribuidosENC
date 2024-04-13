package PrimerExamenPractico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IRuat extends Remote {
    public ArrayList<Deuda> ConsultarDeuda(String ci) throws RemoteException;
    public Boolean PagarDeuda(Deuda deuda) throws RemoteException;
}
