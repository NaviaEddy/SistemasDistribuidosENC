package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class cliente {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        ISaludo saludo;
        saludo = (ISaludo)Naming.lookup("rmi://localhost/RMI.Saludo"); // instanciar un objeto remoto
        System.out.println (saludo.HolaMundo());
    }
}
