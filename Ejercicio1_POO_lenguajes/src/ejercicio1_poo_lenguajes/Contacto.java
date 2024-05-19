/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1_poo_lenguajes;

/**
 *
 * @author zumba
 */
public abstract class Contacto {
    private final Persona persona;

    public Contacto(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    @Override
    public String toString() {
        return "Contacto{" + "persona=" + persona + '}';
    }
}





