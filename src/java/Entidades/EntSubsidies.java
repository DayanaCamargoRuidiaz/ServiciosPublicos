package Entidades;

import java.sql.Date;


/**
 * @author Jeison González  Cifuentes
 */

public class EntSubsidies {
    private int idSybsudy; 
    private Date startDate;
    private Date endDate;
    private String name; 
    private String description;
    private Double expectedWaterValue;
    private Double expectedEnergyValue; 
    private Double expectedNaturalGasValue;
    private int type;

    public EntSubsidies() {
    }

    public EntSubsidies(int idSybsudy, Date startDate, Date endDate, String name, String description, Double expectedWaterValue, Double expectedEnergyValue, Double expectedNaturalGasValue, int type) {
        this.idSybsudy = idSybsudy;
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.description = description;
        this.expectedWaterValue = expectedWaterValue;
        this.expectedEnergyValue = expectedEnergyValue;
        this.expectedNaturalGasValue = expectedNaturalGasValue;
        this.type = type;
    }

    public int getIdSybsudy() {
        return idSybsudy;
    }

    public void setIdSybsudy(int idSybsudy) {
        this.idSybsudy = idSybsudy;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getExpectedWaterValue() {
        return expectedWaterValue;
    }

    public void setExpectedWaterValue(Double expectedWaterValue) {
        this.expectedWaterValue = expectedWaterValue;
    }

    public Double getExpectedEnergyValue() {
        return expectedEnergyValue;
    }

    public void setExpectedEnergyValue(Double expectedEnergyValue) {
        this.expectedEnergyValue = expectedEnergyValue;
    }

    public Double getExpectedNaturalGasValue() {
        return expectedNaturalGasValue;
    }

    public void setExpectedNaturalGasValue(Double expectedNaturalGasValue) {
        this.expectedNaturalGasValue = expectedNaturalGasValue;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    
}
