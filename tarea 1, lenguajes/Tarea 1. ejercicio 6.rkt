(define (string-split str delim)
  ; Función auxiliar para dividir una cadena en una lista de subcadenas utilizando un delimitador
  (define (split-helper str delim acc)
    (if (string=? str "")
        (reverse acc)
        (let ((index (string-contains str delim)))
          (if (not index)
              (reverse (cons str acc))
              (split-helper (substring str (+ index (string-length delim))) delim (cons (substring str 0 index) acc))))))

  ; Función auxiliar para encontrar la posición de un delimitador en una cadena
  (define (string-contains str delim)
    (define (contains-helper str delim index)
      (if (>= index (string-length str))
          #f
          (if (string=? (substring str index (+ index (string-length delim))) delim)
              index
              (contains-helper str delim (+ index 1)))))
    (contains-helper str delim 0))

  (split-helper str delim '()))

(define (ordenar lista)
  ; Función auxiliar para ordenar la lista
  (if (null? lista)
      '() 
      (sort lista <))) ; Ordena la lista en orden ascendente

(define (marge lista1 lista2)
  ; Función para combinar y ordenar las listas
  (define lista1-ordenada (ordenar lista1))
  (define lista2-ordenada (ordenar lista2)) 
  
  ; Función auxiliar para fusionar las dos listas ordenadas
  (define (fusionar l1 l2)
    (cond
      ((null? l1) l2)
      ((null? l2) l1)
      ((< (car l1) (car l2)) ;; Si el primer elemento de la primera lista es menor
       (cons (car l1) (fusionar (cdr l1) l2))) 
      (else ;; Si el primer elemento de la segunda lista es menor o igual
       (cons (car l2) (fusionar l1 (cdr l2))))))
  
  (fusionar lista1-ordenada lista2-ordenada)) 


(display "Ingrese la primera lista (separada por espacios): ")
(define lista1 (map string->number (string-split (read-line) " ")))
(display "Ingrese la segunda lista (separada por espacios): ")
(define lista2 (map string->number (string-split (read-line) " ")))

(display "La lista fusionada y ordenada es: ")
(display (marge lista1 lista2))
(newline)
