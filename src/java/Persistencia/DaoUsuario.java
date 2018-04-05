/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.EntUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utilidades.ConBD1;
import utilidades.Encriptar;

public class DaoUsuario extends ConBD1 {

    public boolean registrarUsuario(EntUsuario u) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "insert into user(userName,password,idProfile)values(?,?,?)";
            pst = getConexionMysql().prepareStatement(sql);
            pst.setString(1, u.getUserName());
            pst.setString(2, Encriptar.sha1(u.getPassword()));
            pst.setString(3, u.getIdProfile());

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

    public int autenticar(EntUsuario u) {
        int perfil = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "select idProfile from user where userName=? and password=?";
            pst = getConexionMysql().prepareStatement(sql);
            pst.setString(1, u.getUserName());
            pst.setString(2, Encriptar.sha1(u.getPassword()));
            rs = pst.executeQuery();
            while (rs.next()) {
                perfil = rs.getInt(1);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (getConexionMysql() != null) {
                    getConexionMysql().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (Exception e) {
            }
        }
        return perfil;

    }

}
