package src;

import java.util.Scanner;

public class Consumiciones {
    private static String[][] productos = {
            {"Cerveza", "3.50"},
            {"Agua", "1.50"},
            {"Hamburgesa", "5.00"},
            {"Pizza", "4.00"}
    };

    public static void realizarConsumicion() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Lista de productos:");
        for (int i = 0; i < productos.length; i++) {
            System.out.println((i + 1) + ". " + productos[i][0] + " - €" + productos[i][1]);
        }

        System.out.println("Ingrese el número del producto que desea consumir (0 para salir):");
        int opcionProducto = sc.nextInt();

        double totalConsumido = 0.0;

        while (opcionProducto != 0) {
            if (opcionProducto >= 1 && opcionProducto <= productos.length) {
                System.out.println("Ingrese la cantidad de " + productos[opcionProducto - 1][0] + " consumida:");
                int cantidad = sc.nextInt();

                double costoUnitario = Double.parseDouble(productos[opcionProducto - 1][1]);
                double costoTotal = cantidad * costoUnitario;

                System.out.println("Costo total de " + cantidad + " " + productos[opcionProducto - 1][0] + ": $" + costoTotal);
                totalConsumido += costoTotal;
            } else {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

            System.out.println("Ingrese el número del siguiente producto que desea consumir (0 para finalizar):");
            opcionProducto = sc.nextInt();
        }

        System.out.println("Total de consumición: $" + totalConsumido);
    }
}
