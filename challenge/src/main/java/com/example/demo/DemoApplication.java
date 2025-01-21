package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import src.main.java.com.example.demo.CurrencyService;
import src.main.java.com.example.demo.JsonGenerator;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CurrencyService service;

	@Autowired
	private JsonGenerator generator;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		List<JsonGenerator.Conversion> conversiones = new ArrayList<>();

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
				JsonGenerator.Conversion conversion = new JsonGenerator.Conversion(monedaOrigen, monedaDestino, cantidadOrigen, cantidadDestino);
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
