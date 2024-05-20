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
        // Obtener la instancia única de Agenda (Singleton)
        Agenda agenda = Agenda.obtenerInstancia();

        // Crear fábrica
        FabricaAbstracta fabrica = new FabricaConcreta();

        // Crear personas
        Persona persona1 = new Persona("Juan", "Pérez", "123456789", "juan.perez@example.com");
        Persona persona2 = new Persona("Ana", "López", "987654321", "ana.lopez@example.com");
        Persona persona3 = new Persona("Carlos", "García", "456789123", "carlos.garcia@example.com");

        // Crear contactos usando la fábrica
        Contacto contacto1 = fabrica.crearContacto("simple", persona1, null, null);
        Contacto contacto2 = fabrica.crearContacto("familiar", persona2, "Hermana", null);
        Contacto contacto3 = fabrica.crearContacto("empresarial", persona3, "TechCorp", "Ingeniero");

        // Crear eventos usando la fábrica
        Evento evento1 = fabrica.crearEvento("simple", "Reunión de amigos", "2024-05-21", "Casa de Juan", null);
        Evento evento2 = fabrica.crearEvento("conferencia", "Conferencia de Tecnología", "2024-06-15", "Centro de Convenciones", "Dr. Smith");

        // Agregar contactos y eventos a la agenda
        agenda = agenda.agregarItem(contacto1);
        agenda = agenda.agregarItem(contacto2);
        agenda = agenda.agregarItem(contacto3);
        agenda = agenda.agregarItem(evento1);
        agenda = agenda.agregarItem(evento2);

        // Mostrar todos los ítems
        System.out.println("Todos los ítems en la agenda:");
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
