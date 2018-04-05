
package Controladores;

import Entidades.EntCiclos;
import Persistencia.DaoCiclos;


public class ControladorCiclos {
  
public boolean create(EntCiclos c){
    DaoCiclos dc = new DaoCiclos();
    return dc.registrarCiclos(c);
}       
    
public boolean deleteC(String idCycles){
    DaoCiclos dc = new DaoCiclos();
    return dc.deleteCycle(idCycles);
}       
   

}
