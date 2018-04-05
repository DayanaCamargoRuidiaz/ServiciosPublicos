package Persistencia;

import Entidades.EntReport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author josef
 */
public class DaosReports {
    
    public List<EntReport> reportList(Connection conexion, EntReport report) {
        List<EntReport> list = new ArrayList<>();
        try {
            PreparedStatement stm = conexion.prepareStatement(
                    SQLHelpers.getReport(report.getIdHome(), report.getIdSubsidy(), report.getIdCycle(), report.getAssignmentDate(), 
                                         report.getWaterValueObtained(), report.getEnergyValueObtained(), report.getNaturalGasValueObtained(), 
                                         report.getWater(), report.getElectricity(), report.getNaturalGas()));
            ResultSet rc = stm.executeQuery();
            while (rc.next()) {
                EntReport reportlist = new EntReport();
                reportlist.setIdSubsidy(rc.getInt(2));
                reportlist.setIdHome(rc.getInt(1));
                reportlist.setAssignmentDate(rc.getDate(3));
                reportlist.setWaterValueObtained(rc.getDouble(4));
                reportlist.setEnergyValueObtained(rc.getDouble(5));
                reportlist.setNaturalGasValueObtained(rc.getDouble(6));
                reportlist.setIdCycle(rc.getInt(7));
                reportlist.setWater(rc.getDouble(11));
                reportlist.setElectricity(rc.getDouble(10));
                reportlist.setNaturalGas(rc.getDouble(12));
                list.add(reportlist);
            }
        } catch (Exception e) {
            System.out.println("Error en DaosReports / ReportList : " + e.getMessage());
        }
        return list;
    }
    
}