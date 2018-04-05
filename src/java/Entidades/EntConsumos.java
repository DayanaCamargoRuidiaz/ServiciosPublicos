package Entidades;

/**
 *
 * @author Juan Mesa
 */
public class EntConsumos {
    
    private String idHome;
    private String idCycle;
    private String electricity;
    private String water;
    private String naturalGas;

    public EntConsumos() {
    }

    public EntConsumos(String idHome, String idCycle, String electricity, String water, String naturalGas) {
        this.idHome = idHome;
        this.idCycle = idCycle;
        this.electricity = electricity;
        this.water = water;
        this.naturalGas = naturalGas;
    }
    
     public EntConsumos(String electricity, String water, String naturalGas) {
        this.electricity = electricity;
        this.water = water;
        this.naturalGas = naturalGas;
    }

    public String getIdHome() {
        return idHome;
    }

    public void setIdHome(String idHome) {
        this.idHome = idHome;
    }

    public String getIdCycle() {
        return idCycle;
    }

    public void setIdCycle(String idCycle) {
        this.idCycle = idCycle;
    }

    public String getElectricity() {
        return electricity;
    }

    public void setElectricity(String electricity) {
        this.electricity = electricity;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getNaturalGas() {
        return naturalGas;
    }

    public void setNaturalGas(String naturalGas) {
        this.naturalGas = naturalGas;
    }
    
}
