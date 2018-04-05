package Controladores;

import Entidades.EntHogares;
import Persistencia.DaosHogares;
import java.sql.Connection;
import java.util.List;
import utilidades.ConBD1;
import javax.swing.JOptionPane;
/**
 *
 * @author Juan Mesa
 */
public class ControladorHogares {
    
    //Guardar
  public boolean create(EntHogares h){
    DaosHogares dh = new DaosHogares();
    return dh.insertHome(h);
}  
  //Borrar
   public boolean delete(String idHome){
    DaosHogares dh = new DaosHogares();
    return dh.deleteHome(idHome);
}  
   
}

