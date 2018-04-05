package Persistencia;

import Entidades.EntSubsidiesType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jose
 */
public class DaosSubsidiesTypes {
  
     public String deleteSubsidyType(Connection conection, int id_subsidyTypes) {
        String info = "";
        try {
            PreparedStatement stm = conection.prepareStatement(SQLHelpers.deleteSubsidyType(id_subsidyTypes));
            stm.execute();
            info = "Registro borrado exitosamente";
        } catch (Exception e) {
            info = "Error intentando borrar el tipo de subsidio con código : " + id_subsidyTypes;
            System.out.println("Error intentando borrar el tipo de subsidio con código : " + id_subsidyTypes + "\n Error : " + e.getMessage());
        }
        return info;
    }
     
      public List<EntSubsidiesType> subsidiesTypeList(Connection conexion, EntSubsidiesType subsidiesType) {
        List<EntSubsidiesType> list = new ArrayList<>();
        try {
            PreparedStatement stm = conexion.prepareStatement(
                    SQLHelpers.getSubsidyType(subsidiesType.getIdsubsidyTypes(), subsidiesType.getNombre(),
                                              subsidiesType.getDescripcion(), subsidiesType.getValueAtDiscretion()));
            ResultSet rc = stm.executeQuery();
            while (rc.next()) {
                EntSubsidiesType subsidiesTypes = new EntSubsidiesType();
                subsidiesTypes.setIdsubsidyTypes(rc.getInt(1));
                subsidiesTypes.setNombre(rc.getString(2));
                subsidiesTypes.setDescripcion(rc.getString(3));
                subsidiesTypes.setValueAtDiscretion(rc.getDouble(4));
                list.add(subsidiesTypes);
            }
        } catch (Exception e) {
            System.out.println("Error en DaoSubsidiesTypes / subsidiesTypeList : " + e.getMessage());
        }
        return list;
    }

    public String insertSubsidyType(Connection conexion, EntSubsidiesType subsidyType) {
        String info = "";
        try {
            PreparedStatement stm = conexion.prepareStatement(SQLHelpers.insertSubsidyType());
            stm.setInt(1, subsidyType.getIdsubsidyTypes());
            stm.setString(2, subsidyType.getNombre());
            stm.setString(3, subsidyType.getDescripcion());
            stm.setDouble(4, subsidyType.getValueAtDiscretion());
            stm.execute();
            if (stm.getUpdateCount() > 0) {
                info = "Tipo de Subsidio '" + subsidyType.getNombre()+ "' guardado exitosamente";
            } else {
                info = "Error intentando guardar el tipo de subsidio : " + subsidyType.getNombre();
            }
        } catch (Exception e) {
            System.out.println("Error intentando guardar el tipo de subsidio : " + e.getMessage());
        }
        return info;
    }

    public String updateSubsidyType(Connection conexion, EntSubsidiesType subsidyType) {
        String info = "";
        try {
            PreparedStatement stm = conexion.prepareStatement(SQLHelpers.updateSubsidyType());
            stm.setString(1, subsidyType.getNombre());
            stm.setString(2, subsidyType.getDescripcion());
            stm.setDouble(3, subsidyType.getValueAtDiscretion());
            stm.execute();
            if (stm.getUpdateCount() > 0) {
                info = "Tipo de Subsidio '" + subsidyType.getNombre() + "' editado exitosamente";
            } else {
                info = "Error intentando editar el tipo de subsidio : " + subsidyType.getNombre();
            }
        } catch (Exception e) {
            System.out.println("Error intentando editar el tipo subsidio : " + e.getMessage());
        }
        return info;
    }
}