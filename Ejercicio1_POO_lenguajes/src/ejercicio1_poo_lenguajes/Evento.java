/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1_poo_lenguajes;

/**
 *
 * @author zumba
 */
public abstract class Evento {
    private final String nombre;
    private final String fecha;
    private final String lugar;

    public Evento(String nombre, String fecha, String lugar) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    @Override
    public String toString() {
        return "Evento{" + "nombre=" + nombre + ", fecha=" + fecha + ", lugar=" + lugar + '}';
    }
}
