/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer3_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Eddy Navía Condori
 */
public class ServidorRMI extends UnicastRemoteObject implements IServidorRMI {

    String cadena;

    protected ServidorRMI() throws RemoteException {
        super();
        cadena = "";
    }

    @Override
    public boolean introducirvalor(String _cadena) throws RemoteException {
        if (_cadena != null) {
            cadena = _cadena;
            return true;
        }
        return false;
    }

    @Override
    public String invertir() throws RemoteException {
        char[] caracteres = cadena.toCharArray();
        String invertida = "";
        for (char c : caracteres) {
            invertida = c + invertida;
        }
        return invertida;
    }

    @Override
    public String aumentarespacios(int _espacios) throws RemoteException {
        String resultado = "";
        for (char c : cadena.toCharArray()) {
            resultado += c;
            for (int j = 0; j < _espacios; j++) {
                resultado += ' ';
            }
        }
        return resultado;
    }

    @Override
    public String aumentar(String _cadena) throws RemoteException {
        return cadena + _cadena;
    }

}
