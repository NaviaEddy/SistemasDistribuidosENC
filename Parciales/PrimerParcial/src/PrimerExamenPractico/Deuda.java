package PrimerExamenPractico;

import java.io.Serializable;

public class Deuda implements Serializable {
    String CI;
    Double Monto;
    int Anio;
    Impuesto Impuesto;
    String Observado;

    public Deuda(String CI, Double monto, int anio, PrimerExamenPractico.Impuesto impuesto, String observado) {
        this.CI = CI;
        this.Monto = monto;
        this.Anio = anio;
        this.Impuesto = impuesto;
        this.Observado = observado;
    }

    public String getObservado() {
        return Observado;
    }

    public void setObservado(String observado) {
        Observado = observado;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public Double getMonto() {
        return Monto;
    }

    public void setMonto(Double monto) {
        Monto = monto;
    }

    public int getAnio() {
        return Anio;
    }

    public void setAnio(int anio) {
        Anio = anio;
    }

    public PrimerExamenPractico.Impuesto getImpuesto() {
        return Impuesto;
    }

    public void setImpuesto(PrimerExamenPractico.Impuesto impuesto) {
        Impuesto = impuesto;
    }

    @Override
    public String toString() {
        return "Deuda{" +
                "CI='" + CI + '\'' +
                ", Monto=" + Monto +
                ", Anio=" + Anio +
                ", Impuesto=" + Impuesto +
                ", Observado='" + Observado + '\'' +
                '}';
    }
}
