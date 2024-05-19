/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1_poo_lenguajes;

/**
 *
 * @author zumba
 */
public class ContactoFamiliar extends Contacto {
    private final String parentesco;

    public ContactoFamiliar(Persona persona, String parentesco) {
        super(persona);
        this.parentesco = parentesco;
    }

    public String getParentesco() {
        return parentesco;
    }

    @Override
    public String toString() {
        return "ContactoFamiliar{" + "persona=" + getPersona() + ", parentesco=" + parentesco + '}';
    }
}
