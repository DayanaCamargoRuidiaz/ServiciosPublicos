package Persistencia;

import Entidades.EntSubsidiesType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Josef
 */
public class DaosSubsidiesType {

    public String deleteSubsidyType(Connection conection, int IdsubsidyTypes) {
        String info = "";
        try {
            PreparedStatement stm = conection.prepareStatement(SQLHelpers.deleteSubsidyType(IdsubsidyTypes));
            stm.execute();
            info = "¡¡Bien!! : Registro borrado exitosamente";
        } catch (Exception e) {
            info = "Error intentando borrar el tipo de subsidio con código : " + IdsubsidyTypes;
            System.out.println("Error intentando borrar el tipo de subsidio con código : " + IdsubsidyTypes + "\n Error : " + e.getMessage());
        }
        return info;
    }
    
    public List<EntSubsidiesType> subsidiesTypeList(Connection conexion, EntSubsidiesType subsidiestype) {
        List<EntSubsidiesType> list = new ArrayList<>();
        try {
            PreparedStatement stm = conexion.prepareStatement(
                    SQLHelpers.getSubsidyType(subsidiestype.getIdsubsidyTypes(), subsidiestype.getNombre(), subsidiestype.getDescripcion(), subsidiestype.getValueAtDiscretion()));
            ResultSet rc = stm.executeQuery();
            while (rc.next()) {
                EntSubsidiesType subsidytype = new EntSubsidiesType();
                subsidytype.setIdsubsidyTypes(rc.getInt(1));
                subsidytype.setNombre(rc.getString(2));
                subsidytype.setDescripcion(rc.getString(3));
                subsidytype.setValueAtDiscretion(rc.getDouble(4));
                list.add(subsidytype);
            }
        } catch (Exception e) {
            System.out.println("Error en DaoSubsidiesType / subsidiesTypeList : " + e.getMessage());
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
                info = "¡¡Bien!! : Tipo de Subsidio '" + subsidyType.getNombre() + "' guardado exitosamente";
            } else {
                info = "Error intentando guardar el tipo de subsidio : " + subsidyType.getNombre();
            }
        } catch (Exception e) {
            System.out.println("Error intentando guardar tipo de subsidio : " + e.getMessage());
        }
        return info;
    }

    public String updateSubsidyType(Connection conexion, EntSubsidiesType subsidyType) {
        String info = "";
        try {
            PreparedStatement stm = conexion.prepareStatement(SQLHelpers.updateSubsidy());
            stm.setString(1, subsidyType.getNombre());
            stm.setString(2, subsidyType.getDescripcion());
            stm.setDouble(3, subsidyType.getValueAtDiscretion());
            stm.setInt(4, subsidyType.getIdsubsidyTypes());
            stm.execute();
            if (stm.getUpdateCount() > 0) {
                info = "¡¡Bien!! : Tipo de Subsidio '" + subsidyType.getNombre() + "' editado exitosamente";
            } else {
                info = "Error intentando editar el tipo de subsidio : " + subsidyType.getNombre();
            }
        } catch (Exception e) {
            System.out.println("Error intentando guardar tipo de subsidio : " + e.getMessage());
        }
        return info;
    }
}
