package main

import "fmt"

type producto struct {
	nombre   string
	cantidad int
	precio   int
}

type listaProductos []producto

var lProductos listaProductos

const existenciaMinima int = 10 //la existencia mínima es el número mínimo debajo de el cual se deben tomar eventuales decisiones

func (l *listaProductos) agregarProducto(nombre string, cantidad int, precio int) {
	// Buscar si el producto ya existe
	if _, idx := l.buscarProducto(nombre); idx != -1 {
		// Si existe, incrementar la cantidad
		(*l)[idx].cantidad += cantidad
		// Actualizar el precio si es diferente
		if (*l)[idx].precio != precio {
			(*l)[idx].precio = precio
		}
	} else {
		// Si no existe, agregar el producto
		*l = append(*l, producto{nombre: nombre, cantidad: cantidad, precio: precio})
	}
}

// Hacer una función adicional que reciba una cantidad potencialmente infinita de productos previamente creados y los agregue a la lista
func (l *listaProductos) agregarProductos(productos ...producto) {
	for _, p := range productos {
		l.agregarProducto(p.nombre, p.cantidad, p.precio)
	}
}

func (l *listaProductos) buscarProducto(nombre string) (*producto, int) {
	for i, p := range *l {
		if p.nombre == nombre {
			return &p, i // Producto encontrado, retornar el puntero al producto y su índice
		}
	}
	return nil, -1 // Producto no encontrado
}

// Función para vender un producto
func (l *listaProductos) venderProducto(nombre string, cant int) {
	prod, idx := l.buscarProducto(nombre)
	if idx != -1 {
		// Si el producto existe
		prod.cantidad -= cant
		if prod.cantidad <= 0 {
			// Si la cantidad se agota, eliminar el producto de la lista
			*l = append((*l)[:idx], (*l)[idx+1:]...)
			fmt.Printf("Producto '%s' agotado. Eliminado de la lista.\n", nombre)
		}
	} else {
		fmt.Printf("El producto '%s' no se encuentra en la lista.\n", nombre)
	}
}

// Función para modificar el precio de un producto
func modificarPrecioProducto(nombre string, nuevoPrecio int) {
	if prod, idx := lProductos.buscarProducto(nombre); idx != -1 {
		prod.precio = nuevoPrecio
		fmt.Printf("Precio del producto '%s' modificado a %d.\n", nombre, nuevoPrecio)
	} else {
		fmt.Printf("El producto '%s' no se encuentra en la lista.\n", nombre)
	}
}

// Función para listar productos con existencia mínima
func (l listaProductos) listarProductosMinimos() listaProductos {
	var productosMinimos listaProductos
	for _, p := range l {
		if p.cantidad <= existenciaMinima {
			productosMinimos = append(productosMinimos, p)
		}
	}
	return productosMinimos
}

func llenarDatos() {
	lProductos.agregarProductos(
		producto{nombre: "arroz", cantidad: 15, precio: 2500},
		producto{nombre: "frijoles", cantidad: 4, precio: 2000},
		producto{nombre: "leche", cantidad: 8, precio: 1200},
		producto{nombre: "café", cantidad: 12, precio: 4500},
		producto{nombre: "café", cantidad: 1, precio: 4500},
	)
}

func main() {
	llenarDatos()
	fmt.Println("Lista de productos:")
	fmt.Println(lProductos)

	// Vender productos
	lProductos.venderProducto("arroz", 10)
	lProductos.venderProducto("frijoles", 2)

	fmt.Println("\nLista de productos después de la venta:")
	fmt.Println(lProductos)

	// Listar productos con existencia mínima
	pminimos := lProductos.listarProductosMinimos()
	fmt.Println("\nProductos con existencia mínima:")
	for _, p := range pminimos {
		fmt.Println(p)
	}

	// Modificar precio de un producto
	modificarPrecioProducto("arroz", 3000)

	fmt.Println("\nLista de productos después de modificar el precio de arroz:")
	fmt.Println(lProductos)
}
