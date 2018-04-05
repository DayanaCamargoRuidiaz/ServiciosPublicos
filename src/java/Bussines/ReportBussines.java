
package Bussines;

import Entidades.EntReport;
import Persistencia.DaosReports;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import utilidades.Conexion;

/**
 *
 * @author josef
 */
public class ReportBussines {
    
    DaosReports dao;
    Connection conexion;

    public ReportBussines() {
        dao = new DaosReports();
    }

    public List<EntReport> reportList (EntReport report) throws SQLException {
        try {
            conexion = Conexion.getCon();
            return (List<EntReport>) dao.reportList(conexion, report);
        } catch (Exception e) {
            System.out.println("Error obteniendo listado para el reporte : " + e.getMessage());
            return null;
        }
    }
    
}
