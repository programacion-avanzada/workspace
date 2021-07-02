# Montículo
# ¿Qué es?
Un montículo es un tipo especial de árbol que debe cumplir las siguientes condiciones:
•	Binario: cada nodo puede tener como máximo dos hijos (hijo izquierdo e hijo derecho).
•	Completo (o casi completo): cada nivel tiene todos sus nodos, excepto el último que se va llenando de izquierda a derecha.
•	Propiedad de montículo: si es un montículo de mínimos, cada nodo debe tener un valor menor o igual que el valor de sus hijos; si es un montículo de máximos, cada nodo debe tener un valor mayor o igual que el valor de sus hijos.

![image](https://user-images.githubusercontent.com/70980802/124330659-470a4500-db64-11eb-81f1-e3ac4b94da0c.png)
 
# ¿Qué operaciones puede realizarse?
•	Insertar Nodo: se ubica el nodo a insertar al final del montículo y se verifica que cumpla la propiedad de montículo. Si no se cumple, se intercambia el nodo con su padre hasta que el árbol vuela a cumplir la propiedad.
Ejemplo: se quiere insertar el nodo 30 en un montículo de máximos. Se inserta al final del montículo, pero no cumple la propiedad de montículo ya que es mayor que su padre (15); se intercambian los nodos y se comprueba que aún no cumple la propiedad. Entonces se intercambia con su padre (23). Finalmente, el montículo cumple todas las condiciones.
 
![image](https://user-images.githubusercontent.com/70980802/124330673-4d98bc80-db64-11eb-822c-9397a0a24cf7.png)

•	Eliminar Nodo: se extrae el nodo raíz y se coloca en su lugar el último nodo del montículo. Se verifica que cumpla la propiedad de montículo. Si no se cumple, se intercambia el nodo con su hijo (de mayor valor en montículos de máximos o de menor valor en montículos de mínimos) hasta que el árbol vuela a cumplir la propiedad.
Ejemplo: se extrae el nodo raíz de un montículo de máximos (30) y se coloca en su lugar el último nodo del montículo (15). Como no se cumple la propiedad, se intercambia al nodo 15 con su hijo de mayor valor (23). Se verifica que ahora se cumple la propiedad por lo que no requiere más intercambios.

 ![image](https://user-images.githubusercontent.com/70980802/124330681-54bfca80-db64-11eb-868d-73f13a342ceb.png)

•	Ver Raíz: devuelve el valor del nodo raíz sin extraerlo del montículo.
# ¿Cómo se implementa?
Los montículos se implementan utilizando arrays. En el array, el elemento en la posición 0 representa a la raíz del montículo.
Siendo i, el i-ésimo nodo del array se puede obtener que:
•	El hijo izquierdo del nodo i se encuentra en: 2*i + 1 (si 2*i + 1 es menor a la longitud del array).
•	El hijo derecho del nodo i se encuentra en: 2*i + 2 (si 2*i + 2 es menor a la longitud del array).
•	El padre del nodo i se encuentra en: (i-1)/2 (si i es distinto de 0).

Ejemplo. Para el nodo de valor 12 (i = 3):
Hijo izquierdo = 2*i + 1 = 2*3 + 1 = 7   nodo de valor 6
Hijo derecho = 2*i + 2 = 2*3 + 2 = 8   nodo de valor 8
Padre = (i-1)/2 = (3-1)/2 = 1   nodo de valor 18

 ![image](https://user-images.githubusercontent.com/70980802/124330691-58535180-db64-11eb-9eb6-35b59c42b138.png)

# Otras Fuentes
https://www.youtube.com/watch?v=AD_J4ZUheik&ab_channel=UniversitatPolit%C3%A8cnicadeVal%C3%A8ncia-UPV
