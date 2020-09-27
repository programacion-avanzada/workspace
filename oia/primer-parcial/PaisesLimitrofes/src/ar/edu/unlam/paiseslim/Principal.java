package ar.edu.unlam.paiseslim;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Principal {
	
	private List<Pais> paises;
	private Map<String, String> translimitrofes;
	
	public Principal() {
		paises = new ArrayList<Pais>();
		translimitrofes = new TreeMap<String, String>();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Principal prin = leerArchivo("entrada.in");		
		
		prin.resolver();
		prin.mostrarTranslimitrofes();
		//prin.mostrarPaises();
		
	}
	
	public void resolver() {
		
		/* EG: Me paro en Argentina, busco sus paises limitrofes
		 * Me paro dentro de uno de esos paises limitrofes, por ejemplo, Chile
		 * Obtengo la lista de los paises con los que limita Chile
		 * Me paro en alguno de los paises limitrofes de Chile (por ejemplo, Peru) y obtengo su lista de limitrofes
		 * Pregunto si la lista de Peru contiene al pais Argentina	 
		 */
		
		//Por cada uno de los paises (ARGENTINA)
		for (Pais pais : paises) {
			//Traeme la lista con los que limita, y por cada uno de los que esta
			//dentro de esa lista... (CHILE)
			for (Pais paisLim : pais.getLimitaCon()) {
				//Recorremos a su vez la lista de sus paises limitrofes
				for (Pais p : paisLim.getLimitaCon()) {
					//Y preguntamos si en la lista de alguno de esos no esta PAIS
					if (!p.equals(pais) && !p.getLimitaCon().contains(pais)) {
						translimitrofes.put(pais.getNombre(), p.getNombre());
					}
				}
			}
		}
	}
	
	public void mostrarTranslimitrofes() {
		for(Map.Entry<String,String> entry : translimitrofes.entrySet()) {
			  String key = entry.getKey();
			  String value = entry.getValue();

			  System.out.println(key + " => " + value);
			}
	}
	
	public static Principal leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int cantPaises = sc.nextInt();
		//El nextInt no avanza hasta la proxima linea
		sc.nextLine();
		
		Principal prin = new Principal();
		
		for (int i = 0; i < cantPaises; i++) {
			//Pais pais = new Pais(sc.next());
			String nombre = new String(sc.next());
			String limi = new String(sc.next());
			
			//getPais --> O(n)
			Pais pais = prin.getPais(nombre);
			//Si no existe el pais, lo agregamos
			if (pais == null) {
				pais = new Pais(nombre);
				prin.paises.add(pais);
			}
			
			//getPais --> O(n)
			Pais paisLim = prin.getPais(limi);
			//Si no existe el lmitrofe, lo agregamos			
			if (paisLim == null) {
				paisLim = new Pais(limi);
				prin.paises.add(paisLim);
			}
			//Enlazamos el limitrofe con el pais
			pais.agregarPaisLimitrofe(paisLim);
			//Enlazamos al pais con el limitrofe
			paisLim.agregarPaisLimitrofe(pais);
			
			if (sc.hasNext()) {			
				sc.nextLine();	
			}
		}
		
		return prin;	
	}
	
	//O(n)
	public Pais getPais(String nombre) {
		for (Pais pais : paises) {
			if (pais.getNombre().equals(nombre)) {
				return pais;
			}
		}
		
		return null;
	}
	
	public void mostrarPaises() {
		for (Pais pais : paises) {
			System.out.println(pais.getNombre());
			System.out.println("LIMITA CON: ");
			pais.mostrarLimitrofes();
			System.out.println("---------------");
		}
	}
}
