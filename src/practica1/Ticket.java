package practica1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {

    // Atributo estático utilizado para generar IDs consecutivos
    private static int cantidad = 0;

    // Atributos
    private int id;
    private String descripcion;
    private String nombreCompleto;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaResolucion;

    // Constructor
    public Ticket(String descripcion, String nombreCompleto) {

        cantidad++;

        this.id = cantidad;
        this.descripcion = descripcion;
        this.nombreCompleto = nombreCompleto;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaResolucion = null;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaResolucion() {
        return fechaResolucion;
    }

    // Método utilizado cuando el administrador resuelve el ticket
    public void resolver() {
        fechaResolucion = LocalDateTime.now();
    }

    // toString
    @Override
    public String toString() {

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        String resolucion;

        if (fechaResolucion == null) {
            resolucion = "Pendiente";
        } else {
            resolucion = fechaResolucion.format(formato);
        }

        return "\nID: " + id
                + "\nUsuario: " + nombreCompleto
                + "\nDescripcion: " + descripcion
                + "\nFecha de creacion: " + fechaCreacion.format(formato)
                + "\nFecha de resolucion: " + resolucion
                + "\n";
    }
}