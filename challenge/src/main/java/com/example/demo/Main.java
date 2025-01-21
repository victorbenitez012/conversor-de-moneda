package src.main.java.com.example.demo;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        src.main.java.com.example.demo.CurrencyService service = new src.main.java.com.example.demo.CurrencyService();
        src.main.java.com.example.demo.JsonGenerator generator = new src.main.java.com.example.demo.JsonGenerator();
        List<src.main.java.com.example.demo.JsonGenerator.Conversion> conversiones = new ArrayList<>();

        System.out.println("Bienvenido al conversor de monedas.");

        while (true) {
            System.out.print("Ingrese la moneda origen (USD, EUR, ARS, BRL, COP): ");
            String monedaOrigen = scanner.nextLine().toUpperCase();

            System.out.print("Ingrese la moneda destino (USD, EUR, ARS, BRL, COP): ");
            String monedaDestino = scanner.nextLine().toUpperCase();

            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidadOrigen = scanner.nextDouble();
            scanner.nextLine(); // Limpiar buffer

            try {
                double cantidadDestino = service.convertirMoneda(monedaOrigen, monedaDestino, cantidadOrigen);
                src.main.java.com.example.demo.JsonGenerator.Conversion conversion = new src.main.java.com.example.demo.JsonGenerator.Conversion(monedaOrigen, monedaDestino, cantidadOrigen, cantidadDestino);
                conversiones.add(conversion);
                System.out.printf("%.2f %s equivalen a %.2f %s.\n", cantidadOrigen, monedaOrigen, cantidadDestino, monedaDestino);
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }

            System.out.print("¿Deseas hacer otra conversión? (s/n): ");
            String respuesta = scanner.nextLine().toLowerCase();

            if (respuesta.equals("n")) {
                try {
                    String jsonFinal = generator.generarJsonLista(conversiones);
                    generator.guardarJsonEnArchivo(jsonFinal, "conversiones.json");
                    System.out.println("Las conversiones se han guardado en el archivo conversiones.json.");
                } catch (Exception e) {
                    System.out.println("Error al guardar el archivo: " + e.getMessage());
                }
                break;
            }
        }

        scanner.close();
    }
}
