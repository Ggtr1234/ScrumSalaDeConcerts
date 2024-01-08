import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("        <-------------- Menu -------------->\n" +
                "   Selecciona una opció: \n" +
                "       0. Introducir/mostrar empleados.\n" +
                "       1. Introducir/mostrar trabajadores.\n" +
                "       2. Configurar/mostrar precios de entradas.\n" +
                "       3. Configurar/mostrar lista de productos.\n" +
                "       4. Salir.\n");

        System.out.print("Opcion: ");
        int entrada = sc.nextInt();
        switch (entrada){
            case 0:
                System.out.println("Estas en la opción 0");
                break;
            case 1:
                System.out.println("Estas en la opcion 1");
                break;
            case 2:
                System.out.println("Estas en la opcion 2");
                break;
            case 3:
                System.out.println("Estas en la opcion 3");
                break;
            case 4:
                System.out.println("Estas en la opcion 4");
                break;
            default:
                System.out.println("Introduce una opcion valida");
                break;

        }




    }
}