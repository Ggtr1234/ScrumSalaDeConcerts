package src;

import java.util.*;

public class contratacionGrupos {
    public static void main(String[] args) {
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
