# Logística de Paquetería

Este problema tiene como objetivo demostrar cómo utilizar la herencia y el polimorfismo, utilizando para ello un problema simple:

> Se desea asignar paquetes a vehículos, para poder distribuirlos.

## Características especiales del problema

1. Los paquetes tienen un destino y un peso. Para simplificar utilizaremos `String` e `int` respectivamente.
2. Los vehículos pueden cargar hasta cierto peso límite.
3. Un tipo de vehículo es una bicicleta, que tiene una zona fija y un límite de 20 kilogramos de carga.
4. El otro tipo de vehículo es una camioneta, que tiene la posibilidad de ir a varias zonas, y un límite de 2000 kilogramos de carga.

## Puntos de extensión

* Se podría agregar un transporte Courier, que vaya a donde sea necesario (siempre acepta el paquete).
* Se podría agregar el concepto de volumen del paquete.
* El paquete podría conocer si fue asignado o no.
* Podría ofrecerse una optimización para utilizar tan pocos transportes como sea posible (¿Ordenar los transportes por mayor cantidad de destinos primero? ¿Destinos disjuntos?)
