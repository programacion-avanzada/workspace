# StreetNumbers
Este proyecto me permite obtener el resultado al sumar las distintas posiciones mientras avanza a su lado izquierdo  o su lado derecho, yendo hasta el final y regresando.

## TARJETAS-CRC


| StreetNumbers | |
| ------------- | ------------- |
| Interfaz que permite probar distintas  estrategias.  | StreetNumbersStrategy  |
| Contenido de la celda  | Contenido de la celda  |


| StreetNumbersStrategy | |
| ------------- | ------------- |
| Proporciona el cálculo al recorrer de izquierda a derecha obteniendo la sumatoria de las mismas a medida que incrementa la posición.
Tiempo de ejecución elevado.  | Estrategia1  |
| Proporciona el cálculo al recorrer de izquierda a derecha según el teorema de sumas consecutivas a medida que incrementa la posición. 
Tiempo de ejecución medio. | Estrategia2 |
| Proporciona el resultado al realizar el cálculo con la posición deseada.
Tiempo de ejecución óptimo. | Estrategia3 |


## Complejidad Computacional

Estrategia N° 1:
O(N * (posición + N))

Estrategia N°2:
O(N)

Estrategia N° 3:
O(1)

Al evaluar las distintas complejidades computacionales que tienen las distintas estrategias se puede comprobar que la Estrategia 1 tiene un complejidad del tipo O(N * (posición *N)) la cual hará que el algoritmo tenga un retardo mucho mayor al aplicado en las estrategias 2 y 3 las cuales tienen una complejidad computacional lineal y constante, respectivamente. En otras palabras, obtenemos el mismo resultado con distintos algoritmos.

## Ejemplo de ejecución:

```bash
Estrategia utilizada: Estrategia 1
Reporte de tiempo: 121303.51 ms
Resultados: 
	6,8
	35,49
	204,288
	1189,1681
	6930,9800
---------------------------------
Estrategia utilizada: Estrategia 2
Reporte de tiempo: 13218.06 ms
Resultados: 
	6,8
	35,49
	204,288
	1189,1681
	6930,9800
	256,131072
	7742,131528
	11707,132113
	19813,134033
	115619,134705
---------------------------------
Estrategia utilizada: Estrategia 3
Reporte de tiempo: 8.65 ms
Resultados: 
	6,8
	35,49
	204,288
	1189,1681
	6930,9800
	256,131072
	7742,131528
	11707,132113
	19813,134033
	25162,135816
---------------------------------
```
