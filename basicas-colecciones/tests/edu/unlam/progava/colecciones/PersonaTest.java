package edu.unlam.progava.colecciones;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class PersonaTest {

	@Test
	public void ejemploPersonaOrdenada() {// USO DE TREESET, CON OBJETOS
		Set<Persona> personasOrdenadas = new TreeSet<Persona>();

		personasOrdenadas.add(new Persona("Guadalajara", 47));
		personasOrdenadas.add(new Persona("la Paz", 34));
		personasOrdenadas.add(new Persona("Buenos Aires", 51));
		personasOrdenadas.add(new Persona("montevideo", 25));
		personasOrdenadas.add(new Persona("la Paz", 34));
		personasOrdenadas.add(new Persona("quito", 48));
		personasOrdenadas.add(new Persona("bogota", 70));

		Iterator<Persona> it = personasOrdenadas.iterator();
		int edad1 = -1;
		int edad = 0;
		while (it.hasNext()) {
			if (edad1 == -1)
				edad1 = it.next().getEdad();
			edad = it.next().getEdad();
		}
		assertTrue(!personasOrdenadas.isEmpty());// VERIFICO QUE LA LISTA FUE CARGADA Y TIENE ELEMENTOS
		assertEquals(6, personasOrdenadas.size());// VERIFICO QUE LA LISTA NO AGREGO REPETIDOS
		assertNotEquals(7, personasOrdenadas.size());// VERIFICO QUE LA LISTA NO AGREGO REPETIDOS
		// VERIFICAR QUE APARECEN ORDENADOS
		assertEquals(25, edad1);// VERIFICO QUE EL PRIMER ELEMENTO ES EL MENOR
		assertEquals(70, edad);// VERIFICO QUE EL ULTIMO ELEMENTO ES EL MAYOR

	}

	@Test
	public void ejemploPersonaOrdenInverso() {// USO DE TREESET,ORDEN INVERSO
		Set<Persona> personasOrdenInverso = new TreeSet<Persona>(Collections.reverseOrder());
		personasOrdenInverso.add(new Persona("Guadalajara", 47));
		personasOrdenInverso.add(new Persona("la Paz", 34));
		personasOrdenInverso.add(new Persona("Buenos Aires", 51));
		personasOrdenInverso.add(new Persona("montevideo", 25));
		personasOrdenInverso.add(new Persona("la Paz", 34));// ELEMENTO REPETIDO
		personasOrdenInverso.add(new Persona("quito", 48));

		Iterator<Persona> it = personasOrdenInverso.iterator();
		int edad1 = -1;
		int edad = 0;
		while (it.hasNext()) {
			if (edad1 == -1)
				edad1 = it.next().getEdad();// ACA GUARDO EL PRIMER ELEMENTO, ES DECIR EL MAYOR
			edad = it.next().getEdad();// ACA GUARDO EL ULTIMO ELEMENTO,ES DECIR EL MENOR
		}

		assertTrue(!personasOrdenInverso.isEmpty());// LA LISTA ESTA CARGADA Y TIENE ELEMENTOS
		assertEquals(5, personasOrdenInverso.size());// LA LISTA NO AGREGA REPETIDOS
		assertNotEquals(6, personasOrdenInverso.size());// LA LISTA NO AGREGA REPETIDOS
		assertEquals(51, edad1);// VERIFICO QUE EL PRIMER ELEMENTO ES EL MENOR
		assertEquals(25, edad);// VERIFICO QUE EL ULTIMO ELEMENTO ES EL MAYOR
	}

	@Test
	public void ejemploPersonaRemoverDeLista() {
		Set<Persona> personasModificables = new TreeSet<Persona>();
		personasModificables.add(new Persona("Guadalajara", 47));
		personasModificables.add(new Persona("la Paz", 34));
		personasModificables.add(new Persona("Buenos Aires", 51));
		personasModificables.add(new Persona("montevideo", 25));
		personasModificables.add(new Persona("la Paz", 34));// ELEMENTO REPETIDO
		personasModificables.add(new Persona("quito", 48));

		Iterator<Persona> it = personasModificables.iterator();
		int edad = 0;
		while (it.hasNext()) {
			edad = it.next().getEdad();
			if (edad > 40)
				it.remove();// ELIMINO TODOS LOS MAYORES A 40
		}
		assertNotEquals(5, personasModificables.size());// VERIFICO QUE SE BORRARON ELEMENTOS
		assertEquals(2, personasModificables.size());// SI ELIMINO A LOS MAYORES DE 40,SOLO DEBERIAN QUEDAR 3 EN LA
														// LISTA
	}

	@Test
	public void ejemploConLambdas() {
		ArrayList<Persona> listaP = new ArrayList<>();
		listaP.add(new Persona("citi1",5));
		listaP.add(new Persona("citi2",4));
		listaP.add(new Persona("citi3",23));
		listaP.add(new Persona("citi4",90));
		listaP.add(new Persona("citi5",1));
		listaP.add(new Persona("citi6",11));
		
		Collections.sort(listaP,(Persona p1,Persona p2)-> p1.compareTo(p2));
		//VERIFICO QUE CON EL USO DE LAMBDAS SE HACE BIEN EL ORDENAMIENTO
		assertTrue(!listaP.isEmpty());//VERIFICO QUE LA LISTA NO ESTE VACIA
		assertEquals(6,listaP.size());//VERIFICO QUE LA LISTA SE CARGO CORRECTAMENTE
		assertEquals(1,listaP.get(0).getEdad());//VERIFICO QUE EL PRIMER ELEMENTO ES EL MENOR
		assertEquals(90,listaP.get(listaP.size()-1).getEdad());//VERIFICO QUE EL ULTIMO ELEMENTO ES EL MAYOR
	}

}
