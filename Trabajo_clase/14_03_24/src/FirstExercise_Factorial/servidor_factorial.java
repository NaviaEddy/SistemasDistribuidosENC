package FirstExercise_Factorial;

import RMI.Saludo;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class servidor_factorial {
    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        Operaciones operaciones =  new Operaciones();
        LocateRegistry.createRegistry(1099);
        Naming.bind("RMI.Operaciones", operaciones);
    }
}
