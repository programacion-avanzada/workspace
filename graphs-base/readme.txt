[Readme]
¿Qué es un grafo?

Un grafo es un conjunto de elementos llamados nodos y conexiones entre esos elementos, llamadas aristas.

  [Grado de un nodo]
  El grado de un nodo consta de la cantidad de aristas que se encuentran a él.

  [Matriz de adyacencia]
  Una matriz de adyacencia es una matriz en donde cada fila representa a un nodo del grafo y las columnas representan un valor o peso de la arista que conecta hacia otro nodo.

  [Lista de adyacencia]
  Una lista de adyacencia es una lista enlazada entre todos los nodos adyacentes. En ella, las

  [Algoritmos aplicables]
  * Dijkstra
    Es un algoritmo capaz de conseguir el camino más corto de un nodo a todos los restantes en un grafo.
  * Prim
    Es un algoritmo que permite encontrar un árbol recubridor mínimo (MST), o sea, permite encontrar un arbol con el menor costo de distancia entre nodos.
  * Kruskal
    Es un algoritmo que permite encontrar un árbol recubridor mínimo (MST), o sea, permite encontrar un arbol con el menor costo de distancia entre nodos.

  * Floyd

  [Recorrido de grafos]
  Los recorridos de grafos se realizan para encontrar los nodos que se pueden alcanzar desde determinado nodo,
  para encontrar el mejor camino de un nodo a otro y también para averiguar si un grafo tiene ciclos.
  Entre los recorridos de grafos conocidos se encuentran los siguientes:
  * DFS (Depth First Search)
    Es un algoritmo que permite recorrer los nodos expandiendo cada uno de los mismos que vaya localizando. Utiliza la estructura de pila.
  * BFS (Breadth First Search)
    Es un algoritmo que puede calcular la distancia de un nodo del grafo a todos los demas. Utiliza la estructura cola.

  [Coloreo]
  El coloreo es asignar un color a cada nodo del grafo, evitando tener nodos adyacentes con el mismo color.
    [Número cromático]
    El número cromático es la cantidad mínima de colores que un grafo necesita para ser coloreado.
    [Orden]
    * Matula
    Los nodos se irán pintando en orden creciente por su grado.
    * Welsh-powell
    Los nodos se irán pintando en orden descendiente por su grado.
    * Al azar
    Se van eligiendo nodos al azar y pintandolos de acuerdo a la adyacencia con los nodos ya pintados.
