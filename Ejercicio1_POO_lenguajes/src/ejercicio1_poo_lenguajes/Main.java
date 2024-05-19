/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1_poo_lenguajes;

/**
 *
 * @author zumba
 */
public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        // Crear personas
        Persona persona1 = new Persona("Juan", "Perez", "123456789", "juanperez@example.com");
        Persona persona2 = new Persona("Ana", "Lopez", "987654321", "analopez@example.com");
        Persona persona3 = new Persona("Carlos", "Garcia", "456789123", "cargarcia@example.com");

        // Crear contactos
        ContactoSimple contacto1 = new ContactoSimple(persona1);
        ContactoFamiliar contacto2 = new ContactoFamiliar(persona2, "Hermana");
        ContactoEmpresarial contacto3 = new ContactoEmpresarial(persona3, "TechCorp", "Ingeniero");

        // Crear eventos
        EventoSimple evento1 = new EventoSimple("Reunion de amigos", "2024-05-21", "Casa de Juan");
        EventoConferencia evento2 = new EventoConferencia("Conferencia de Tecnología", "2024-06-15", "Centro de Convenciones", "Dr. Smith");

        // Agregar contactos y eventos a la agenda
        agenda = agenda.agregarItem(contacto1);
        agenda = agenda.agregarItem(contacto2);
        agenda = agenda.agregarItem(contacto3);
        agenda = agenda.agregarItem(evento1);
        agenda = agenda.agregarItem(evento2);

        // Mostrar todos los ítems
        System.out.println("Todos los items en la agenda:");
        agenda.mostrarItems();

        // Filtrar y mostrar contactos
        System.out.println("\nContactos en la agenda:");
        agenda.filtrarContactos().forEach(System.out::println);

        // Filtrar y mostrar eventos
        System.out.println("\nEventos en la agenda:");
        agenda.filtrarEventos().forEach(System.out::println);
    }
}

/*
run:
Todos los items en la agenda:
Contacto{persona=Persona{nombre=Juan, apellido=Perez, telefono=123456789, email=juanperez@example.com}}
ContactoFamiliar{persona=Persona{nombre=Ana, apellido=Lopez, telefono=987654321, email=analopez@example.com}, parentesco=Hermana}
ContactoEmpresarial{persona=Persona{nombre=Carlos, apellido=Garcia, telefono=456789123, email=cargarcia@example.com}, empresa=TechCorp, puesto=Ingeniero}
Evento{nombre=Reunion de amigos, fecha=2024-05-21, lugar=Casa de Juan}
EventoConferencia{nombre=Conferencia de Tecnolog�a, fecha=2024-06-15, lugar=Centro de Convenciones, orador=Dr. Smith}

Contactos en la agenda:
Contacto{persona=Persona{nombre=Juan, apellido=Perez, telefono=123456789, email=juanperez@example.com}}
ContactoFamiliar{persona=Persona{nombre=Ana, apellido=Lopez, telefono=987654321, email=analopez@example.com}, parentesco=Hermana}
ContactoEmpresarial{persona=Persona{nombre=Carlos, apellido=Garcia, telefono=456789123, email=cargarcia@example.com}, empresa=TechCorp, puesto=Ingeniero}

Eventos en la agenda:
Evento{nombre=Reunion de amigos, fecha=2024-05-21, lugar=Casa de Juan}
EventoConferencia{nombre=Conferencia de Tecnolog�a, fecha=2024-06-15, lugar=Centro de Convenciones, orador=Dr. Smith}
BUILD SUCCESSFUL (total time: 0 seconds)

*/