package ar.edu.unlam.dialogo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Dialogo {
	
	private String dialogos[];
	private String salida[];
	private int contadorUno;
	private int contadorOnce;
	private String palabras[];
	
	public Dialogo(String arrStr[]) {
		this.dialogos = arrStr;
		this.salida = new String[arrStr.length];
		palabras = new String[6];
		guardarPalabras();
		
	}
	
	public String[] getDialogos() {
		return this.dialogos;
	}
	
	public int getCantDialogos() {
		return this.dialogos.length;
	}
	
	public static void main(String[] args) throws IOException {
		Dialogo diag = leerArchivo("./Casos de Prueba/Entrada/fatiga.in");
		
		diag.resolver();
		diag.escribirArchivoSalida("./Casos de Prueba/Salida/fatiga.out");		
	}
	
	public void guardarPalabras() {
		palabras[0] = "neo";
		palabras[1] = "union";
		palabras[2] = "once";
		palabras[3] = "eco";
		palabras[4] = "clone";
		palabras[5] = "uno";
	}
	
	public void resolver() {
		int indicePrin = 0;
		boolean esDialogo = true, encontrado = false;		

		/* maxD = 1000 (lineas de dialogo)
		 * maxDiag = 107 (caracteres por dialogo)
		 * cantPal = 6 (palabras de cada persona)
		 */
		
		//O(maxD * maxDiag * cantPal) 
		//En el peor de los casos, o sea, 1000 dialogos de 107 caracteres
		//en los que cada uno tenga todas las palabras que dicen las personas
		for (int i = 0; i < this.dialogos.length; i++) {
			//Inicializo en 0
			indicePrin = 0;
			contadorUno = 0;
			contadorOnce = 0;
			esDialogo = true;
			
			//Mientras que no lleguemos al final de la cadena, y lo que estemos analizando sea un dialogo
			
			while (indicePrin < this.dialogos[i].length() && esDialogo) {
				//Inicializamos para el nuevo ciclo
				encontrado = false;
				
				for (int j = 0; j < palabras.length && !encontrado; j++) {
					int diagLength = this.dialogos[i].length();
					int palabrasLength = this.palabras[j].length();				
					
					if (diagLength-indicePrin >= palabrasLength) {
						String sub = this.dialogos[i].substring(indicePrin, indicePrin+palabrasLength);
						
						if (sub.equals(palabras[j])) {
							if (j < 3) 
								contadorUno++;
							else
								contadorOnce++;						
							encontrado = true;						
							indicePrin += palabras[j].length();	
						}				
					}
				}
								
				if (!encontrado) {
					esDialogo = false;
					salida[i] = new String("NO");					
				}								
			}
			//Si sale del while, quiere decir que, o no es dialogo, o termina la linea
			if (esDialogo) {
				salida[i] = "SI" + " " + contadorUno + " " + contadorOnce;
			}						
		}		
	}
	
	public void escribirArchivoSalida(String path) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(path));
		
		for (int i = 0; i < this.salida.length; i++) {
			out.println(salida[i]);
		}
		
		out.close();		
	}

	public static Dialogo leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int cantDialogos = sc.nextInt();
		//El nextInt no hace el salto del linea
		sc.nextLine();
		String []arrStr = new String[cantDialogos];
		
		for (int i = 0; i < cantDialogos; i++) {
			arrStr[i] = sc.nextLine();
		}		
		sc.close();
		
		return new Dialogo(arrStr);
	}	
}
