package src;

import java.util.Arrays;
import java.util.Scanner;
public class datos_clientes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max_clientes = 200; // numero maximo de clientes(prueba)
        String[] nombres_clientes = new String[max_clientes];
        String[] apelllidos_clientes = new String[max_clientes];
        String[] dni_clientes = new String[max_clientes];

        //Se pide a los usuarios que ingresen sus datos.
        for (int i = 0; i < max_clientes; i++) {
            System.out.print("Ingrese su nombre: ");
            nombres_clientes[i] = sc.nextLine();

            System.out.print("Ingrese su apellido: ");
            apelllidos_clientes[i] = sc.nextLine();

            System.out.print("Ingrese su DNI: ");
            dni_clientes[i] = sc.nextLine();
            System.out.println();

        }// Se muestran los datos de todos los clientes
        for (int i = 0; i < max_clientes; i++) {
            System.out.println("Cliente #" + (i + 1) + "\n" + "Nombre: " + nombres_clientes[i] + "\n" + "Apellido: " + apelllidos_clientes[i] + "\n" + "DNI: " + dni_clientes[i] + "\n");


        }
    }
}
