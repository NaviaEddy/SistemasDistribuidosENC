/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RMI_BANCO;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IBanco extends Remote {
    public Factura[] Calcular(int idcliente) throws RemoteException;
    public String Pagar(Factura[] facturas) throws RemoteException;
}