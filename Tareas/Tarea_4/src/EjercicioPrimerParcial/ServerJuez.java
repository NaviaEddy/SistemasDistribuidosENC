package EjercicioPrimerParcial;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerJuez {
    public static void main(String[] args) {
        try {
            Asfi asfi = new Asfi();
            LocateRegistry.createRegistry(1099); //levantar el servidor de registro;
            Naming.bind("ASFI",asfi);
        } catch (RemoteException ex) {
            Logger.getLogger(ServerJuez.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(ServerJuez.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServerJuez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
