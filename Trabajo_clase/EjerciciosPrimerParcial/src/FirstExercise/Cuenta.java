package FirstExercise;

import java.io.Serializable;

public class Cuenta implements Serializable {
    private Banco banco;
    private String NroCuenta;
    private String Ci;
    private String Nombres;
    private String Apellidos;
    private Double Saldo;

    public Cuenta(Banco banco, String nroCuenta, String ci, String nombres, String apellidos, Double saldo) {
        this.banco = banco;
        this.NroCuenta = nroCuenta;
        this.Ci = ci;
        this.Nombres = nombres;
        this.Apellidos = apellidos;
        this.Saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getNroCuenta() {
        return NroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        NroCuenta = nroCuenta;
    }

    public String getCi() {
        return Ci;
    }

    public void setCi(String ci) {
        Ci = ci;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public Double getSaldo() {
        return Saldo;
    }

    public void setSaldo(Double saldo) {
        Saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "banco=" + banco +
                ", NroCuenta='" + NroCuenta + '\'' +
                ", Ci='" + Ci + '\'' +
                ", Nombres='" + Nombres + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Saldo=" + Saldo +
                '}';
    }
}
