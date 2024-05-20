/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejercicio1_poo_lenguajes;

/**
 *
 * @author zumba
 */
public class FabricaConcreta implements FabricaAbstracta {
    @Override
    public Contacto crearContacto(String tipo, Persona persona, String detalle1, String detalle2) {
        switch (tipo) {
            case "simple" -> {
                return new ContactoSimple(persona);
            }
            case "familiar" -> {
                return new ContactoFamiliar(persona, detalle1);
            }
            case "empresarial" -> {
                return new ContactoEmpresarial(persona, detalle1, detalle2);
            }
            default -> throw new IllegalArgumentException("Tipo de contacto no soportado.");
        }
    }

    @Override
    public Evento crearEvento(String tipo, String nombre, String fecha, String lugar, String detalle) {
        switch (tipo) {
            case "simple" -> {
                return new EventoSimple(nombre, fecha, lugar);
            }
            case "conferencia" -> {
                return new EventoConferencia(nombre, fecha, lugar, detalle);
            }
            default -> throw new IllegalArgumentException("Tipo de evento no soportado.");
        }
    }
}
