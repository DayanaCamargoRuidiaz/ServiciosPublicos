/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class EntUsuario {

    private String userName;  
    private String password;
    private String idProfile;

    public EntUsuario(String userName, String password, String idProfile) {
        this.userName = userName;
        this.password = password;
        this.idProfile = idProfile;
    }

    public EntUsuario(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public EntUsuario(String userName) {
        this.userName = userName;
    }
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(String idProfile) {
        this.idProfile = idProfile;
    }
    
}
