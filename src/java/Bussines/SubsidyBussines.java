package Bussines;

import Entidades.EntHomeXCicle_Subsidies;
import Entidades.EntSubsidies;
import Persistencia.DaosSubsidies;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import utilidades.Conexion;

/**
 * @author Jeison González Cifuentes
 */
public class SubsidyBussines {
    
    DaosSubsidies dao;
    Connection conexion;

    public SubsidyBussines() {
        dao = new DaosSubsidies();
    }

    public List<EntSubsidies> subsidiesList (EntSubsidies subsidies) throws SQLException {
        try {
            conexion = Conexion.getCon();
            return (List<EntSubsidies>) dao.subsidiesList(conexion, subsidies);
        } catch (Exception e) {
            System.out.println("Error obteniendo listado de subsidios : " + e.getMessage());
            return null;
        }
    }

    public String deleteSubsidy(String id_subsidy) throws SQLException {
        if (id_subsidy == null || id_subsidy.isEmpty()) {
            return "Advertencia : Por favor seleccione el subsidio que desea eliminar.";
        }
        conexion = Conexion.getCon();
        dao.deleteSubsidyCalculated(conexion, Integer.parseInt(id_subsidy));
        return dao.deleteSubsidy(conexion, Integer.parseInt(id_subsidy));
    }

    public String calculateSubsidy(EntSubsidies subsidy) throws SQLException {
        String info = validateSubsidy(subsidy);
        
        if (info.isEmpty()) {
            conexion = Conexion.getCon();
            if (subsidy.getIdSybsudy() > 0) {
                dao.deleteSubsidyCalculated(conexion, subsidy.getIdSybsudy());
                dao.updateSubsidy(conexion, subsidy);
            } else {
                EntSubsidies sub = new EntSubsidies();
                sub.setName(subsidy.getName());
                sub.setDescription(subsidy.getDescription());
                List<EntSubsidies> subsidiesList = subsidiesList(sub);
                if (subsidiesList != null && !subsidiesList.isEmpty()) {
                    info = "Advertencia : Ya existe un registro con los datos ingresados";
                    return info;
                }
                dao.insertSubsidy(conexion, subsidy);
            }
            List<EntHomeXCicle_Subsidies> hcSubsidy = dao.getSubsidyCalculated(conexion, subsidy.getIdSybsudy());
            if (hcSubsidy != null && !hcSubsidy.isEmpty()) {
                info = dao.insertSubsidyCalculated(conexion, hcSubsidy);
            } else {
                info = "Advertencia : No hay hogares que apliquen para este subsidio";
            }
        } else {
            info = "Advertencia : " + info;
        }
        return info;
    }
    
    public String saveSubsidy(EntSubsidies subsidy) throws Exception {
        String info = validateSubsidy(subsidy);
        if (info.isEmpty()) {
            conexion = Conexion.getCon();
            if (subsidy.getIdSybsudy() > 0) {
                info = dao.updateSubsidy(conexion, subsidy);
            } else {
                EntSubsidies sub = new EntSubsidies();
                sub.setName(subsidy.getName());
                sub.setDescription(subsidy.getDescription());
                List<EntSubsidies> subsidiesList = subsidiesList(sub);
                if (subsidiesList != null && !subsidiesList.isEmpty()) {
                    info = "Advertencia : Ya existe un registro con los datos ingresados";
                    return info;
                }
                info = dao.insertSubsidy(conexion, subsidy);
            }
        } else {
            info = "Advertencia : " + info;
        }
        
        return info;
    }
    
    private String validateSubsidy(EntSubsidies subsidy){
        String info = "";
        
        if (subsidy.getName() == null || subsidy.getName().isEmpty()) {
            info += "<br> * Debe ingresar un nombre para el subsidio.";
        }
        if (subsidy.getDescription() == null || subsidy.getDescription().isEmpty()) {
            info += "<br> * Por favor agrege una descripción para el subsidio que desea guardar.";
        }
        if (subsidy.getStartDate() == null) {
            info += "<br> * Ingrese fecha en que comenzará a aplicar del subsidio.";
        }
        if (subsidy.getEndDate() == null) {
            info += "<br> * Ingrese fecha en que finaliza la asignación del subsidio.";
        }
        if (subsidy.getExpectedEnergyValue() == null) {
            info += "<br> * Debe ingresar un consumo de agua esperado.";
        }
        if (subsidy.getExpectedNaturalGasValue() == null) {
            info += "<br> * Debe ingresar un consumo de gas natural esperado.";
        }
        if (subsidy.getExpectedWaterValue() == null) {
            info += "<br> * Debe ingresar un consumo de agua esperado.";
        }
        if (subsidy.getType() <= 0) {
            info += "<br> * Por favor selecciones un tipo de subsidio.";
        }
        
        return info;
    }
    
}
