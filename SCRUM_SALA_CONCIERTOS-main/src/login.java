package src;

import java.util.Scanner;
import java.util.Arrays;
public class login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nombres = {"Juan", "Andres", "German", "franscisco", "Joel07", "Marcos7", "JAPV", "Marc16"};
        String[] contrasena = {"0245", "3564", "8974", "54875", "2486", "56897", "1456","A4586"};
        System.out.println("Bienvenido"+"\ningresa 1 si tienes una cuenta" +"\nIngresa 2 si deseas crear una cuenta nueva");
        int opcion = sc.nextInt();
        if (opcion == 1) {
            System.out.println("Ingresa tu nombre de usuario");
            String nomUsuario = sc.next();

            System.out.println("Ingresa tu contraseña: ");
            String contrasenaIngresada = sc.next();
            boolean verificacion = false;
            for (int i = 0; i < nombres.length; i++) {
                if (nomUsuario.equals(nombres[i]) && contrasenaIngresada.equals(contrasena[i])) {
                    verificacion = true;

                }
            }
            if (verificacion) {
                System.out.print("Inicio de sesión exitoso");
            } else {
                System.out.println("Nombre de usuario o contraseña incorrectos");
            }
            sc.close();

        }
        if (opcion == 2) {
            System.out.println("Por favor ingresa un nombre de usuario");
            String usuarioNnuevo;
            boolean encontrado = true;
            while (encontrado){
                usuarioNnuevo = sc.next();
                encontrado = false;
                for (int i = 0; i < nombres.length; i++) {
                    if(usuarioNnuevo.equals(nombres[i])){
                        System.out.println("Usuario en uso, por favor ingresa otro usuario");
                        encontrado = true;
                    }
                }
            }
            System.out.println("Ingresa tu contraseña");
            String contrasenaNueva = sc.next();
            System.out.println();
            System.out.println("Creación de cuenta exitosa");
        }
    }
}
