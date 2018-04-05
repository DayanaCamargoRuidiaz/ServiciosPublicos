package Persistencia;

import Entidades.EntHogares;
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
public class DaosHogares extends ConBD1 {

    public DaosHogares() {
        DaosHogares daoHog;
    }

    //Metodo cargar lista
    public List<EntHogares> listHome(Connection con) {
        List<EntHogares> resul = new ArrayList<EntHogares>();
        try {
            PreparedStatement consAct = con.prepareStatement("SELECT * FROM home");
            ResultSet result = consAct.executeQuery();

            while (result.next()) {
                EntHogares home = new EntHogares();
                home.setIdHome(result.getString(1));
                home.setAddress(result.getString(2));
                home.setLandline(result.getString(3));
                home.setIdPerson(result.getString(4));
                resul.add(home);
            }//Fin while
        } catch (SQLException ex) {
            Logger.getLogger(DaosHogares.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }//Fin Try/catch
        }//Fin Try/catch/finally
        return resul;
    }//fin cargar lista

    //Guardar
    public boolean insertHome(EntHogares h) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "insert into home(address,landline,idPerson)values(?,?,?)";
            pst = getConexionMysql().prepareStatement(sql);
            pst.setString(1, h.getAddress());
            pst.setString(2, h.getLandline());
            pst.setString(3, h.getIdPerson());

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

    public boolean deleteHome(String idHome){
        boolean flag = false;
        PreparedStatement pst = null;
        
        try {
        String sql = "delete from home where idHome = ?";    
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
