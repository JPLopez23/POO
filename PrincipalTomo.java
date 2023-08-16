/*
 * Universidad del Valle de Guatemala
 * POO laboratorio #1
 * author Jose Pablo López López - José André Estrada Contreras
 * start day august 08, 2023
 * end day august 15, 2023
 */

import java.util.Scanner;

public class PrincipalTomo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Comprador comprador = null;
        Localidad[] localidades = {
            new Localidad(1, 400, 20),
            new Localidad(5, 695, 20),
            new Localidad(10, 2350, 20)
        };

        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenú Principal");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");

            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    comprador = nuevoComprador(teclado);
                    break;
                case 2:
                    if (comprador != null) {
                        realizarSolicitudCompra(comprador, localidades, teclado);
                    } else {
                        System.out.println("Primero debe registrar un comprador.");
                    }
                    break;
                case 3:
                    consultarDisponibilidadTotal(localidades);
                    break;
                case 4:
                    consultarDisponibilidadIndividual(teclado, localidades);
                    break;
                case 5:
                    reporteDeCaja(localidades);
                    break;
                case 6:
                    salir = true;
                    System.out.println("Feliz día :)");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    public static Comprador nuevoComprador(Scanner teclado) {
        System.out.print("Ingrese el nombre del comprador: ");
        String nombre = teclado.next();
        System.out.print("Ingrese el DPI del comprador: ");
        Long DPI = teclado.nextLong();
        System.out.print("Ingrese la cantidad de boletos a comprar: ");
        int cantidadBoletos = teclado.nextInt();
        System.out.print("Ingrese el presupuesto máximo del comprador: ");
        double presupuestoMax = teclado.nextDouble();

        return new Comprador(nombre, DPI, cantidadBoletos, presupuestoMax);
    }

    public static void realizarSolicitudCompra(Comprador comprador, Localidad[] localidades, Scanner teclado) {
        comprador.realizarSolicitudCompra(localidades, teclado);
    }

    public static void consultarDisponibilidadTotal(Localidad[] localidades) {
        System.out.println("Disponibilidad total:");
        for (Localidad localidad : localidades) {
            System.out.println("Localidad " + localidad.getNumeroLocalidad() + " - Vendidos: " + (20 - localidad.getDisponibilidad()) + ", Disponibles: " + localidad.getDisponibilidad());
        }
    }

    public static void consultarDisponibilidadIndividual(Scanner teclado, Localidad[] localidades) {
        System.out.print("Ingrese el número de la localidad para consultar disponibilidad (1, 5, 10): ");
        int numeroLocalidad = teclado.nextInt();

        for (Localidad localidad : localidades) {
            if (localidad.getNumeroLocalidad() == numeroLocalidad) {
                System.out.println("Disponibles en Localidad " + localidad.getNumeroLocalidad() + ": " + localidad.getDisponibilidad());
                return;
            }
        }
        System.out.println("Localidad no válida.");
    }

    public static void reporteDeCaja(Localidad[] localidades) {
        double totalRecaudado = 0;
        for (Localidad localidad : localidades) {
            int boletosVendidos = 20 - localidad.getDisponibilidad();
            totalRecaudado += boletosVendidos * localidad.getPrecio();
        }
        System.out.println("Reporte de caja:");
        System.out.println("Total recaudado: $" + totalRecaudado);
    }
}
