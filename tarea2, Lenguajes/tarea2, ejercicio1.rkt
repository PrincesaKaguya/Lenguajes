
;;código de clase 
(define
  listaProductos
  '(("arroz" 8 1800)
    ("frijoles" 5 1200)
    ("azúcar" 6 1100)
    ("cafe" 2 2800)
    ("leche" 9 1200)))

(define (agregarProducto Lista nombre cantidad precio)
  (cond ((null? Lista)
         (list (list nombre cantidad precio)))
        ((equal? nombre (caar Lista))
          (cons (list
                 (caar Lista)
                 (+(cadar Lista) cantidad)
                 precio)
                (cdr Lista)))
        (else
         (cons (car Lista) (agregarProducto
                            (cdr Lista)
                            nombre
                            cantidad
                            precio)))))


(define (venderProducto1 Lista nombre cantidad)
  (cond ((null? Lista)
         (display "Lista vacia")
          '())
        ((equal? nombre (caar Lista))
          (cons (list
                 (caar Lista)
                 (-(list-ref (car Lista) 1) cantidad)
                 (list-ref (car Lista) 2))
                (cdr Lista)))
        (else
          (cons (car Lista)
                (venderProducto (cdr Lista) nombre cantidad))
         )))


(define (existenciasMinimas Lista cantidad)
  (filter (lambda (x) (<= (cadr x) cantidad))
            Lista))


;;-----------------------------Tarea2, ejercicio 1--------------


(define (crearFactura productos)
  productos)

(define (calcularImpuestoTotal factura umbral)
  (define (calcularImpuestoProducto producto)
    (if (> (caddr producto) umbral)
        (* 0.13 (caddr producto))
        0))
  (apply + (map calcularImpuestoProducto factura)))

(define (calcularMontoTotal factura)
  (apply + (map (lambda (producto) (* (cadr producto) (caddr producto))) factura)))


(define umbralImpuesto 120)


(define (imprimirFactura factura)
  (for-each (lambda (producto)
              (display "(")
              (display (car producto))
              (display " ")
              (display (cadr producto))
              (display " ")
              (display (* (cadr producto) (caddr producto))) ; Total = cantidad * precio
              (display ") "))
            factura))



;;-----------------------PRUEBAS DE LAS FUNCIONES------------------------------------ 

;;agregar producto
;(define listaProductosActualizada (agregarProducto listaProductos "manzana" 15 500))
;(define listaProductosActualizada (agregarProducto listaProductos "boquitas" 20 2100))
;listaProductosActualizada


;------------------------------------------------------------------------------------
;;vender producto
;(define productosDespuesDeVenta (venderProducto1 listaProductos "arroz" 5))
;productosDespuesDeVenta


;------------------------------------------------------------------------------------
;filtrar productos
;(define productosConExistenciasMinimas (existenciasMinimas listaProductos 4))
;productosConExistenciasMinimas         


;------------------------------------------------------------------------------------

;;Ejercicio1, facturas quemadas 

(define factura1
  '((boquitas 1 2100)
    (manzana 5 500)
    (cafe 1 2800)))

(define factura2
  '((arroz 3 1800)
    (leche 1 1200)
    (platanos 6 320)))

(define factura3
  '((roxy 5 100)
    (paleta 3 200)
    (mani 8 150)))


;;-----------------------Ejercicio1, Ejemplos de uso-------------------:
;1
(display "Factura 1: ")
(imprimirFactura factura1)
(display "Impuesto total de la factura 1: ")
(display (calcularImpuestoTotal factura1 umbralImpuesto))
(newline)
(display "Monto total de la factura 1 sin impuesto: ")
(display (calcularMontoTotal factura1))
(newline)
(newline)

;2
(display "Factura 2: ")
(imprimirFactura factura2)
(display "Impuesto total de la factura 2: ")
(display (calcularImpuestoTotal factura2 umbralImpuesto))
(newline)
(display "Monto total de la factura 2 sin impuesto: ")
(display (calcularMontoTotal factura2))
(newline)
(newline)

;3
(display "Factura 3: ")
(imprimirFactura factura3)
(display "Impuesto total de la factura 3: ")
(display (calcularImpuestoTotal factura3 umbralImpuesto))
(newline)
(display "Monto total de la factura 3 sin impuesto: ")
(display (calcularMontoTotal factura3))
(newline)


