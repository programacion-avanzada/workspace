# Conceptos básicos del lenguaje Java

## Documentación seguida

### Descripción general del problema/proyecto
En este problema veremos métodos de conceptos básicos del lenguaje y sus implementaciones. Para este caso se utilizó la clase `Punto`.

La clase `Punto` posee dos atributos `double` `x` e `y` que indican la posición del punto en un eje de coordenadas y la implementación de varios métodos que nos ayudaran a interactuar con los objetos de la clase.

Existe el constructor de la clase `Punto` el cual crea un punto a partir de dos coordenadas (atributos `x` e `y`) que recibe como parámetros.

En Java existe la clase `Object`, que es la clase madre de todas las clases que podemos crear. Esa clase tiene métodos ya definidos, los cuales las clases hijas pueden sobrescribir para modificar el comportamiento de los mismos. Para la sobreescritura de un método se usa la notación `@Override` antes de definir y desarrollar el método.

Los métodos de la clase `Object` que se implementan en este proyecto son: 
-   `toString()` 
-   `equals()`
-   `hashCode()`
-   `clone()`

Se adjunta documentación complementaria de todos los métodos descriptos y conceptos que pueden relacionarse con ellos en el apartado de “API de Java”.

Además, se implementa el método `mover()` que, a partir de un punto dado y las coordenadas de desplazamiento, genera un nuevo punto.

### Puntos de extensión
-   Se podría agregar un constructor que no reciba como parámetros `X` e `Y` y que cree el objeto con valores por defecto (0, 0).
-   Se podrían agregar los métodos de setX y setY para poder definir los valores de los atributos x e y.

### Ejemplos de uso
-   En el proyecto se encuentran realizados seis test diferentes (cada uno con ejemplos distintos) para poder probar los distintos métodos de la clase. 
-   Además, en el proyecto existen las clases `PuntosPorEjeX` y `PuntosPorEjeY`. Estas están definidas ya que hay un método que permite comparar la distancia entre dos puntos según su respectivo eje.

### API de Java

-   [Clase Object](https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html)
-   [Equals](https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html#equals(java.lang.Object))
-   [HashCode](https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html#hashCode())
-   [toString](https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html#toString())
-   [clone](https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html#clone())
-   [Comparable](https://docs.oracle.com/javase/10/docs/api/java/lang/Comparable.html)
-   [Comparator](https://docs.oracle.com/javase/10/docs/api/java/util/Comparator.html)

### Extensiones de Apache commons-lang

-   <https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/builder/ToStringBuilder.html>
-   <http://commons.apache.org/proper/commons-lang/javadocs/api-release/index.html>
