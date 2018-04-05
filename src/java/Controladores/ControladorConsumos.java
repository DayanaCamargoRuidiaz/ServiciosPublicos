package Controladores;

import Persistencia.DaosConsumos;
import Entidades.EntConsumos;

/**
 *
 * @author Juan Mesa
 */
public class ControladorConsumos {
    
      //Guardar
  public boolean createConsumo(EntConsumos h){
    DaosConsumos dc = new DaosConsumos();
    return dc.insertConsumo(h);
}  
  //Borrar
   public boolean deleteConsumo(String idHome){
    DaosConsumos dc = new DaosConsumos();
    return dc.deleteConsumo(idHome);
}  
   
}
