(define (eliminar_elemento elemento lista)
  ;; Función auxiliar para comparar y filtrar los elementos
  (define (comparar-y-filtrar elemento-elem lista)
    (if (equal? elemento-elem elemento) 
        '() ;; Si el elemento es igual al elemento a eliminar, lo omitimos
        elemento-elem)) ;; Sino, conservamos el elemento
  ;; Aplicamos la función comparar-y-filtrar a cada elemento de la lista utilizando map
  (map (lambda (elem) (comparar-y-filtrar elem lista)) lista))

;; Función para dividir una cadena en una lista de elementos
(define (string-to-list str)
  (string-split str " "))

;; Implementación de string-split
(define (string-split str delim)
  ;; Función auxiliar para dividir una cadena en una lista de subcadenas utilizando un delimitador
  (define (split-helper str delim acc)
    (if (string=? str "")
        (reverse acc)
        (let ((index (find-delimiter str delim)))
          (if (not index)
              (reverse (cons str acc))
              (split-helper (substring str (+ index (string-length delim))) delim (cons (substring str 0 index) acc))))))

  (split-helper str delim '()))

;; Función auxiliar para encontrar la posición de un delimitador en una cadena
(define (find-delimiter str delim)
  (define (find-delimiter-helper str delim index)
    (if (>= index (string-length str))
        #f
        (if (string=? (substring str index (+ index (string-length delim))) delim)
            index
            (find-delimiter-helper str delim (+ index 1)))))
  (find-delimiter-helper str delim 0))

;; Ejemplo de uso:
(display "Ingrese el elemento a eliminar: ")
(define elemento (read-line))
(display "Ingrese la lista (separada por espacios): ")
(define lista (string-to-list (read-line)))

;; Llamamos a la función eliminar_elemento con el elemento y la lista dada y mostramos el resultado
(display "La lista sin el elemento es: ")
(display (eliminar_elemento elemento lista))
(newline)









