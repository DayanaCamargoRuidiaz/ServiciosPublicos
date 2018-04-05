package Persistencia;

import Entidades.EntHomeXCicle_Subsidies;
import Entidades.EntSubsidies;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeison González Cifuentes
 */
public class DaosSubsidies {

    public String deleteSubsidy(Connection conection, int id_subsidy) {
        String info = "";
        try {
            PreparedStatement stm = conection.prepareStatement(SQLHelpers.deleteSubsidy(id_subsidy));
            stm.execute();
            info = "¡¡Bien!! : Registro borrado exitosamente";
        } catch (Exception e) {
            info = "Error intentando borrar el subsidio con código : " + id_subsidy;
            System.out.println("Error intentando borrar el subsidio con código : " + id_subsidy + "\n Error : " + e.getMessage());
        }
        return info;
    }
    
    public void deleteSubsidyCalculated(Connection conection, int id_subsidy) {
        try {
            PreparedStatement stm = conection.prepareStatement(SQLHelpers.deleteSubsidyCalculated(id_subsidy));
            stm.execute();
        } catch (Exception e) {
            System.out.println("Error intentando borrar el subsidio calculado con código : " + id_subsidy + "\n Error : " + e.getMessage());
        }
    }

    public List<EntHomeXCicle_Subsidies> getSubsidyCalculated(Connection conexion, int idSubsidy) {
        List<EntHomeXCicle_Subsidies> list = new ArrayList<>();
        try {
            PreparedStatement stm = conexion.prepareStatement(SQLHelpers.getSubsidyCalculated(idSubsidy));
            ResultSet rc = stm.executeQuery();
            while (rc.next()) {
                EntHomeXCicle_Subsidies homeXCicle_Subsidies = new EntHomeXCicle_Subsidies();
                homeXCicle_Subsidies.setIdHomeXcycle(rc.getInt(1));
                homeXCicle_Subsidies.setIdSubsidy(rc.getInt(2));
                homeXCicle_Subsidies.setAssignmentDate(rc.getDate(3));
                homeXCicle_Subsidies.setWaterValueObtained(rc.getDouble(4));
                homeXCicle_Subsidies.setEnergyValueObtained(rc.getDouble(5));
                homeXCicle_Subsidies.setNaturalGasValueObtained(rc.getDouble(6));
                homeXCicle_Subsidies.setIdCycle(rc.getInt(7));
                list.add(homeXCicle_Subsidies);
            }
        } catch (Exception e) {
            System.out.println("Error en DaoSubsidies / subsidiesList : " + e.getMessage());
        }
        return list;
    }
    
    public List<EntSubsidies> subsidiesList(Connection conexion, EntSubsidies subsidies) {
        List<EntSubsidies> list = new ArrayList<>();
        try {
            PreparedStatement stm = conexion.prepareStatement(
                    SQLHelpers.getSubsidy(subsidies.getIdSybsudy(), subsidies.getStartDate(), subsidies.getEndDate(),subsidies.getName(), subsidies.getDescription(), 
                            subsidies.getExpectedWaterValue(),subsidies.getExpectedEnergyValue(), subsidies.getExpectedNaturalGasValue(), subsidies.getType()));
            ResultSet rc = stm.executeQuery();
            while (rc.next()) {
                EntSubsidies subsidy = new EntSubsidies();
                subsidy.setIdSybsudy(rc.getInt(1));
                subsidy.setStartDate(rc.getDate(2));
                subsidy.setEndDate(rc.getDate(3));
                subsidy.setName(rc.getString(4));
                subsidy.setDescription(rc.getString(5));
                subsidy.setExpectedWaterValue(rc.getDouble(6));
                subsidy.setExpectedEnergyValue(rc.getDouble(7));
                subsidy.setExpectedNaturalGasValue(rc.getDouble(8));
                subsidy.setType(rc.getInt(9));
                list.add(subsidy);
            }
        } catch (Exception e) {
            System.out.println("Error en DaoSubsidies / subsidiesList : " + e.getMessage());
        }
        return list;
    }

    public String insertSubsidyCalculated(Connection conexion, List<EntHomeXCicle_Subsidies> entHomeXCicle_Subsidies) {
        String info = "";
        try {
            for (EntHomeXCicle_Subsidies entHomeXCicle_Subsidy : entHomeXCicle_Subsidies) {
                PreparedStatement stm = conexion.prepareStatement(SQLHelpers.insertSubsidyCalculated());
                stm.setInt(1, entHomeXCicle_Subsidy.getIdHomeXcycle());
                stm.setInt(2, entHomeXCicle_Subsidy.getIdSubsidy());
                stm.setDate(3, entHomeXCicle_Subsidy.getAssignmentDate());
                stm.setDouble(4, entHomeXCicle_Subsidy.getWaterValueObtained());
                stm.setDouble(5, entHomeXCicle_Subsidy.getEnergyValueObtained());
                stm.setDouble(6, entHomeXCicle_Subsidy.getNaturalGasValueObtained());
                stm.setInt(7, entHomeXCicle_Subsidy.getIdCycle());
                stm.execute();
                if (stm.getUpdateCount() > 0) {
                    info = "¡¡Bien!! : Subsidio calculado exitosamente";
                } else {
                    info = "Error intentando guardar el subsidio";
                }
            }
        } catch (Exception e) {
            System.out.println("Error intentando guardar subsidio : " + e.getMessage());
        }
        return info;
    }
    
    public String insertSubsidy(Connection conexion, EntSubsidies subsidy) {
        String info = "";
        try {
            PreparedStatement stm = conexion.prepareStatement(SQLHelpers.insertSubsidy());
            stm.setDate(1, subsidy.getStartDate());
            stm.setDate(2, subsidy.getEndDate());
            stm.setString(3, subsidy.getName());
            stm.setString(4, subsidy.getDescription());
            stm.setDouble(5, subsidy.getExpectedWaterValue());
            stm.setDouble(6, subsidy.getExpectedEnergyValue());
            stm.setDouble(7, subsidy.getExpectedNaturalGasValue());
            stm.setInt(8, subsidy.getType());
            stm.execute();
            if (stm.getUpdateCount() > 0) {
                info = "¡¡Bien!! : Subsidio '" + subsidy.getName() + "' guardado exitosamente";
            } else {
                info = "Error intentando guardar el subsidio : " + subsidy.getName();
            }
        } catch (Exception e) {
            System.out.println("Error intentando guardar subsidio : " + e.getMessage());
        }
        return info;
    }

    public String updateSubsidy(Connection conexion, EntSubsidies subsidy) {
        String info = "";
        try {
            PreparedStatement stm = conexion.prepareStatement(SQLHelpers.updateSubsidy());
            stm.setDate(1, subsidy.getStartDate());
            stm.setDate(2, subsidy.getEndDate());
            stm.setString(3, subsidy.getName());
            stm.setString(4, subsidy.getDescription());
            stm.setDouble(5, subsidy.getExpectedWaterValue());
            stm.setDouble(6, subsidy.getExpectedEnergyValue());
            stm.setDouble(7, subsidy.getExpectedNaturalGasValue());
            stm.setInt(8, subsidy.getType());
            stm.setInt(9, subsidy.getIdSybsudy());
            stm.execute();
            if (stm.getUpdateCount() > 0) {
                info = "¡¡Bien!! : Subsidio '" + subsidy.getName() + "' editado exitosamente";
            } else {
                info = "Error intentando editar el subsidio : " + subsidy.getName();
            }
        } catch (Exception e) {
            System.out.println("Error intentando guardar subsidio : " + e.getMessage());
        }
        return info;
    }
}
