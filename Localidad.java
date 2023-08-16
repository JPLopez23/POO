/*
 * Universidad del Valle de Guatemala
 * POO laboratorio #1
 * author Jose Pablo López López - José André Estrada Contreras
 * start day august 08, 2023
 * end day august 15, 2023
 */

public class Localidad {
    private int numeroLocalidad;
    private int precio;
    private int disponibilidad;

    public Localidad(int numeroLocalidad, int precio, int disponibilidad) {
        this.numeroLocalidad = numeroLocalidad;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    public int getNumeroLocalidad() {
        return numeroLocalidad;
    }

    public int getPrecio() {
        return precio;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public boolean venderBoletos(int cantidad) {
        if (disponibilidad >= cantidad) {
            disponibilidad -= cantidad;
            return true;
        }
        return false;
    }
}