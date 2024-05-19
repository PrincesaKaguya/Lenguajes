/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1_poo_lenguajes;

/**
 *
 * @author zumba
 */
public class EventoConferencia extends Evento {
    private final String orador;

    public EventoConferencia(String nombre, String fecha, String lugar, String orador) {
        super(nombre, fecha, lugar);
        this.orador = orador;
    }

    public String getOrador() {
        return orador;
    }

    @Override
    public String toString() {
        return "EventoConferencia{" + "nombre=" + getNombre() + ", fecha=" + getFecha() + ", lugar=" + getLugar() + ", orador=" + orador + '}';
    }
}
