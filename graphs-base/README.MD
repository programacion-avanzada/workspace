# Grafos

## ¿Qué es un grafo?

Un grafo es un conjunto de elementos llamados nodos y conexiones entre esos elementos, llamadas aristas.

**Grado de un nodo**
El grado de un nodo consta de la cantidad de aristas que se encuentran a él.

## Matriz de adyacencia
Una matriz de adyacencia es una matriz en donde cada fila representa a un nodo salida una determinada arista y las columnas representan un nodo llegada de la arista, en la posicion (i,j) de dicha matriz, se coloca el costo de la arista.
Es decir, si en la posicion 1,5 de una matriz de 6x6 tenemos un valor=30, podemos decir que existe una arista desde el nodo 1 al nodo 5, con un costo de 30.

## Lista de adyacencia
Una lista de adyacencia es una lista que tiene todos los nodos del grafo. En index de la lista, se crea una nueva lista o una nueva cola de prioridad (para mejorar la complejidad computacional) en la que se agrega cada arista con los siguientes dos parametros: nodoDestino, costoArista.

## Algoritmos aplicables
* **Dijkstra**

* **Prim**

* **Kruskal**

* **Floyd**

## Recorrido de grafos
Los recorridos de grafos se realizan para encontrar los nodos que se pueden alcanzar desde determinado nodo,
para encontrar el mejor camino de un nodo a otro y también para averiguar si un grafo tiene ciclos.
Entre los recorridos de grafos conocidos se encuentran los siguientes:
### DFS (Depth First Search)
Es un algoritmo que permite recorrer los nodos expandiendo cada uno de los mismos que vaya localizando. Utiliza la estructura de pila.
### BFS (Breadth First Search)
Es un algoritmo que puede calcular la distancia de un nodo del grafo a todos los demas. Utiliza la estructura cola.

## Coloreo
El coloreo es asignar un color a cada nodo del grafo, evitando tener nodos adyacentes con el mismo color.
### Número cromático
El número cromático es la cantidad mínima de colores que un grafo necesita para ser coloreado.
### Orden
* **Matula**
Los nodos se irán pintando en orden creciente por su grado.
* **Welsh-powell**
Los nodos se irán pintando en orden descendiente por su grado.
* **Al azar**
Se van eligiendo nodos al azar y pintandolos de acuerdo a la adyacencia con los nodos ya pintados.

# Acerca del proyecto
El siguiente proyecto es una base para realizar las diferentes implementaciones de grafos y sus algoritmos aplicables. El mismo cuenta con una clase abstracta de grafo para realizar las implementaciones en lista de adyacencia y matriz de adyacencia y tiene interfaces de importación y exportación de los mismos.

![UML de la base para implementar](https://raw.githubusercontent.com/daniel-dv/workspace/master/graphs-base/uml.png)
