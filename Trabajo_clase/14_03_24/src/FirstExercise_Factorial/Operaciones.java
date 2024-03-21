package FirstExercise_Factorial;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Operaciones extends UnicastRemoteObject implements IOperaciones {

    protected Operaciones() throws RemoteException {

        super();
    }

    @Override
    public int CalcularFactorial(int n) throws RemoteException {
        if (n == 0) {
            return 1;
        } else {
            return n * CalcularFactorial(n - 1);
        }
    }
}
