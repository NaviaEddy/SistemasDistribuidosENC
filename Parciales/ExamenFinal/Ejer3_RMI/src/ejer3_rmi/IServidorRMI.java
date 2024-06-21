/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejer3_rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Eddy Navía Condori
 */
public interface IServidorRMI extends Remote{
    public boolean introducirvalor(String _cadena) throws RemoteException;
    public String invertir() throws RemoteException;
    public String aumentarespacios(int _espacios) throws RemoteException;
    public String aumentar(String _cadena) throws RemoteException;
}
