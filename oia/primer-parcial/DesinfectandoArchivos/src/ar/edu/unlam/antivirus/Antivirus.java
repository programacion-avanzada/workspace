package ar.edu.unlam.antivirus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Antivirus {
	
	public static void main(String[] args) throws FileNotFoundException {
		leerArchivo("entrada.in");
	}
	
	
	public static void leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(path));
		
		int length = sc.nextInt();
		char pri = sc.next().charAt(0), seg = sc.next().charAt(0);
		sc.nextLine();
		
		String infectado = sc.nextLine();
		StringBuilder desinfectado = new StringBuilder();
		
		for (int i = 0; i <= length-1; i++) {
			if (chequearInfeccion(length, i, pri, seg, infectado))
			{
				desinfectado.append(infectado.charAt(i));
				i++;
			} else {
				desinfectado.append(infectado.charAt(i));				
			}
		}
		
		System.out.println(desinfectado.toString());
		
		sc.close();		
	}
	
	public static boolean chequearInfeccion(int length, int pos, char pri, char seg, String infectado) {
		if (pos+2 > length)
			return false;
		
		if (infectado.charAt(pos) == pri && infectado.charAt(pos+1) == seg && infectado.charAt(pos+2) == pri) 
			return true;
		else 
			return false;
	}

}
