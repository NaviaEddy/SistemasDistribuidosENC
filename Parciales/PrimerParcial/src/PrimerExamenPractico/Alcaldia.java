package PrimerExamenPractico;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Alcaldia extends UnicastRemoteObject {
    protected Alcaldia() throws RemoteException {
        super();
    }
    public Boolean Consulta(String ci) throws RemoteException {
        boolean observaciones = false;

        if (ci.equals("1234567")) {
            observaciones = true;
            return observaciones;
        }
        if (ci.equals("555587")) {
            return observaciones;
        }
        if (ci.equals("333357")) {
            return observaciones;
        }
        return observaciones;
    }

}
