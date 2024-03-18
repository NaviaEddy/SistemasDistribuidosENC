package RMI;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class servidor {
     public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        Saludo saludo =  new Saludo();
         LocateRegistry.createRegistry(1099);
         Naming.bind("RMI.Saludo", saludo);
     }
}
