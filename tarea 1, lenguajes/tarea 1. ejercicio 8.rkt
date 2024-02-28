(define (sub-conjunto? conjunto1 conjunto2)
  ;; Función auxiliar para verificar si todos los elementos de conjunto1 están en conjunto2
  (define (todos-en-conjunto? conjunto1 conjunto2)
    (cond
      ((null? conjunto1) #t) ;; Si conjunto1 está vacío, todos los elementos están en conjunto2
      ((not (member (car conjunto1) conjunto2)) #f) ;; Si el primer elemento de conjunto1 no está en conjunto2, no son todos los elementos
     (else (todos-en-conjunto? (cdr conjunto1) conjunto2)))) ;; Verificar el resto de los elementos
  
  (and (todos-en-conjunto? conjunto1 conjunto2) ;; Verificar si todos los elementos de conjunto1 están en conjunto2
       (not (equal? conjunto1 conjunto2)))) ;; Verificar si conjunto1 es diferente de conjunto2


