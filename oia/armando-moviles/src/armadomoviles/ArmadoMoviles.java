
package armadomoviles;

import java.io.FileNotFoundException;
import java.io.IOException;


public class ArmadoMoviles {

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
    
        Archivo ar = new Archivo("colgantes.in");
        
        ar.procesarArchivoIn();
        ar.setNombre("colgantes.out");
        ar.generarArchivoOut();
        
            
        
    }
    
}
