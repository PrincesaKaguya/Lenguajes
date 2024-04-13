%ejercicio 1
sub_conjunto([], _). % Caso base
sub_conjunto([X|Xs], Ys) :-
    member(X, Ys),
    sub_conjunto(Xs, Ys).

% Predicado member/2
member(X, [X|_]).
member(X, [_|Xs]) :- member(X, Xs).


%ejercicio 2

% Predicado append/3
append([], L, L).
append([H|T1], L2, [H|T3]) :-
    append(T1, L2, T3).
% Implementación de la función aplanar sin utilizar is_list/1
aplanar([], []).
aplanar([X|Xs], Flat) :-
    var(X), % Verifica si X es una variable
    !,
    aplanar(Xs, FlatXs),
    Flat = [X|FlatXs]. % Si X es una variable, se agrega a la lista aplanada
aplanar([X|Xs], Flat) :-
    nonvar(X), % Verifica si X no es una variable (término no instanciado)
    X = [_|_], % Verifica si X es una lista
    !,
    aplanar(X, FlatX),
    aplanar(Xs, FlatXs),
    append(FlatX, FlatXs, Flat).
aplanar([X|Xs], [X|FlatXs]) :-
    nonvar(X),
    aplanar(Xs, FlatXs). % Si X no es una lista, se mantiene en la lista aplanada


%ejercicio 3
% Predicado principal para calcular la distancia de Hamming entre dos cadenas
distanciaH(Cadena1, Cadena2, Distancia) :-
    atom_chars(Cadena1, Lista1),           % Convertir la primera cadena en una lista de caracteres
    atom_chars(Cadena2, Lista2),
    longitudMinima(Lista1, Lista2, LongMin),
    calcularDistancia(Lista1, Lista2, LongMin, 0, Distancia).

% Predicado para calcular la longitud mínima entre dos listas
longitudMinima([], _, 0).  % Si la primera lista está vacía, la longitud mínima es 0
longitudMinima(_, [], 0).  % Si la segunda lista está vacía, la longitud mínima es 0
longitudMinima([_ | Cola1], [_ | Cola2], LongMin) :-
    longitudMinima(Cola1, Cola2, LongMinCola), % Llamar recursivamente con las colas
    LongMin is LongMinCola + 1.              % Incrementar la longitud mínima

% Predicado para calcular la distancia de Hamming
calcularDistancia(_, _, 0, Distancia, Distancia).
calcularDistancia([Cabeza1 | Cola1], [Cabeza2 | Cola2], LongMin, DistanciaParcial, Distancia) :-
    Cabeza1 \= Cabeza2,
    NuevaDistancia is DistanciaParcial + 1,  % Incrementamos la distancia parcial
    NuevaLongMin is LongMin - 1,             % Decrementamos la longitud mínima
    calcularDistancia(Cola1, Cola2, NuevaLongMin, NuevaDistancia, Distancia). % Llamada recursiva
calcularDistancia([_ | Cola1], [_ | Cola2], LongMin, DistanciaParcial, Distancia) :-
    NuevaLongMin is LongMin - 1,
    calcularDistancia(Cola1, Cola2, NuevaLongMin, DistanciaParcial, Distancia). % Llamada recursiva


%ejercicio 4
% Hechos
plato(entradas, guacamole, 200).
plato(entradas, ensalada, 150).
plato(entradas, consome, 300).
plato(entradas, tostadas_caprese, 250).
plato(carne, filete_de_cerdo, 400).
plato(carne, pollo_al_horno, 280).
plato(carne, carne_en_salsa, 320).
plato(pescado, tilapia, 160).
plato(pescado, salmon, 300).
plato(pescado, trucha, 225).
plato(postre, flan, 200).
plato(postre, nueces_con_miel, 500).
plato(postre, naranja_confitada, 450).
plato(postre, flan_de_coco, 375).

% Regla para calcular el total de calorías de una lista de platos
calorias([], 0). % Caso base
calorias([Plato|Resto], TotalCalorias) :-
    plato(_, Plato, CaloriasPlato),
    calorias(Resto, TotalResto),
    TotalCalorias is CaloriasPlato + TotalResto.

% Regla para generar combinaciones de comidas que no superen un máximo X de calorías y no repitan ningún elemento en su composición
combinacion_de_comidas(Entrada, PlatoPrincipal, Postre, TotalCalorias, MaxCalorias) :-
    plato(entradas, Entrada, CaloriasEntrada),
    plato(_, PlatoPrincipal, CaloriasPlatoPrincipal),
    plato(postre, Postre, CaloriasPostre),
    TotalCalorias is CaloriasEntrada + CaloriasPlatoPrincipal + CaloriasPostre,
    TotalCalorias =< MaxCalorias.

% Regla final que consulta las primeras 5 combinaciones de comidas que cumplen con los criterios
consultar_combinaciones(MaxCalorias) :-
    findall((Entrada, PlatoPrincipal, Postre, TotalCalorias),
            combinacion_de_comidas(Entrada, PlatoPrincipal, Postre, TotalCalorias, MaxCalorias),
            Combinaciones),
    length(Combinaciones, NumeroCombinaciones),
    NumeroCombinaciones >= 5,
    imprimir_primeras_5(Combinaciones).

% Predicado para imprimir las primeras 5 combinaciones de comidas
imprimir_primeras_5(Combinaciones) :-
    imprimir_n(Combinaciones, 5).

% Predicado para imprimir los primeros N elementos de una lista
imprimir_n(_, 0) :- !.
imprimir_n([Combinacion|Resto], N) :-
    writeln(Combinacion),
    N1 is N - 1,
    imprimir_n(Resto, N1).
