
package Persistencia;

import Entidades.EntPersonas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utilidades.ConBD1;

public class DaoPersonas extends ConBD1{
    
  //Guardar
    public boolean insertPerson(EntPersonas p) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "insert into person(name,lastName,documentNumber,email)values(?,?,?,?)";
            pst = getConexionMysql().prepareStatement(sql);
            pst.setString(1, p.getName());
            pst.setString(2, p.getLastName());
            pst.setString(3, p.getDocumentNumber());
            pst.setString(4, p.getEmail());

            if (pst.executeUpdate() == 1) {
                flag = true;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }
        }

        return flag;
    }

    public boolean deletePersona(String idPerson){
        boolean flag = false;
        PreparedStatement pst = null;
        
        try {
        String sql = "delete from person where idPerson = ?";    
        pst = getConexionMysql().prepareStatement(sql);
        pst.setString(1, idPerson);
        if(pst.executeUpdate()==1){
            flag = true;
        }
        } catch (Exception e) {
         System.err.println(e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }
        }

        return flag;
    }
       
    
   
}
