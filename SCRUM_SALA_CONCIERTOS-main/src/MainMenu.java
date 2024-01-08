import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
       mainMenu();
    }
    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);

        boolean sortir = false;
        int option;
        do {
            System.out.println("   <-------------- Menu -------------->\n" +
                    "   Selecciona una opció: \n" +
                    "       1. Introducir/mostrar clientes.\n" +
                    "       2. Introducir/mostrar trabajadores.\n" +
                    "       3. Contratar grupo.\n" +
                    "       0. Salir.\n");
            System.out.print("Opcion: ");

            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("submenu 1");
                    submenuClients();
                    break;
                case 2:
                    System.out.println("submenu 2");
                    submenuEmployees();
                    break;
                case 3:
                    contratarGrupos();
                    break;
                case 4:
                    System.out.println("submenu 4");
                    break;
                case 0:
                    sortir = true;
                    System.out.println("Has sortit del menu");
                    break;
                default:
                    System.out.println("Introdueix una opcio valida!");
                    break;
            }
        } while (!sortir);
    }
    public static void submenuEmployees() {
        Scanner sc = new Scanner(System.in);

        int option;
        do {
            System.out.println(" <-------------- Submenu Empleados -------------->\n" +
                    "   Selecciona una opció: \n" +
                    "       1. Introducir empleados.\n" +  //1
                    "       2. Mostrar empleados.\n" +   //2
                    "       0. Volver atras.");
            System.out.print("Opcion: ");

            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Introduce employees...");
                    break;
                case 2:
                    System.out.println("Show employees...");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Introdueix una opcio valida!");
                    break;
            }
        }while (option != 0);

    }
    public static void submenuClients() {
        Scanner sc = new Scanner(System.in);

        int MAX_CLIENTES = 4;
        String[] nombresClientes = new String[MAX_CLIENTES];
        String[] apellidosClientes = new String[MAX_CLIENTES];
        String[] dniClientes = new String[MAX_CLIENTES];

        int option;
        do {
            System.out.println(" <-------------- Submenu Clientes -------------->\n" +
                    "   Selecciona una opció: \n" +
                    "       1. Introducir cliente.\n" +  //1
                    "       2. Mostrar cliente.\n" +   //2
                    "       0. Volver atras.");
            System.out.print("Opcion: ");

            option = sc.nextInt();
            switch (option) {
                case 1:
                    //Se pide a los usuarios que ingresen sus datos.
                    for (int i = 0; i < MAX_CLIENTES; i++) {
                        System.out.print("Ingrese su nombre: ");
                        nombresClientes[i] = sc.nextLine(); sc.next();

                        System.out.print("Ingrese su apellido: ");
                        apellidosClientes[i] = sc.nextLine();sc.next();

                        System.out.print("Ingrese su DNI: ");
                        dniClientes[i] = sc.nextLine();sc.next();
                        System.out.println();
                    }
                    break;
                case 2:
                    for (int i = 0; i < MAX_CLIENTES; i++) {
                        System.out.println("Cliente #" + (i + 1) + "\n" + "Nombre: " + nombresClientes[i] +
                                "\n" + "Apellido: " + apellidosClientes[i] + "\n" + "DNI: " + dniClientes[i] + "\n");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Introdueix una opcio valida!");
                    break;
            }
        }while (option != 0);
    }
    public static void contratarGrupos(){
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        String[][] Grupos = {
                {"Grupo1", String.valueOf(rd.nextBoolean()), "Genre1", "Country1"},
                {"Grupo2", String.valueOf(rd.nextBoolean()), "Genre2", "Country2"},
                {"Grupo3", String.valueOf(rd.nextBoolean()), "Genre3", "Country3"},
                {"Grupo4", String.valueOf(rd.nextBoolean()), "Genre4", "Country4"}
        };

        ArrayList<String[]> Grupos_contratados = new ArrayList<>();

        while (true) {
            try {
                System.out.println("Grupos de Musica disponibles");

                for (int i = 0; i < Grupos.length; i++) {
                    System.out.println((i + 1) + ". " + Grupos[i][0] +
                            " | Disponibilidad: " + Grupos[i][1] +
                            " | Genre: " + Grupos[i][2] +
                            " | Country: " + Grupos[i][3]);
                }

                System.out.println("Si quiere contratar un grupo elija el numero que le corresponda. (para salir intruduzca 0)");

                int a = sc.nextInt();

                if (a != 0 && a <= Grupos.length) {
                    if (Boolean.parseBoolean(Grupos[a - 1][1])) {
                        Grupos_contratados.add(Grupos[a - 1]);
                        System.out.println("Ha contratado al grupo: " + Grupos[a - 1][0]);
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
        for (String[] grupo : Grupos_contratados) {
            System.out.println("Grupo: " + grupo[0] +
                    " | Disponibilidad: " + grupo[1] +
                    " | Genre: " + grupo[2] +
                    " | Country: " + grupo[3]);
        }
    }
}
