package FirstExercise;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class Juez {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        IASFI juez;
        juez = (IASFI)Naming.lookup("rmi://localhost/ASFI");

        ArrayList<Cuenta> Lista = null;

        String Ci = "";
        String Nombres = "";
        String Apellidos = "";

        Scanner sc = new Scanner(System.in);

        int op = 0;
        while (op != 3){
            System.out.println("1. Consultar cuentas");
            System.out.println("2. Retener cuenta");
            System.out.println("3. Salir");
            System.out.println("Elija la opcion");
            op = sc.nextInt();
            switch (op){
                case 1:
                    System.out.println("Introduzca CI:");
                    Ci = sc.nextLine();
                    System.out.println("Introduzca Nombres:");
                    Nombres = sc.nextLine();
                    System.out.println("Introduzca Apellidos:");
                    Apellidos = sc.nextLine();
                    Lista = juez.ConsultarCuentas(Ci, Nombres, Apellidos);
                    break;
                case 2:
                    if (Lista != null){
                        int i = 1;
                        for(Cuenta c : Lista){
                            System.out.println(i + ". " + "Banco: " + c.getBanco() + "Nro: " + c.getNroCuenta() + "Saldo: " + c.getSaldo());
                            i++;
                        }
                        System.out.println("Introduzca el numero de la cuenta a retener");
                        int cuenta_retener = sc.nextInt();
                        Cuenta cuenta = Lista.get(cuenta_retener);
                        System.out.println("Introduzca el monto");
                        double monto_retener = sc.nextInt();
                        System.out.println("Introduzca la glosa");
                        String glosa_retener = sc.nextLine();
                        if(juez.RetenerMonto(cuenta, monto_retener, glosa_retener)){
                            System.out.println("Se retuvo el monto con exito");
                        }

                    }else {
                        System.out.println("No se consulto ninguna cuenta");
                    }
                    break;
                case 3:
                    System.out.println("Que tenga un lindo dia!");
                    break;
            }
        }



    }


}
