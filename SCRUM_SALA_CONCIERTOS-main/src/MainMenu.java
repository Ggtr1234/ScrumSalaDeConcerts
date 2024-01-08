package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MainMenu {
    static String[][] clientes = new String[4][4];
    static String[][] empleados = new String[4][4];
    static ArrayList<String[]> contratadosGrupos = new ArrayList<>();
    static String[][] gruposDisponibles = {
            {"Grupo1", String.valueOf(new Random().nextBoolean()), "Genre1", "Country1"},
            {"Grupo2", String.valueOf(new Random().nextBoolean()), "Genre2", "Country2"},
            {"Grupo3", String.valueOf(new Random().nextBoolean()), "Genre3", "Country3"},
            {"Grupo4", String.valueOf(new Random().nextBoolean()), "Genre4", "Country4"}
    };

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);

        boolean salir = false;
        int opcion;

        do {
            System.out.println("   <-------------- Menu -------------->\n" +
                    "   Selecciona una opción: \n" +
                    "       1. Introducir/mostrar clientes.\n" +
                    "       2. Introducir/mostrar trabajadores.\n" +
                    "       3. Contratar grupo.\n" +
                    "       0. Salir.\n");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("submenu 1");
                    submenuClientes();
                    break;
                case 2:
                    System.out.println("submenu 2");
                    submenuEmpleados();
                    break;
                case 3:
                    contratarGrupos();
                    break;
                case 0:
                    salir = true;
                    System.out.println("Has salido del menú");
                    break;
                default:
                    System.out.println("Introduce una opción válida.");
                    break;
            }
        } while (!salir);

        sc.close();
    }

    public static void submenuEmpleados() {
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println(" <-------------- Submenu Empleados -------------->\n" +
                    "   Selecciona una opción: \n" +
                    "       1. Introducir empleados.\n" +
                    "       2. Mostrar empleados.\n" +
                    "       0. Volver atrás.");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introducir empleados...");

                    for (int i = 0; i < empleados.length; i++) {
                        System.out.print("Ingrese nombre del empleado: ");
                        empleados[i][0] = sc.next();

                        System.out.print("Ingrese apellido del empleado: ");
                        empleados[i][1] = sc.next();

                        System.out.print("Ingrese DNI del empleado: ");
                        empleados[i][2] = sc.next();

                        System.out.print("Ingrese cantidad de paga del empleado: ");
                        empleados[i][3] = sc.next();

                        System.out.println("¿Desea introducir más empleados? (1: Sí / 0: No)");
                        int continuar = sc.nextInt();
                        if (continuar != 1) {
                            opcion = 0;
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Mostrar empleados...");

                    for (int i = 0; i < empleados.length; i++) {
                        System.out.println("Empleado #" + (i + 1) +
                                "\nNombre: " + empleados[i][0] +
                                "\nApellido: " + empleados[i][1] +
                                "\nDNI: " + empleados[i][2] +
                                "\nCantidad de Paga: " + empleados[i][3] + "\n");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Introduce una opción válida.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void submenuClientes() {
        Scanner sc = new Scanner(System.in);

        int MAX_CLIENTES = 4;
        int opcion;

        do {
            System.out.println(" <-------------- Submenu Clientes -------------->\n" +
                    "   Selecciona una opción: \n" +
                    "       1. Introducir cliente.\n" +
                    "       2. Mostrar cliente.\n" +
                    "       0. Volver atrás.");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < MAX_CLIENTES; i++) {
                        System.out.print("Ingrese su nombre: ");
                        clientes[i][0] = sc.next();

                        System.out.print("Ingrese su apellido: ");
                        clientes[i][1] = sc.next();

                        System.out.print("Ingrese su DNI: ");
                        clientes[i][2] = sc.next();

                        boolean correcto = false;
                        while (!correcto) {
                            System.out.print("Ingrese el tipo de cliente (general/gratis/vip): ");
                            String tipoCliente = sc.next().toLowerCase();

                            if (tipoCliente.equals("general") || tipoCliente.equals("gratis") || tipoCliente.equals("vip")) {
                                clientes[i][3] = tipoCliente;
                                correcto = true;
                            } else {
                                System.out.println("Tipo cliente no válido. Por favor ingrese: (general, gratis, vip)");
                            }
                        }

                        System.out.println("¿Desea introducir más clientes? (1: Sí / 0: No)");
                        int continuar = sc.nextInt();
                        if (continuar != 1) {
                            opcion = 0;
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Datos de los clientes:");
                    System.out.println("+-----------------+-----------------+-----------------+-----------------+");
                    System.out.println("|      Nombre     |     Apellido    |       DNI       |    Tipo cliente |");
                    System.out.println("+-----------------+-----------------+-----------------+-----------------+");
                    for (int i = 0; i < MAX_CLIENTES; i++) {
                        System.out.printf("| %-15s | %-15s | %-15s | %-15s |\n", clientes[i][0], clientes[i][1], clientes[i][2], clientes[i][3]);
                    }
                    System.out.println("+-----------------+-----------------+-----------------+-----------------+");

                    opcion = 0;

                    break;
                case 0:
                    break;
                default:
                    System.out.println("Introduce una opción válida.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void contratarGrupos() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Grupos de Música disponibles");

                for (int i = 0; i < gruposDisponibles.length; i++) {
                    System.out.println((i + 1) + ". " + gruposDisponibles[i][0] +
                            " | Disponibilidad: " + gruposDisponibles[i][1] +
                            " | Género: " + gruposDisponibles[i][2] +
                            " | País: " + gruposDisponibles[i][3]);
                }

                System.out.println("Si quiere contratar un grupo elija el número que le corresponda. (para salir introduzca 0)");

                int eleccion = sc.nextInt();

                if (eleccion != 0 && eleccion <= gruposDisponibles.length) {
                    if (Boolean.parseBoolean(gruposDisponibles[eleccion - 1][1])) {
                        contratadosGrupos.add(gruposDisponibles[eleccion - 1]);
                        System.out.println("Ha contratado al grupo: " + gruposDisponibles[eleccion - 1][0]);
                    } else {
                        System.out.println("El grupo seleccionado no está disponible.");
                    }
                } else {
                    System.out.println("Ha salido del programa.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, introduzca un número entero válido.");
                sc.nextLine();
            }
        }

        System.out.println("Grupos contratados:");
        for (String[] grupo : contratadosGrupos) {
            System.out.println("Grupo: " + grupo[0] +
                    " | Disponibilidad: " + grupo[1] +
                    " | Género: " + grupo[2] +
                    " | País: " + grupo[3]);
        }
    }
}
