package practica1;

import java.util.ArrayList;

public class ColaPrioridad {

    // Atributos
    private ArrayList<Ticket> cola;

    // Constructor
    public ColaPrioridad() {
        cola = new ArrayList<>();
    }

    // Operaciones
    private boolean estaVacia() {
        return cola.isEmpty();
    }
    // Los tickets se ordenan por ID.
    // Un ID menor representa un ticket creado anteriormente,
    // por lo que tiene mayor prioridad de atención.

    public void insertar(Ticket ticket) {

    int posicion = 0;

        while (posicion < cola.size()
                && cola.get(posicion).getId() < ticket.getId()) {

            posicion++;
        }

        cola.add(posicion, ticket);
    }

    public Ticket eliminar() {

        if (estaVacia()) {
            System.out.println("La cola esta vacia.\n");
            return null;
        }

        return cola.remove(0);
    }

    public Ticket verFrente() {

        if (estaVacia()) {
            System.out.println("La cola esta vacia.\n");
            return null;
        }

        return cola.get(0);
    }
}