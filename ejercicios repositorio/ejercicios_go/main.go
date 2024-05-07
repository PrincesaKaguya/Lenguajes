package main

import (
	"fmt"
	"regexp"
	"sort"
	"strings"
)

type infoCliente struct {
	nombre string
	correo string
	edad   int32
}

type listaClientes []infoCliente

func (lc *listaClientes) agregarCliente(nombre, correo string, edad int32) {
	*lc = append(*lc, infoCliente{nombre: nombre, correo: correo, edad: edad})
}

func filter[T any](slice []T, predicate func(T) bool) []T {
	resultSlice := make([]T, 0)

	for _, item := range slice {
		if predicate(item) {
			resultSlice = append(resultSlice, item)
		}
	}

	return resultSlice
}

func listaClientes_ApellidoEnCorreo(clientes listaClientes, apellido string) listaClientes {
	return listaClientes(filter([]infoCliente(clientes), func(c infoCliente) bool {
		return strings.Contains(c.correo, apellido)
	}))
}

func cantidadCorreosCostaRica(clientes listaClientes) int {
	correoCRCantidad := len(filter(clientes, func(c infoCliente) bool {
		return strings.HasSuffix(c.correo, ".cr")
	}))
	return correoCRCantidad
}

func clientesSugerenciasCorreos(clientes *listaClientes) listaClientes {
	// Expresión regular para verificar si el correo contiene el nombre
	re := regexp.MustCompile(`(?i)\b` + (*clientes)[0].nombre + `\b`)

	// Filtrar los clientes cuyos correos no contienen el nombre
	clientesSinNombre := filter(*clientes, func(c infoCliente) bool {
		return !re.MatchString(c.correo)
	})

	// Lista para almacenar los clientes modificados
	nuevaLista := make(listaClientes, len(*clientes))

	for i, cliente := range *clientes {
		// Si el cliente está en la lista de clientes sin nombre, se sugiere un nuevo correo
		if contiene(clientesSinNombre, &cliente) {
			// Obtener el dominio del correo electrónico original
			dominioOriginal := strings.Split(cliente.correo, "@")[1]
			// Se sugiere un nuevo correo con el nombre del cliente usando guiones bajos
			nuevoCorreo := strings.Replace(cliente.nombre, " ", "_", -1) + "@" + dominioOriginal
			nuevaLista[i] = infoCliente{nombre: cliente.nombre, correo: nuevoCorreo, edad: cliente.edad}
		} else {
			// Si el cliente ya tiene un correo válido, se mantiene sin cambios
			nuevaLista[i] = cliente
		}
	}

	return nuevaLista
}

// Función auxiliar para verificar si un cliente está en la lista de clientes sin nombre
func contiene(clientesSinNombre []infoCliente, cliente *infoCliente) bool {
	for _, c := range clientesSinNombre {
		if c.nombre == cliente.nombre && c.correo == cliente.correo && c.edad == cliente.edad {
			return true
		}
	}
	return false
}

func correosOrdenadosAlfabeticos(clientes listaClientes) []string {
	// Lista para almacenar todos los correos
	correos := make([]string, len(clientes))

	// Extraer todos los correos de los clientes
	for i, cliente := range clientes {
		correos[i] = cliente.correo
	}

	// Ordenar los correos alfabéticamente
	sort.Strings(correos)

	return correos
}

func agregarClientes(lc *listaClientes) {
	lc.agregarCliente("Oscar Viquez", "oviquez@tec.ac.cr", 44)
	lc.agregarCliente("Pedro Perez", "elsegundo@gmail.com", 30)
	lc.agregarCliente("Maria Lopez", "mlopez@hotmail.com", 18)
	lc.agregarCliente("Juan Rodriguez", "jrodriguez@gmail.com", 25)
	lc.agregarCliente("Luisa Gonzalez", "muyseguro@tec.ac.cr", 67)
	lc.agregarCliente("Marco Rojas", "loquesea@hotmail.com", 47)
	lc.agregarCliente("Marta Saborio", "msaborio@gmail.com", 33)
	lc.agregarCliente("Camila Segura", "csegura@ice.co.cr", 19)
	lc.agregarCliente("Fernando Rojas", "frojas@estado.gov", 27)
	lc.agregarCliente("Rosa Ramirez", "risuenna@gmail.com", 50)
}

func main() {
	var listaClientes listaClientes

	// Llamar a la función para agregar clientes
	agregarClientes(&listaClientes)

	// Mostrar la lista de clientes
	fmt.Println("Lista de clientes:")
	for _, cliente := range listaClientes {
		fmt.Printf("Nombre: %s, Correo: %s, Edad: %d\n", cliente.nombre, cliente.correo, cliente.edad)
	}

	// Filtrar la lista de clientes por apellido en correo
	apellido := "viquez"
	resultado := listaClientes_ApellidoEnCorreo(listaClientes, apellido)

	fmt.Printf("\nClientes cuyos correos contienen '%s':\n", apellido)
	for _, cliente := range resultado {
		fmt.Printf("Nombre: %s, Correo: %s, Edad: %d\n", cliente.nombre, cliente.correo, cliente.edad)
	}

	// Calcular la cantidad de correos de Costa Rica
	cantidad := cantidadCorreosCostaRica(listaClientes)
	fmt.Printf("\nCantidad de correos de Costa Rica: %d\n", cantidad)

	// Mostrar la lista de clientes original
	fmt.Println("Lista de clientes original:")
	for _, cliente := range listaClientes {
		fmt.Printf("Nombre: %s, Correo: %s, Edad: %d\n", cliente.nombre, cliente.correo, cliente.edad)
	}

	// Obtener la nueva lista de clientes con sugerencias de correos
	nuevaLista := clientesSugerenciasCorreos(&listaClientes)

	// Mostrar la lista de clientes con correos sugeridos
	fmt.Println("\nLista de clientes con correos sugeridos:")
	for _, cliente := range nuevaLista {
		fmt.Printf("Nombre: %s, Correo: %s, Edad: %d\n", cliente.nombre, cliente.correo, cliente.edad)
	}

	// Obtener una lista de correos ordenados alfabéticamente
	correosOrdenados := correosOrdenadosAlfabeticos(listaClientes)

	// Mostrar la lista de correos ordenados
	fmt.Println("\nLista de correos ordenados alfabéticamente:")
	for _, correo := range correosOrdenados {
		fmt.Println(correo)
	}

}
