/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.EntCiclos;
import java.sql.PreparedStatement;
import utilidades.ConBD1;


public class DaoCiclos extends ConBD1{
    
   /* public boolean consultaCiclos(EntCiclos c){
        boolean flag = false;
         PreparedStatement pst = null;
        try {
            String sql = "select idCycles"
                    + " from cycles as cycles "
                    + "where (#{startDate} between cycles.startDate and cycles.endDate "
                    + "or (#{enDate} between cycles.startDate and cycles.endDate "
                    + "or cycles.startDate between #{startDate} and #{endDate}"
                    + "or cycles.endDate betwenn #{startDate} and #{endDate}) limit l;"; 
            pst = getConexionMysql().prepareStatement(sql);

            if (pst.executeUpdate()== 1) {
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
   */
    public boolean registrarCiclos(EntCiclos c) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "insert into cycles(name,startDate,endDate)values(?,?,?)";
            pst = getConexionMysql().prepareStatement(sql);
            pst.setString(1, c.getName());
            pst.setString(2, c.getStartDate());
            pst.setString(3, c.getEndDate());

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
        DaoCiclos dc = new DaoCiclos();
        System.out.println(dc.registrarCiclos(new EntCiclos("Enero", "12/01/2018", "31/01/2018")));
    }*/
      public boolean deleteCycle(String idCycles){
        boolean flag = false;
        PreparedStatement pst = null;
        
        try {
        String sql = "delete from cycles where idCycles = ?";    
        pst = getConexionMysql().prepareStatement(sql);
        pst.setString(1, idCycles);
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
