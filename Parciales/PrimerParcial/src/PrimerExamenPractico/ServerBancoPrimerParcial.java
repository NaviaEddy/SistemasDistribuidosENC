package PrimerExamenPractico;

import EjercicioPrimerParcial.Asfi;
import EjercicioPrimerParcial.ServerJuez;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerBancoPrimerParcial {
    public static void main(String[] args) {
        try {
            Ruat ruat  = new Ruat();
            LocateRegistry.createRegistry(1099); //levantar el servidor de registro;
            Naming.bind("RUAT",ruat);
        } catch (RemoteException ex) {
            Logger.getLogger(ServerJuez.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(ServerJuez.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServerJuez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
