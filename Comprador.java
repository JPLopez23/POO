/*
 * Universidad del Valle de Guatemala
 * POO laboratorio #1
 * author Jose Pablo López López - José André Estrada Contreras
 * start day august 08, 2023
 * end day august 15, 2023
 */

import java.util.Scanner;
import java.util.Random;

public class Comprador {
    private String nombre;
    private long DPI;
    private int cantidad_boletos;
    private double presupuesto_max;

    public Comprador(String nombre, long DPI, int cantidad_boletos, double presupuesto_max) {
        this.nombre = nombre;
        this.DPI = DPI;
        this.cantidad_boletos = cantidad_boletos;
        this.presupuesto_max = presupuesto_max;
    }

    public void realizarSolicitudCompra(Localidad[] localidades, Scanner teclado) {
        Random generador = new Random();
        int ticket = generador.nextInt(33000) + 1;
        int a = generador.nextInt(15000) + 1;
        int b = generador.nextInt(15000) + 1;

        if ((ticket + a + b) % 2 == 0) {
            System.out.println("Ticket " + ticket + " apto para compra.");

            System.out.println("Elija la localidad según su presupuesto:");
            System.out.println("a. Localidad 1 - La más alejada del escenario pero la más barata con un precio de $400.");
            System.out.println("b. Localidad 5 - En medio y con una mejor vista al escenario pero con un precio de $695.");
            System.out.println("c. Localidad 10 - Hasta adelante, la mejor vista del concierto pero la más cara con un precio de $2350.");

            char eleccionLocalidad = teclado.next().charAt(0);

            switch (eleccionLocalidad) {
                case 'a':
                    comprarBoletos(localidades[0], teclado);
                    break;
                case 'b':
                    comprarBoletos(localidades[1], teclado);
                    break;
                case 'c':
                    comprarBoletos(localidades[2], teclado);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("Ticket " + ticket + " no apto para compra.");
        }
    }

    private void comprarBoletos(Localidad localidad, Scanner teclado) {
        System.out.println("Ha elegido la " + localidad.getNumeroLocalidad() + ".");
        System.out.println("Disponibles: " + localidad.getDisponibilidad() + ", Precio: $" + localidad.getPrecio());

        System.out.print("Ingrese la cantidad de boletos a comprar (máximo 20): ");
        int cantidadBoletos = teclado.nextInt();

        if (cantidadBoletos <= 20 && cantidadBoletos <= localidad.getDisponibilidad()) {
            System.out.print("¿Desea comprar los boletos? (s/n): ");
            char respuesta = teclado.next().charAt(0);
            if (respuesta == 's' || respuesta == 'S') {
                if (localidad.venderBoletos(cantidadBoletos)) {
                    System.out.println("Boletos comprados exitosamente.");
                    return;
                }
            }
            System.out.println("Compra cancelada.");
        } else {
            System.out.println("No se pueden comprar esa cantidad de boletos en esta localidad.");
        }
    }
}
