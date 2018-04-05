package utilidades;

import Bussines.SubsidyBussines;
import Entidades.EntSubsidies;
import Persistencia.DaosSubsidies;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Conexion {

    private static Connection cnx = null;

    public static Connection getCon() throws SQLException {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost/serviciospublicos", "root", "");
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }

    public static void closeConnection() throws SQLException {
        cnx.close();
    }
     
    public static void main(String[] args){
        try {
            SubsidyBussines subsidyBussines = new SubsidyBussines();
            EntSubsidies subsidy = new EntSubsidies();
            List<EntSubsidies> list = subsidyBussines.subsidiesList(subsidy);
            if (list != null) {
                System.out.println("Conexión correcta : Tienes " + list.size() + " subsidios registrados");
            } else {
                System.out.println("Conexión correcta : No hay subsidios registrados");
            }   
        } catch (Exception e) {
            System.out.println("No se puede conectar a base de datos");
        }
    }

}
