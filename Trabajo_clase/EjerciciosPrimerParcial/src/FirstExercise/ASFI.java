package FirstExercise;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ASFI extends UnicastRemoteObject implements IASFI{

    public ASFI() throws RemoteException{
        super();
    }

    @Override
    public ArrayList<Cuenta> ConsultarCuentas(String ci, String nombres, String apellidos) throws RemoteException {
        return null;
    }

    @Override
    public Boolean RetenerMonto(Cuenta cuenta, double montoBs, String glosa) throws RemoteException {
        return null;
    }
}
