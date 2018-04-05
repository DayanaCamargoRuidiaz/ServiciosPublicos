package Entidades;

/**
 *
 * @author Jose
 */
public class EntSubsidiesType {
     private int idsubsidyTypes;
    private String nombre; 
    private String descripcion;
    private Double valueAtDiscretion;
    
      public EntSubsidiesType() {
    }

    public EntSubsidiesType(int idsubsidyTypes, String nombre, String descripcion, Double valueAtDiscretion) {
        this.idsubsidyTypes = idsubsidyTypes;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valueAtDiscretion = valueAtDiscretion;
    }

    public int getIdsubsidyTypes() {
        return idsubsidyTypes;
    }

    public void setIdsubsidyTypes(int idsubsidyTypes) {
        this.idsubsidyTypes = idsubsidyTypes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValueAtDiscretion() {
        return valueAtDiscretion;
    }

    public void setValueAtDiscretion(Double valueAtDiscretion) {
        this.valueAtDiscretion = valueAtDiscretion;
    }
    
}