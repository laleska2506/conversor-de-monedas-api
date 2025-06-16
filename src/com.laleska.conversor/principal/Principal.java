import api.Conexion;
import modelos.Moneda;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conexion con = new Conexion();

        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("Bienvenido a tu Conversor de Monedas");
            System.out.println("--------------------------------------------------");
            System.out.println(" 1. Dólar => Peso argentino");
            System.out.println(" 2. Peso argentino => Dólar");
            System.out.println(" 3. Dólar => Real Brasileño");
            System.out.println(" 4. Real Brasileño => Dólar");
            System.out.println(" 5. Dólar => Peso colombiano");
            System.out.println(" 6. Peso colombiano => Dólar");
            System.out.println(" 7. Otro tipo de moneda...");
            System.out.println(" 8. Salir");
            System.out.println("--------------------------------------------------");
            System.out.print("Ingrese su opción: ");
            String opcion = sc.nextLine();

            String monedaInicial = "";
            String monedaFinal = "";
            double monto = 0;

            try {
                switch (opcion) {
                    case "1":
                        monedaInicial = "USD";
                        monedaFinal = "ARS";
                        break;
                    case "2":
                        monedaInicial = "ARS";
                        monedaFinal = "USD";
                        break;
                    case "3":
                        monedaInicial = "USD";
                        monedaFinal = "BRL";
                        break;
                    case "4":
                        monedaInicial = "BRL";
                        monedaFinal = "USD";
                        break;
                    case "5":
                        monedaInicial = "USD";
                        monedaFinal = "COP";
                        break;
                    case "6":
                        monedaInicial = "COP";
                        monedaFinal = "USD";
                        break;
                    case "7":
                        System.out.print("Ingresa las siglas de la moneda que quieres cambiar: ");
                        monedaInicial = sc.nextLine().trim().toUpperCase();
                        System.out.print("Ingresa la siglas de la moneda a la cual quieres cambiar: ");
                        monedaFinal = sc.nextLine().trim().toUpperCase();
                        break;
                    case "8":
                        System.out.println("¡Gracias por usar el conversor de monedas!");
                        return;
                    default:
                        System.out.println("Opción inválida. Intenta nuevamente.");
                        continue;
                }

                System.out.print("Ingrese el monto: ");
                monto = sc.nextDouble();
                sc.nextLine(); // Limpiar buffer

                Moneda moneda = con.obtenerCambio(monedaInicial, monedaFinal, monto);
                if (moneda != null) {
                    System.out.println("_________________________________");
                    System.out.println(moneda);
                } else {
                    System.out.println("No se pudo obtener la conversión.");
                }

            } catch (IOException | InterruptedException e) {
                System.out.println("Error al realizar la conversión: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Entrada inválida. Intenta nuevamente.");
                e.printStackTrace();
                sc.nextLine(); // Limpiar buffer en caso de error
            }

            System.out.println(); // Salto de línea entre iteraciones
        }
    }
}
