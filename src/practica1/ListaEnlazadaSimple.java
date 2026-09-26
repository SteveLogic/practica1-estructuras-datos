package practica1;

public class ListaEnlazadaSimple {

    // Atributos
    private NodoLista primero;

    // Constructor
    public ListaEnlazadaSimple() {
        primero = null;
    }

 

 
    private void setPrimero(NodoLista primero) {
        this.primero = primero;
    }

    // Operaciones
    private boolean estaVacia() {
        return primero == null;
    }

    public void insertarInicio(Ticket ticket) {

        NodoLista nodo = new NodoLista(ticket);

        nodo.setSiguiente(primero);

        setPrimero(nodo);
    }

    public Ticket buscar(int id) {

        if (estaVacia()) {
            return null;
        }

        NodoLista temp = primero;

        while (temp != null) {

            if (temp.getTicket().getId() == id) {
                return temp.getTicket();
            }

            temp = temp.getSiguiente();
        }

        return null;
    }

    public void mostrarLista() {

        if (estaVacia()) {
            System.out.println("La lista esta vacia.");
            return;
        }

        NodoLista temp = primero;

        while (temp != null) {

            System.out.println(temp.getTicket());

            temp = temp.getSiguiente();
        }
    }


    private class NodoLista {

        // Atributos
        private Ticket ticket;
        private NodoLista siguiente;

        // Constructor
        public NodoLista(Ticket ticket) {
            this.ticket = ticket;
            siguiente = null;
        }

        // Getters
        public Ticket getTicket() {
            return ticket;
        }

        public NodoLista getSiguiente() {
            return siguiente;
        }

        // Setters


        public void setSiguiente(NodoLista siguiente) {
            this.siguiente = siguiente;
        }
    }
}