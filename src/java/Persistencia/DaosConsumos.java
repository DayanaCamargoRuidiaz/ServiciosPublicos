package Persistencia;

import Entidades.EntConsumos;
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

/**
 *
 * @author Juan Mesa
 */
public class DaosConsumos extends ConBD1{
    
     //Guardar
    public boolean insertConsumo(EntConsumos c) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "insert into home_x_cycle(idHome,idCycle,electricity,water,naturalGas)values(?,?,?,?,?)";
            pst = getConexionMysql().prepareStatement(sql);
            pst.setString(1, c.getIdHome());
            pst.setString(2, c.getIdCycle());
            pst.setString(3, c.getElectricity());
            pst.setString(4, c.getWater());
            pst.setString(5, c.getNaturalGas());

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
   /* public static void main(String[] args) {
        DaosConsumos dc = new DaosConsumos();
        System.out.println(dc.insertConsumo(new EntConsumos("2", "2", "300.00", "300.00", "209.00")));
    }*/

    public boolean deleteConsumo(String idHome){
        boolean flag = false;
        PreparedStatement pst = null;
        
        try {
        String sql = "delete from home_x_cycle where idHome = ?";    
        pst = getConexionMysql().prepareStatement(sql);
        pst.setString(1, idHome);
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
