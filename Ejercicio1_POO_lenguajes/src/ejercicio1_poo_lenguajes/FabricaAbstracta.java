/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejercicio1_poo_lenguajes;

/**
 *
 * @author zumba
 */
public interface FabricaAbstracta {
    Contacto crearContacto(String tipo, Persona persona, String detalle1, String detalle2);
    Evento crearEvento(String tipo, String nombre, String fecha, String lugar, String detalle);
}

