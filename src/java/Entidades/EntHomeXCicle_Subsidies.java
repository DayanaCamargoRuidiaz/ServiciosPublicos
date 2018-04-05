package Entidades;

import java.sql.Date;

/**
 * @author Jeison González Cifuentes
 * Todos los derechos reservados , hijos de perra
 * Jajajajja , bueno no. :P
 */

public class EntHomeXCicle_Subsidies {
    private int idHomeXcycle;
    private int idSubsidy;
    private int idCycle;
    private Date assignmentDate;
    private Double waterValueObtained;
    private Double energyValueObtained; 
    private Double naturalGasValueObtained;

    public EntHomeXCicle_Subsidies(int idHomeXcycle, int idSubsidy, int idCycle, Date assignmentDate, Double waterValueObtained, Double energyValueObtained, Double naturalGasValueObtained) {
        this.idHomeXcycle = idHomeXcycle;
        this.idSubsidy = idSubsidy;
        this.idCycle = idCycle;
        this.assignmentDate = assignmentDate;
        this.waterValueObtained = waterValueObtained;
        this.energyValueObtained = energyValueObtained;
        this.naturalGasValueObtained = naturalGasValueObtained;
    }

    public EntHomeXCicle_Subsidies() {
    }

    public int getIdHomeXcycle() {
        return idHomeXcycle;
    }

    public void setIdHomeXcycle(int idHomeXcycle) {
        this.idHomeXcycle = idHomeXcycle;
    }

    public int getIdSubsidy() {
        return idSubsidy;
    }

    public void setIdSubsidy(int idSubsidy) {
        this.idSubsidy = idSubsidy;
    }

    public int getIdCycle() {
        return idCycle;
    }

    public void setIdCycle(int idCycle) {
        this.idCycle = idCycle;
    }

    public Date getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public Double getWaterValueObtained() {
        return waterValueObtained;
    }

    public void setWaterValueObtained(Double waterValueObtained) {
        this.waterValueObtained = waterValueObtained;
    }

    public Double getEnergyValueObtained() {
        return energyValueObtained;
    }

    public void setEnergyValueObtained(Double energyValueObtained) {
        this.energyValueObtained = energyValueObtained;
    }

    public Double getNaturalGasValueObtained() {
        return naturalGasValueObtained;
    }

    public void setNaturalGasValueObtained(Double naturalGasValueObtained) {
        this.naturalGasValueObtained = naturalGasValueObtained;
    }

    
    
}
