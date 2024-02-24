package ThirdExercise;

import java.util.ArrayList;

public class GestorTareas {
    private ArrayList<tarea> tareas;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(tarea tarea) {
        tareas.add(tarea);
    }

    public void marcarTareaComoCompletada(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.get(indice).setEstado(EstadoTarea.completada);
            System.out.println("La tarea ha sido marcada como completada.");
        } else {
            System.out.println("Índice de tarea inválido.");
        }
    }

    public void mostrarTareas() {
        System.out.println("\nLista de tareas:");
        for (int i = 0; i < tareas.size(); i++) {
            tarea tarea = tareas.get(i);
            System.out.println((i + 1) + ". Descripción: " + tarea.getDescripcion() +
                    " - Fecha límite: " + tarea.getFechaLimite() +
                    " - Estado: " + tarea.getEstado());
        }
    }
}
