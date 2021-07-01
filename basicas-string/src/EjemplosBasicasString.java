
public class EjemplosBasicasString {
	public static void main(String[] args) {
        EjemplosBasicasString ejemplo = new EjemplosBasicasString();

        System.out.println("\n\nEjemplo de charAt");
        ejemplo.ejemploDeUsoDeCharAt();

        System.out.println("\n\nEjemplo de concat");
        ejemplo.ejemploDeConcat();

        System.out.println("\n\nEjemplo de indexOf");
        ejemplo.ejemploDeIndexOf();

        System.out.println("\n\nEjemplo de Split");
        ejemplo.ejemploDelUsoDeSplit();

        System.out.println("\n\nEjemplo de Trim");
        ejemplo.ejemploDeUsoDeTrim();
}
	
	public void ejemploDeUsoDeCharAt(){
        /**
         * Se muestra el uso del charAt en los strings, sirve para recuperar el caracter que hay
         * en una determinada posición de un String.
         */

        String s1 = "Este es un string";

        System.out.println("El caracter de la pos 0 es:  " + s1.charAt(0));
        System.out.println("El caracter de la 6ta pos es: " + s1.charAt(6));
        System.out.println("El ultimo caracter es: " + s1.charAt(s1.length() -1 ));

        try{
            char result = s1.charAt(-1);
            System.out.println("El caracter de la posicion 23 es: " + result);
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println("Ocurrio un error: " + e.getMessage()
                    + ". El rango de numeros del charAt debe ser mayor a cero y menor al length - 1.");
        }

    }

    public void ejemploDeConcat() {
        /**
         * La gran diferencia entre + y concat() es que podemos concatenar múltiples tipos de datos
         * con un String utilizando el operador +, pero el método concat() está restringido
         * a tomar sólo un valor de tipo String.
         */

        String a = "Usando";
        String b = "concat en java";

        String c = a.concat(b);
        String d = b.concat(a);

        String e = a.concat(" ").concat(b);

        System.out.println("String a = " + a);
        System.out.println("String b = " + b);
        System.out.println("String a concatenado con b = " + c);
        System.out.println("String b concatenado con a = " + d);

        System.out.println("Mostrando un concat anidado = " + e);
    }

    public void ejemploDeIndexOf(){
        String str_Sample = "Este es el índice del ejemplo";

        // Posición del caracter buscado
        System.out.println("Índice del caracter 'x': " + str_Sample.indexOf('x'));

        // Posicion del caracter después del valor de índice dado
        System.out.println("Índice del caracter 's' después de la pos 3:" + str_Sample.indexOf('s', 3));

        // Dar posición de índice para la subcadena dada
        System.out.println("Índice de subcadena 'es':" + str_Sample.indexOf("es"));

        // Dar posición de índice para la subcadena dada y comenzar el índice
        System.out.println("Indice de la subcadena --> 'es' desde la posicion 5: --> " + str_Sample.indexOf("es", 5));
    }

    public void ejemploDelUsoDeSplit(){
        String string = "123-654321";
        String[] parts = string.split("-");
        String part1 = parts[0]; // 123
        String part2 = parts[1]; // 654321

        System.out.println("La cadena entera es: " + string);
        System.out.println("La cadena despues de split por el caracter '-' quedo de la siguiente manera: ");
        System.out.println("Parte1 = " + part1);
        System.out.println("Parte2 = " + part2);
    }

    public void ejemploDeUsoDeTrim(){
        /**
         * Trim() es un método que elimina los caracteres blancos iniciales
         * y finales de la cadena, devolviendo una copia de la misma.
         */

        String sCadena = " Esto Es Una Cadena  " ;
        System.out.println("Sin trim: " + sCadena);  //Devuelve " Esto Es Una Cadena  "
        System.out.println("Con trim: " + sCadena.trim());  //Devuelve "Esto Es Una Cadena"
    }
}

