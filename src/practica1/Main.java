package practica1;

public class Main {

    public static void main(String[] args) {

        // Lista que almacenará los tickets resueltos
        ListaEnlazadaSimple ticketsResueltos =
                new ListaEnlazadaSimple();

        // Tickets temporales para probar la aplicación
        Ticket ticket1 = new Ticket(
                "No puedo iniciar sesion",
                "Steven Uria"
        );

        Ticket ticket2 = new Ticket(
                "La pagina no carga",
                "Juan Perez"
        );

        Ticket ticket3 = new Ticket(
                "No puedo cambiar mi contraseña",
                "Maria Rodriguez"
        );

        // Temporalmente simulamos que fueron resueltos
        ticket1.resolver();
        ticket2.resolver();
        ticket3.resolver();

        // Se almacenan en la lista de tickets resueltos
        ticketsResueltos.insertarInicio(ticket1);
        ticketsResueltos.insertarInicio(ticket2);
        ticketsResueltos.insertarInicio(ticket3);

        System.out.println("TICKETS RESUELTOS");

        ticketsResueltos.mostrarLista();

        System.out.println("BUSQUEDA");

        Ticket encontrado = ticketsResueltos.buscar(2);

        if (encontrado != null) {

            System.out.println("Ticket encontrado:");

            System.out.println(encontrado);

        } else {

            System.out.println(
                    "El ticket se encuentra pendiente."
            );
        }
    }
}