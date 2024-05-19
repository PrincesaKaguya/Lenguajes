/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1_poo_lenguajes;

/**
 *
 * @author zumba
 */
public class ContactoEmpresarial extends Contacto {
    private final String empresa;
    private final String puesto;

    public ContactoEmpresarial(Persona persona, String empresa, String puesto) {
        super(persona);
        this.empresa = empresa;
        this.puesto = puesto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    @Override
    public String toString() {
        return "ContactoEmpresarial{" + "persona=" + getPersona() + ", empresa=" + empresa + ", puesto=" + puesto + '}';
    }
}
