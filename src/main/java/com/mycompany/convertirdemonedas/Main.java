package com.mycompany.convertirdemonedas;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        consultarMoneda resuConsultarMoneda = new consultarMoneda();

        mostrarConversionRates();

        int option;
        do {
            mostrarMenu();
            option = leerOpcion(scanner);

            procesarOpcion(option, resuConsultarMoneda, scanner);
        } while (option != 9);

        scanner.close();
    }
    
    private static void mostrarConversionRates() {
        System.out.println("""
                    "conversion_rates Keys (Latinoamérica)":
                      "ARS" | Argentina,
                      "BOB" | Bolivia,
                      "BRL" | Brasil,
                      "CLP" | Chile,
                      "COP" | Colombia,
                      "CRC" | Costa Rica,
                      "CUP" | Cuba,
                      "DOP" | República Dominicana,
                      "ECU" | Ecuador (usa USD),
                      "GTQ" | Guatemala,
                      "HNL" | Honduras,
                      "MXN" | México,
                      "NIO" | Nicaragua,
                      "PAB" | Panamá (usa USD),
                      "PEN" | Perú,
                      "PYG" | Paraguay,
                      "SRD" | Surinam,
                      "UYU" | Uruguay,
                      "VES" | Venezuela
                """);
    }

    private static void mostrarMenu() {
        System.out.println("-------------------------------");
        System.out.println("Ingresa la opción que deseas: ");
        System.out.println("1. Convertir");
        System.out.println("9. Salir");
    }

    private static int leerOpcion(Scanner scanner) {
        System.out.print("Selecciona una opción: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingresa un número válido.");
            scanner.next(); // Descarta la entrada no válida
        }
        return scanner.nextInt();
    }

    private static void procesarOpcion(int option, consultarMoneda resuConsultarMoneda, Scanner scanner) {
        switch (option) {
            case 1:
                convertidorMonedas.convertirMoneda(resuConsultarMoneda, scanner);
                break;
            case 9:
                System.out.println("Gracias por utilizar ExchangeRateAPI");
                break;
            default:
                System.out.println("Opción inválida. Intenta nuevamente."); // Rojo
        }
    }
}
