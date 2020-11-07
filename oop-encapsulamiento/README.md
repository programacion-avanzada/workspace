## Introducción

¿En qué consiste el encapsulamiento?

Este concepto consiste en la ocultación del estado o de los datos miembro de un objeto, de forma que sólo es posible realizar operaciones con los mismos mediante los métodos definidos para dicho objeto.
Es decir, es la característica de no acceder o modificar los valores de los atributos directamente y utilizar métodos para ello. Se busca trabajar con los atributos de un objeto mediante operaciones permitidas, impidiendo realizar aquellas que no son necesarias o que su realización sería errónea para el problema de negocio a desarrollar. 

¿Cuáles son sus ventajas?

1. Ocultar los datos: el usuario no tendrá idea de la implementación interna de la clase, ya no verá cómo la clase está almacenando valores en las variables. Solo sabe que estamos pasando los valores a un método de establecimiento y las variables se están inicializando con ese valor.

2. Mayor flexibilidad: podemos hacer que las variables de la clase sean de solo lectura o de solo escritura según nuestros requisitos. Si deseamos que las variables sean de solo lectura, entonces tenemos que omitir los métodos de establecimiento como setName (), setAge (), etc. del programa anterior o si deseamos hacer que las variables sean de solo escritura, entonces tenemos que omitir los métodos get como getName (), getAge (), etc. del programa anterior.

3. Reutilización: la encapsulación también mejora la reutilización y es fácil de cambiar con nuevos requisitos.
Probar el código es fácil: el código encapsulado es fácil de probar para las pruebas unitarias.


## Aplicación practica

`Contador de Ganado`

Luis tiene un campo a las afueras de Buenos Aires y quiere contar sus cabezas de ganado para poder saber cuántas cabezas de ganado entran en cada camión. Por eso se compró un contador de ganado, que le permitirá contar las vacas mientras ingresan. Al llenarse un camión, tiene que reiniciarlo para contar cuantas entrarán en el próximo camión. 
Se utilizará encapsulamiento para ver el comportamiento del contador.
 
Clase `Contador`

Se creará la clase `Contador`, con el atributo entero contador, que contará con 3 métodos:

contar (): aumentará el valor del atributo en uno.

reiniciar (): pondrá el valor del atributo en cero.

mostrar (): mostrará el valor del atributo.


## Conclusión

De esta manera, se puede ver que, a través del encapsulamiento, podremos definir aquellas operaciones que se quieren realizar con el atributo “contador”, dejando de lado aquellas innecesarias y/o no permitidas. Otras clases podrán manipular este atributo únicamente utilizando los métodos definidos en la clase `Contador`. 


Si por ejemplo una clase externa quisiera asignarle un valor puntual al contador, no tendrá forma de hacerlo. Esto nos asegura que las clases externas harán solo lo que los métodos definidos les permitan hacer. 


## Ejemplo de encapsulamiento

En este ejemplo vemos aplicado el encapsulamiento al concepto de un elemento simple, conocido como [contador de ganado](https://en.wikipedia.org/wiki/Tally_counter).

El contador posee tres métodos, los cuales necesitan de un único atributo para funcionar correctamente.


## Para practicar

1. ¿Cómo puedo lograr que el Contador pase el valor de `Integer.MAX_VALUE`?
