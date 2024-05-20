/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1_poo_lenguajes;

/**
 *
 * @author zumba
 */
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

/**
 * Clase Agenda que utiliza el patrón Singleton para asegurar que solo
 * una instancia de la agenda existe en toda la aplicación.
 */
public class Agenda {
    private final List<Object> items;

    // Singleton: instancia única
    private static Agenda instancia;

    // Constructor privado para evitar instanciación
    private Agenda() {
        this.items = Collections.unmodifiableList(new ArrayList<>());
    }

    // Método estático para obtener la instancia única (Lazy Singleton)
    public static Agenda obtenerInstancia() {
        if (instancia == null) {
            instancia = new Agenda();
        }
        return instancia;
    }

    private Agenda(List<Object> items) {
        this.items = Collections.unmodifiableList(items);
    }

    public Agenda agregarItem(Object item) {
        List<Object> newItems = new ArrayList<>(this.items);
        newItems.add(item);
        return new Agenda(newItems);
    }

    public Agenda eliminarItem(Object item) {
        List<Object> newItems = new ArrayList<>(this.items);
        newItems.remove(item);
        return new Agenda(newItems);
    }

    public Agenda modificarItem(Object oldItem, Object newItem) {
        List<Object> newItems = new ArrayList<>(this.items);
        int index = newItems.indexOf(oldItem);
        if (index != -1) {
            newItems.set(index, newItem);
        }
        return new Agenda(newItems);
    }

    public void mostrarItems() {
        items.forEach(System.out::println);
    }

    public List<Contacto> filtrarContactos() {
        return items.stream()
                .filter(item -> item instanceof Contacto)
                .map(item -> (Contacto) item)
                .collect(Collectors.toList());
    }

    public List<Evento> filtrarEventos() {
        return items.stream()
                .filter(item -> item instanceof Evento)
                .map(item -> (Evento) item)
                .collect(Collectors.toList());
    }
}




