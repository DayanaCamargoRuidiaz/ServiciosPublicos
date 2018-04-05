package Entidades;

import java.sql.Date;

/**
 * @author Josef
 */

public class EntReport {
    private int idHome;
    private int idSubsidy;
    private int idCycle;
    private Date assignmentDate;
    private Double waterValueObtained;
    private Double energyValueObtained; 
    private Double naturalGasValueObtained;
    private Double water;
    private Double electricity;
    private Double naturalGas;

    public EntReport(int idHome, int idSubsidy, int idCycle, Date assignmentDate, Double waterValueObtained, Double energyValueObtained, Double naturalGasValueObtained, Double water, Double electricity, Double naturalGas) {
        this.idHome = idHome;
        this.idSubsidy = idSubsidy;
        this.idCycle = idCycle;
        this.assignmentDate = assignmentDate;
        this.waterValueObtained = waterValueObtained;
        this.energyValueObtained = energyValueObtained;
        this.naturalGasValueObtained = naturalGasValueObtained;
        this.water = water;
        this.electricity = electricity;
        this.naturalGas = naturalGas;
    }

    public EntReport() {
    }

    public Double getWater() {
        return water;
    }

    public void setWater(Double water) {
        this.water = water;
    }

    public Double getElectricity() {
        return electricity;
    }

    public void setElectricity(Double electricity) {
        this.electricity = electricity;
    }

    public Double getNaturalGas() {
        return naturalGas;
    }

    public void setNaturalGas(Double naturalGas) {
        this.naturalGas = naturalGas;
    }

    public int getIdHome() {
        return idHome;
    }

    public void setIdHome(int idHomeXcycle) {
        this.idHome = idHomeXcycle;
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
