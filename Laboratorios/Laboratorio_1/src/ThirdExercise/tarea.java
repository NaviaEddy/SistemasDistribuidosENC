package ThirdExercise;

public class tarea {
    private String descripcion;
    private String fechaLimite;
    private EstadoTarea estado;

    public tarea(String descripcion, String fechaLimite) {
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.estado = EstadoTarea.pendiente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }
}
