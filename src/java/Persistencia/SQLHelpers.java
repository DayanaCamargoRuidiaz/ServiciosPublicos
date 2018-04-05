package Persistencia;

import Entidades.EntHomeXCicle_Subsidies;
import Entidades.EntSubsidies;
import java.util.Date;

/**
 * @author Jeison Gonz[alez Cifuentes
 */

public class SQLHelpers {
    
    //-------------------------------------- Subsidy --------------------------------------
    public static String getSubsidyById(int id_subsidy) {
        if (id_subsidy == -1) {
            return "SELECT * FROM subsidy ORDER BY name";
        } else {
            return "SELECT * FROM subsidy WHERE idsubsidy = '" + id_subsidy + " ORDER BY name";        
        }
    }

    public static String getSubsidyCalculated(int idSubsidy){
        String query = "SELECT hc.idhome AS idHome, \n" +
"       sub.idsubsidy                        AS idSubsidy, \n" +
"       Now()                                AS assignmentDate, \n" +
"       IF(subType.nombre = \"Promedio\" , (hc.water - ((hc.water * subType.valueAtDiscretion) - 100)), (hc.water - subType.valueAtDiscretion)) AS waterValueObtained,\n" +
"       IF(subType.nombre = \"Promedio\" , (hc.electricity - ((hc.electricity * subType.valueAtDiscretion) - 100)), (hc.electricity - subType.valueAtDiscretion)) AS energyValueObtained,\n" +
"       IF(subType.nombre = \"Promedio\" , (hc.naturalGas - ((hc.naturalGas * subType.valueAtDiscretion) - 100)), (hc.naturalGas - subType.valueAtDiscretion)) AS naturalGasValueObtained,\n" +
"       cycles.idCycles AS idCycle"+
"       \n" +
"FROM   subsidy AS sub \n" +
"       INNER JOIN subsidytypes AS subType ON subType.idsubsidytypes = sub.type \n" +
"       INNER JOIN cycles AS cycles ON cycles.startdate >= sub.startdate AND cycles.enddate <= sub.enddate \n" +
"       INNER JOIN home_x_cycle AS hc ON hc.idcycle = cycles.idcycles \n" +
"WHERE  sub.idsubsidy = " + idSubsidy;
        return query;
    }
    
    public static String getSubsidy(int id_subsidy, Date startDate, Date endDate, String name, String description, 
            Double expectedWaterValue, Double expectedEnergyValue, Double expectedNaturalGasValue, int type){
        String query = "SELECT * FROM subsidy WHERE 1=1";
        if (id_subsidy > 0) {
            query += " AND idsubsidy = " + id_subsidy;            
        }
        if (startDate != null) {
            query += " AND startDate = " + startDate;             
        }
        if (endDate != null) {
            query += " AND endDate = " + endDate;             
        }
        if (name != null && !name.isEmpty()) {
            query += " AND (name like '%" + name + "%'";
            if (description != null && !description.isEmpty()) {
                query += " OR description like '%" + description  + "%')";;             
            }
        }
        if (expectedWaterValue != null) {
            query += " AND expectedWaterValue = " + expectedWaterValue;
        }
        if (expectedEnergyValue != null) {
            query += " AND expectedEnergyValue = " + expectedEnergyValue;
        }
        if (expectedNaturalGasValue != null) {
            query += " AND expectedNaturalGasValue = " + expectedNaturalGasValue;
        }
        if (type > 0) {
            query += " AND type = " + type;             
        }
        return query;
    }
    
    public static String updateSubsidy (){
        return "UPDATE subsidy SET startDate = ?, endDate = ?, name = ?, description = ?, expectedWaterValue = ?, expectedEnergyValue = ?, expectedNaturalGasValue = ?, type = ? WHERE idsubsidy = ?";
    }

    public static String insertSubsidy() {
        return "INSERT INTO subsidy (startDate, endDate, name, description, expectedWaterValue, expectedEnergyValue, expectedNaturalGasValue, type)"
                + " VALUES (?,?,?,?,?,?,?,?)";
    }

    public static String insertSubsidyCalculated() {
        return "INSERT INTO homexcycle_subsidies (idHome, idSubsidy, assignmentDate, waterValueObtained, energyValueObtained, naturalGasValueObtained, idCycle)"
                + " VALUES (?,?,?,?,?,?,?)";
    }

    public static String deleteSubsidy(int id_subsidy) {
        return "DELETE FROM subsidy WHERE idsubsidy = '" + id_subsidy + "'";
    }
    
    public static String deleteSubsidyCalculated(int id_subsidy) {
        return "DELETE FROM homexcycle_subsidies WHERE idSubsidy = '" + id_subsidy + "'";
    }
    
    
    /////////////////////////////////////////// Subsidy Type ////////////////////////////////////////
    
     public static String getSubsidyTypeById(int IdsubsidyTypes) {
        if (IdsubsidyTypes == -1) {
            return "SELECT * FROM subsidytypes ORDER BY nombre";
        } else {
            return "SELECT * FROM subsidytypes WHERE idsubsidyTypes = '" + IdsubsidyTypes + " ORDER BY nombre";        
        }
    }

    public static String getSubsidyType(int IdsubsidyTypes, String nombre, String descripcion, Double valueAtDiscretion ){
        String query = "SELECT * FROM subsidyTypes WHERE 1=1";
        if (IdsubsidyTypes > 0) {
            query += " AND idsubsidyTypes = " + IdsubsidyTypes;            
        }
        if (nombre != null && !nombre.isEmpty()) {
            query += " AND nombre = " + nombre;             
        }
        if (descripcion != null && !descripcion.isEmpty()) {
            query += " AND descripcion = " + descripcion;             
        }
        if (valueAtDiscretion != null) {
            query += " AND valueAtDiscretion = " + valueAtDiscretion;
        }
        return query;
    }
    
    public static String updateSubsidyType (){
        return "UPDATE subsidytypes SET idsubsidyTypes = ?, nombre = ?, descripcion = ?, valueAtDiscretion = ? WHERE idsubsidyTypes = ?";
    }

    public static String insertSubsidyType() {
        return "INSERT INTO subsidytypes (idsubsidyTypes, nombre, descripcion, valueAtDiscretion)"
                + " VALUES (?,?,?,?)";
    }

    public static String deleteSubsidyType(int IdsubsidyTypes) {
        return "DELETE FROM subsidytypes WHERE idsubsidyTypes = '" + IdsubsidyTypes + "'";
    }
    
    /////////////////////////////////// Report /////////////////////////////////////
    
    public static String getReport(int idHome, int idSubsidy, int idCycle, Date assignmentDate, Double waterValueObtained, Double energyValueObtained,
                                   Double naturalGasValueObtained, Double water, Double electricity, Double naturalGas){
        String query = "SELECT * FROM homexcycle_subsidies AS cal INNER JOIN home_x_cycle AS cons ON cons.idHome = cal.idHome WHERE 1=1";
//                + "INNER JOIN home_x_cycle AS cons ON cons.idHome = cal.idHome"
//                + "INNER JOIN cycles AS cycle ON cycle.idCycles = cons.idCycle"
//                + "WHERE 1=1";
        return query;
    }
   
}
