# Complejidad computacional y métodos de ordenamiento

La finalidad de este proyecto es mostrar distintos métodos de ordenamiento para complementar la teoria con la practica.

## Contenido del proyecto

En este proyecto se puede encontrar la implementacion en codigo Java de distintos métodos de ordenamiento. En especial se encuentran 6 metodos que se pueden separar en 2 grupos:

### Elementales

*   Inserción
*   Selección
*   Burbujeo

### No elementales

*   Shell Sort
*   Quick Sort
*   Merge Sort

## Introducción

Habitualmente, un mismo problema puede tener numerosas soluciones que pueden variar más o menos según la cantidad y tipo de las entradas

Cuando seleccionamos un algoritmo para resolver un determinado problema es importante
determinar los recursos computacionales necesarios (tiempos de ejecución razonables y espacio de almacenamiento en memoria) en función del volumen de datos a procesar

La eficiencia de un algoritmo no puede medirse en unidades de tiempo, ya que esto obligaría a realizar medidas empíricas sobre una implementación concreta, un compilador concreto y una máquina concreta

## Tabla complejidad Big O

[![Tabla complejidad Big O](./TablaComplejidadBigO.PNG)](https://www.bigocheatsheet.com)

## Métodos de ordenamientos

Los algoritmos de ordenamiento permutan los elementos del conjunto de datos hasta conseguir dicho orden. Para ello se basan en dos operaciones básicas: la comparación y el intercambio

## Tipos de ordenamiento

### Ordenamineto interno

Ordenamiento de datos en Memoria Principal. (La lectura y grabación se hacen en registros)

### Ordenamiento externo

Ordenamiento de datos en Disco
 
## Tipos de Entrada de Datos

*   Entrada Ordenada = MEJOR CASO
*   Entrada Orden Inverso = PEOR CASO
*   Entrada Desordenada = CASO AL AZAR

A continuación se describira los distintos metodos de ordenamiento que se encuentran en el proyecto y sus complejidades computacionales

## Método burbuja

El **método burbuja** también conocido como intercambio directo es un método muy utilizado para ordenar una lista dentro de un arreglo. Su funcionamiento es muy intuitivo

*   Comparamos un elemento con el adyacente
*   Si el elemento es mayor, lo intercambiamos
*   Pasar al siguiente par de elementos hasta terminar la lista
*   Repasar de nuevo el mismo algoritmo en toda la lista n-1 veces

### Complejidad del método de la burbuja

El análisis de complejidad de este método de ordenamiento es el siguiente

c = (n-1) + (n-2) + ... + 2 + 1 = (n*(n-1))/2

En donde c es el número total de comparaciones por el método burbuja, y simplificando esa expresión tenemos que

c = (n2-n)/2

Cuál es el número de comparaciones necesarias para este ordenamiento, es decir que su complejidad en el peor de los casos es del orden O(n2)

## Método de selección

El **método de selección** es muy sencillo, este algoritmo consiste en ordenar el menor elemento de una lista en cada interacción, colocándolo en su posición dentro de la lista

El procedimiento para efectuar un ordenamiento con este algoritmo es el siguiente

*   Seleccionar el menor elemento en cada iteración de toda la lista
*   Colocarlo en su lugar intercambiando el elemento
*   Repetir el procedimiento con el resto de los elementos de la lista

### Complejidad del algoritmo de selección

El algoritmo de selección requiere acomodar un array utilizando el array original. Por lo tanto, requiere realizar el siguiente número de operaciones

c = (n-1) + (n-2) + ... + 2 + 1 = (n*(n-1))/2

Y por lo tanto el número de operaciones realizadas es del orden O(n2)

c = (n2-n)/2

## Método de inserción

El método de insercón es uno de los métodos de ordenamiento más semejantes a los utilizados en forma natural por el ser humano. Consiste en insertar elementos en forma ordenada en una lista directamente en el orden que le corresponde

Aunque ésta operación en forma humana podría consistir en una única operación, debido a nuestras capacidades cognitivas, para una computadora implica el uso de un algoritmo que consiste en tomar un elemento y colocarlo en un arreglo nuevo en la posición que le corresponde

### Complejidad del algoritmo de inserción

Cuando los datos se encuentran en forma ordenada, tenemos el caso óptimo, en donde solo se efectúan n comparaciones, es decir una complejidad Θ(n)

En el peor caso, los datos están ordenados en orden inverso. En éste caso tenemos las mismas operaciones que en el algoritmo de selección

c = (n-1) + (n-2) + ... + 2 + 1 = (n*(n-1))/2

Así en el peor caso tenemos de complejidad: O(n2)

## Quicksort

El algoritmo de quickSort es uno de los métodos de ordenamiento más eficaces en cuanto complejidad. Lo ideal es es que el pivote no sea uno de los extremos y consta de una serie de pasos que ordena una lista utilizando el siguiente procedimiento

1.  Selecciona un elemento p “pivote” al azar.
2.  Mientras los indices i y j no se crucen
3.  Se busca por la izquierda el primer elemento mayor al pivote a través i incrementandolo
4.  Se busca por la derecha el primer elemento menor al pivote a través j decrementandolo
5.  Una vez encontrado los elementos mayor y menor, se intercambian las posiciones de i y j
6.  Incrementa el i, y se decrementa el j
7.  Se repite desde el paso 2
8.  Cuando se cruzan i y j entonces se intercambia i con p
9.  Dividir el arreglo en dos subarreglos, en donde p es un nuevo pivote y el subarreglo izquierdo contiene elementos menores o iguales que p, mientras que el subarreglo derecho contiene valores mayores que p
10. Realizar Quicksort con el arreglo izquierdo sin incluir el elemento p
11. Realizar Quicksort con el arreglo derecho sin incluir el elemento p

### Complejidad de Quicksort

La complejidad del algoritmo Quicksort varía en tres casos diferentes

*   Mejor caso: Sucede cuando en cada pasada se selecciona el elemento central del conjunto. La complejidad en este caso es O(log n)
*   Caso promedio:Es el tiempo promedio de ejecución,el cual es c=(n-1)*log n,es decir:O(n*log n)
*   Peor caso: Sucede cuando el arreglo está arreglado o en orden inverso, su complejidad es c = (n2+n)/2-1, y por lo tanto es del orden O(n2)

## Shell Sort

El algoritmo Shell es una mejora de la ordenación por inserción, donde se van comparando elementos distantes, al tiempo que se los intercambian si corresponde. A medida que se aumentan los pasos, el tamaño de los saltos disminuye; por esto mismo, es útil tanto como si los datos desordenados se encuentran cercanos, o lejanos

Es bastante adecuado para ordenar listas de tamaño moderado, debido a que su velocidad es aceptable y su codificación es bastante sencilla. Su velocidad depende de la secuencia de valores con los cuales trabaja, ordenándolos

### Complejidad del ordenamiento Shell

*   Mejor caso: n log n
*   Caso promedio: n (log n)^2
*   Peor caso: n (log n)^2

## Merge Sort

Este ordenamiento consiste en dividir el problema a resolver en subproblemas del mismo tipo que a su vez se dividirán, mientras no sean suficientemente pequeños o triviales. MergeSort es un ordenamiento estable, paraleliza mejor, y es más eficiente manejando medios secuenciales de acceso lento. MergeSort es a menudo la mejor opción para ordenar una lista enlazada

**Pasos:**

1.  Si la longitud de la lista es 0 ó 1, entonces ya está ordenada. En otro caso
   a.   Dividir la lista desordenada en dos sublistas de aproximadamente la mitad del tamaño
   b.   Ordenar cada sublista recursivamente aplicando el ordenamiento por mezcla
   c.   Mezclar las dos sublistas en una sola lista ordenada

El ordenamiento por mezcla incorpora dos ideas principales para mejorar su tiempo de ejecución

1.  Una lista pequeña necesitará menos pasos para ordenarse que una lista grande
2.  Se necesitan menos pasos para construir una lista ordenada a partir de dos listas también ordenadas, que a partir de dos listas desordenadas. Por ejemplo, sólo será necesario entrelazar cada lista una vez que están ordenadas

### Complejidad del Merge

A tener en cuenta que, este algoritmo presenta n log n tanto en todos los casos. Esto se debe a que el tiempo que insume el algoritmo no depende de la disposición inicial de los elementos del vector

*   Mejor caso: n log(n)
*   Caso Promedio: n log(n)
*   Peor caso: n log(n)

# Conclusiones

Para redondear todos los contenidos vistos queda entonces que

# Definición de complejidad en métodos de ordenamiento

La complejidad en los métodos de ordenamiento significa en términos simples, la cantidad de operaciones que requiere un algoritmo para completarse

Aunque en ejemplos sencillos y cortos no haya gran diferencia entre una complejidad de orden O(n) y otra de orden O(n2), a gran escala el cambio en el número de operaciones es significativo en cuanto a tiempos de ejecución y coste computacional

# Ejemplo de complejidad en los métodos de ordenamiento

Si un algoritmo requiere de 5 iteraciones (valor de n) para completarse con los métodos de ordenamiento, podemos ver que el número de operaciones no cambia mucho

*   O(n) ≈ 5 operaciones
*   O(n2) ≈ 25 operaciones
*   O(n3) ≈ 125 operaciones

Pero si el algoritmo requiere 450 operaciones para completarse, el valor del orden sí importa, véase el siguiente ejemplo

*   O(n) ≈ 450 operaciones
*   O(n2) ≈ 202500 operaciones
*   O(n3) ≈ 191,125,000 operaciones

Lo cual significa que el número de operaciones cambia de solo 450 operaciones a ¡casi 200 millones! en solo pasar del lineal al cúbico

Ésta diferencia podría significar de un cálculo que se podría hacer en pocos segundos vs otro cálculo que requiere varios meses en completarse, aún teniendo el mismo resultado

Por esa razón, es bueno analizar la complejidad de los métodos de ordenamiento, para reducir costos computacionales y optimizar los algoritmos

# Paginas interesantes para visitar

*   [Metodos de ordenamiento visuales](http://sorting.at)
*   [Tabla con las distintas complejidades de metodos de ordenamiento](https://www.bigocheatsheet.com)
