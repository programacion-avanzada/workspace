# Lanzamiento de Aceitunas
Si bien puede resolverse de diversas formas, y en rigor con sólamente una era suficiente, por fines didácticos se decidió hacerlo de dos maneras diferentes.

## Diagrama de clases

![diagrama](diagrama.png)

## Estrategias
Se utilizó el patrón de diseño *Strategy* para plasmar las dos posibles estrategias a utilizar.

### Estrategia Cuadrática
Esta estrategia recorre todos los lanzamientos por cada nuevo lanzamiento que se desea incorporar. No es eficiente, pero la solución es simple de pensar.

### Estrategia Lineal
Esta estrategia recorre los lanzamientos una única vez, agregando su puntuación individual a un arreglo que se utiliza como "memoria", para luego propagar la puntuación y escoger el R2 más pequeño que maximiza el resultado del partido.
