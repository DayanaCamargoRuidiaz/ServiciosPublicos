
package Controladores;

import Persistencia.DaoPersonas;
import Entidades.EntPersonas;

public class ControladorPersonas {
   
         //Guardar
  public boolean createPerson(EntPersonas p){
    DaoPersonas dp = new DaoPersonas();
    return dp.insertPerson(p);
}  
//Borrar
   public boolean delete(String idPerson){
    DaoPersonas dp = new DaoPersonas();
    return dp.deletePersona(idPerson);
}  
   
    
}
