package RMI;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISaludo extends Remote {

    public String HolaMundo() throws RemoteException;
}
