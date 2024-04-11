package EjercicioPrimerParcial;

import java.io.Serializable;

public class Cuenta implements Serializable {
    private Banco TBancos;
    private String nroCuenta, nombres, apellidos, Ci;
    private Double saldo;

    public Cuenta(Banco banco, String nroCuenta, String ci, String nombres, String apellidos, Double saldo) {
        this.TBancos = banco;
        this.nroCuenta = nroCuenta;
        this.Ci = ci;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.saldo = saldo;
    }

    public Banco getTBancos() {
        return TBancos;
    }

    public void setTBancos(Banco TBancos) {
        this.TBancos = TBancos;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getCi() {
        return Ci;
    }

    public void setCi(String ci) {
        Ci = ci;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "Banco=" + TBancos +
                ", nroCuenta='" + nroCuenta + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
