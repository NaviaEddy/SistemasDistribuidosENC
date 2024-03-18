package FirstExercise_Factorial;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOperaciones extends Remote {
    public int CalcularFactorial(int n) throws RemoteException;
}
