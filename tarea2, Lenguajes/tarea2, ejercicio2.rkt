

;---------------------tarea2, ejercicio 2-------------------------

; Comprueba si `prefix` es un prefijo de `cadena`
(define (prefix? prefix cadena)
  (and (<= (string-length prefix) (string-length cadena))
       (string=? prefix (substring cadena 0 (string-length prefix)))))

; Determina si `subcadena` se encuentra en `cadena`
(define (string-contains? cadena subcadena)
  (let loop ((i 0))
    (cond ((>= i (string-length cadena)) #f)
          ((prefix? subcadena (substring cadena i)) #t)
          (else (loop (+ i 1))))))

; Filtra `lista_cadenas` para incluir solo aquellas que contienen `subcadena`
(define (sub_cadenas subcadena lista_cadenas)
  (filter (lambda (cadena) (string-contains? cadena subcadena)) lista_cadenas))



; Ejemplo de uso
(display (sub_cadenas "la" '("la casa" "el perro" "pintando la cerca"))) ; Debería devolver '("la casa" "pintando la cerca")
