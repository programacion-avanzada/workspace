# Dijkstra

El algoritmo de Dijkstra es un algoritmo que nos permite hallar el camino minimo desde un nodo de origen a todos los demas nodos de un grafo, que esten conectados por aristas con peso.

## Explicacion del algoritmo

Debemos tener el nodo de origen desde donde se quiere calcular las distancias minimas

Creamos dos conjuntos: S y V-S, donde S contiene los nodos del grafo que ya hemos analizado y V-S contiene los que existen en el grafo pero aun no hemos analizado.

Se debe inicializar el vector distancias (distancias []) con valores teniendo a infinito, se recomienda: Double.MAX_VALUE

En un primer paso y al agregar a S el nodo origen, inicializamos el vector distancias (distancias []) con todos los costos de los nodos que tengan una arista directa al nodo origen.

Luego, y para los siguientes n pasos se realiza lo siguiente:
Mientras (V-S no este vacio)
  Analizaremos un nodo W perteneciente a V-S, tal que su costo en el vector distancias sea el minimo.
  Seleccionado ese nodo W, se quita del conjunto V-S y se agrega al conjunto S.
  Para cada arista "aux" que salga de W:
     Se selecciona el que tenga menor costo entre:
                                               El costo que ya hay en distancias[aux]
                                               El costo de ir desde W seleccionado al nodo analizado + el costo en distancias[aux]
                  Si el menor es aux, se actualiza tambien el vector de predecesores, de la siguiente manera: predecesores[aux] = w
                  Es decir, se indica que se ha visitado el nodo W para llegar al nodo aux

## Ejemplo
 Se dispone de un ejemplo realizado en main.App.java, el grafo cargado es el siguiente:
 ![image](https://user-images.githubusercontent.com/82003137/124372069-5a99d680-dc5e-11eb-8a87-ca6d42b006f6.png)
### Distancias
 Ejecutado el algoritmo de Dijkstra sabemos que los costos para llegar desde el nodo 0 a todos los demas son los siguientes:
 Distancia minima a nodo 1= 10
 Distancia minima a nodo 2= 50
 Distancia minima a nodo 3= 30
 Distancia minima a nodo 4= 60
 
 Y analizando el grafico, llegamos a la misma conclusion:
 ![image](https://user-images.githubusercontent.com/82003137/124372123-d3009780-dc5e-11eb-81c3-6cfef3169fdc.png)
 ![image](https://user-images.githubusercontent.com/82003137/124372151-0ba07100-dc5f-11eb-98fe-3fb65d9bf3d9.png)
 ![image](https://user-images.githubusercontent.com/82003137/124372158-1bb85080-dc5f-11eb-8505-b49c41450358.png)
 ![image](https://user-images.githubusercontent.com/82003137/124372175-3985b580-dc5f-11eb-923b-ab22234436ad.png)


### Caminos
 Con el vector de predecesores se puede reconstruir el camino utilizado para llegar al nodo con el costo minimo, utilizamos el metodo caminoHastaNodo que nos devuelve una lista ordenada con los nodos visitados para realizar el camino desde el nodo origen hasta el nodo destino
#### Camino hasta el nodo 4
 La lista devulta al invocar al metodo caminoHastaNodo(0,4) es la siguiente:
 0->3->2->4
 Y viendo nuevamente en el grafico vemos que recorriendo esos nodos en ese orden tenemos el costo minimo
 
 ![image](https://user-images.githubusercontent.com/82003137/124372255-eceeaa00-dc5f-11eb-874a-4acba08ca170.png)

 
