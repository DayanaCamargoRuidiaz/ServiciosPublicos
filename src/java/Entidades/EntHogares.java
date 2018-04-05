package Entidades;

/**
 *
 * @author Juan Mesa
 */
public class EntHogares {
    
    private String idHome;
    private String address;
    private String landline;
    private String idPerson;

    public EntHogares() {
    }

    public EntHogares(String idHome,String address, String landline, String idPerson) {
        this.idHome = idHome;
        this.address = address;
        this.landline = landline;
        this.idPerson = idPerson;
    }
    public EntHogares(String address, String landline, String idPerson) {
        this.address = address;
        this.landline = landline;
        this.idPerson = idPerson;
    }

    public String getIdHome() {
        return idHome;
    }

    public void setIdHome(String idHome) {
        this.idHome = idHome;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    
}
