/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer3_rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eddy Navía Condori
 */
public class ServerClienteRMI {
    public static void main(String[] args) {
      try {
            ServidorRMI servidor  = new ServidorRMI();
            LocateRegistry.createRegistry(1099); //levantar el servidor de registro;
            Naming.bind("SERVIDOR",servidor);
            
        } catch (RemoteException ex) {
            Logger.getLogger(ServerClienteRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(ServerClienteRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServerClienteRMI.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
}
