package Bussines;

import Entidades.EntSubsidiesType;
import Persistencia.DaosSubsidiesType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import utilidades.Conexion;

/**
 * @author Josef
 */
public class SubsidyTypeBussines {
    
    DaosSubsidiesType dao;
    Connection conexion;

    public SubsidyTypeBussines() {
        dao = new DaosSubsidiesType();
    }

    public List<EntSubsidiesType> subsidiesTypeList (EntSubsidiesType subsidiestype) throws SQLException {
        try {
            conexion = Conexion.getCon();
            return (List<EntSubsidiesType>) dao.subsidiesTypeList(conexion, subsidiestype);
        } catch (Exception e) {
            System.out.println("Error obteniendo listado de tipos de subsidios : " + e.getMessage());
            return null;
        }
    }

    public String deleteSubsidyType(String IdsubsidyTypes) throws SQLException {
        if (IdsubsidyTypes == null || IdsubsidyTypes.isEmpty()) {
            return "Advertencia : Por favor seleccione el tipo de subsidio que desea eliminar.";
        }
        conexion = Conexion.getCon();
        return dao.deleteSubsidyType(conexion, Integer.parseInt(IdsubsidyTypes));
    }
    
    public String saveSubsidyType(EntSubsidiesType subsidyType) throws Exception {
        String info = validateSubsidyType(subsidyType);
        if (info.isEmpty()) {
            conexion = Conexion.getCon();
            if (subsidyType.getIdsubsidyTypes()> 0) {
                info = dao.updateSubsidyType(conexion, subsidyType);
            } else {
                EntSubsidiesType subtype = new EntSubsidiesType();
                subtype.setNombre(subsidyType.getNombre());
                subtype.setDescripcion(subsidyType.getDescripcion());
                List<EntSubsidiesType> subsidiesTypeList = subsidiesTypeList(subtype);
                if (subsidiesTypeList != null && !subsidiesTypeList.isEmpty()) {
                    info = "Advertencia : Ya existe un registro con los datos ingresados";
                    return info;
                }
                info = dao.insertSubsidyType(conexion, subsidyType);
            }
        } else {
            info = "Advertencia : " + info;
        }
        
        return info;
    }
    
    private String validateSubsidyType(EntSubsidiesType subsidyType){
        String info = "";
        
        if (subsidyType.getNombre() == null || subsidyType.getNombre().isEmpty()) {
            info += "<br> * Debe ingresar un nombre para el tipo de subsidio.";
        }
        if (subsidyType.getDescripcion() == null || subsidyType.getDescripcion().isEmpty()) {
            info += "<br> * Por favor agrege una descripción para el tipo de subsidio que desea guardar.";
        }
        if (subsidyType.getValueAtDiscretion()== null) {
            info += "<br> * Debe ingresar un valor.";
        }
        
        return info;
    }
    
}
