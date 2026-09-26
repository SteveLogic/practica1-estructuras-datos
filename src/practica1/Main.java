package practica1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Estructuras de datos principales del sistema
        ColaPrioridad ticketsPendientes = new ColaPrioridad();
        ListaEnlazadaSimple ticketsResueltos = new ListaEnlazadaSimple();

        int opcion;

        do {

            System.out.println("\n=================================");
            System.out.println("       SISTEMA DE TICKETS");
            System.out.println("=================================");
            System.out.println("1. Menu de usuario");
            System.out.println("2. Menu de administrador");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = leerOpcion(scanner);

            switch (opcion) {

                case 1:
                    menuUsuario(
                            scanner,
                            ticketsPendientes,
                            ticketsResueltos
                    );
                    break;

                case 2:
                    menuAdministrador(
                            scanner,
                            ticketsPendientes,
                            ticketsResueltos
                    );
                    break;

                case 3:
                    System.out.println("\nSaliendo del sistema...");
                    break;

                default:
                    System.out.println("\nOpcion invalida.");
            }

        } while (opcion != 3);

        scanner.close();
    }


    // Menu de usuario
    private static void menuUsuario(
            Scanner scanner,
            ColaPrioridad ticketsPendientes,
            ListaEnlazadaSimple ticketsResueltos) {

        int opcion;

        do {

            System.out.println("\n=================================");
            System.out.println("         MENU DE USUARIO");
            System.out.println("=================================");
            System.out.println("1. Crear ticket");
            System.out.println("2. Buscar ticket resuelto");
            System.out.println("3. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            opcion = leerOpcion(scanner);

            switch (opcion) {

                case 1:
                    crearTicket(scanner, ticketsPendientes);
                    break;

                case 2:
                    buscarTicket(scanner, ticketsResueltos);
                    break;

                case 3:
                    System.out.println("\nRegresando al menu principal...");
                    break;

                default:
                    System.out.println("\nOpcion invalida.");
            }

        } while (opcion != 3);
    }


    // Crear un nuevo ticket
    private static void crearTicket(
            Scanner scanner,
            ColaPrioridad ticketsPendientes) {

        System.out.println("\n=== CREAR TICKET ===");

        System.out.print("Nombre completo: ");
        String nombreCompleto = scanner.nextLine();

        System.out.print("Descripcion del problema: ");
        String descripcion = scanner.nextLine();

        Ticket nuevoTicket =
                new Ticket(descripcion, nombreCompleto);

        ticketsPendientes.insertar(nuevoTicket);

        System.out.println("\nTicket creado correctamente.");
        System.out.println("Su ID es: " + nuevoTicket.getId());
        System.out.println("Conserve este ID para consultar el ticket.");
    }


    // Buscar un ticket en la lista de resueltos
    private static void buscarTicket(
            Scanner scanner,
            ListaEnlazadaSimple ticketsResueltos) {

        System.out.println("\n=== BUSCAR TICKET ===");

        System.out.print("Ingrese el ID del ticket: ");

        int id = leerOpcion(scanner);

        Ticket ticket = ticketsResueltos.buscar(id);

        if (ticket != null) {

            System.out.println("\nTicket encontrado:");
            System.out.println(ticket);

        } else {

            System.out.println(
                    "\nEl ticket se encuentra pendiente."
            );
        }
    }


    // Menu de administrador
    private static void menuAdministrador(
            Scanner scanner,
            ColaPrioridad ticketsPendientes,
            ListaEnlazadaSimple ticketsResueltos) {

        int opcion;

        do {

            System.out.println("\n=================================");
            System.out.println("      MENU DE ADMINISTRADOR");
            System.out.println("=================================");
            System.out.println("1. Ver ticket al frente");
            System.out.println("2. Resolver ticket al frente");
            System.out.println("3. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            opcion = leerOpcion(scanner);

            switch (opcion) {

                case 1:
                    verTicketAlFrente(ticketsPendientes);
                    break;

                case 2:
                    resolverTicket(
                            ticketsPendientes,
                            ticketsResueltos
                    );
                    break;

                case 3:
                    System.out.println(
                            "\nRegresando al menu principal..."
                    );
                    break;

                default:
                    System.out.println("\nOpcion invalida.");
            }

        } while (opcion != 3);
    }


    // Mostrar el ticket que está al frente
    private static void verTicketAlFrente(
            ColaPrioridad ticketsPendientes) {

        System.out.println("\n=== TICKET AL FRENTE ===");

        Ticket ticket = ticketsPendientes.verFrente();

        if (ticket != null) {
            System.out.println(ticket);
        }
    }


    // Resolver el ticket al frente
    private static void resolverTicket(
            ColaPrioridad ticketsPendientes,
            ListaEnlazadaSimple ticketsResueltos) {

        Ticket ticket = ticketsPendientes.eliminar();

        if (ticket != null) {

            ticket.resolver();

            ticketsResueltos.insertarInicio(ticket);

            System.out.println("\nTicket resuelto correctamente.");

            System.out.println(ticket);
        }
    }


    // Leer una opción numérica de forma segura
    private static int leerOpcion(Scanner scanner) {

        try {

            int opcion =
                    Integer.parseInt(scanner.nextLine());

            return opcion;

        } catch (NumberFormatException e) {

            return -1;
        }
    }
}