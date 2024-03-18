package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Saludo extends UnicastRemoteObject implements ISaludo{


    protected Saludo() throws RemoteException {
        super();
    }

    @Override
    public String HolaMundo() throws RemoteException {
        return "Hola mundo";
    }
}
