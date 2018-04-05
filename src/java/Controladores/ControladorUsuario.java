/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.EntUsuario;
import Persistencia.DaoUsuario;

public class ControladorUsuario {

public boolean create(EntUsuario u){
    DaoUsuario du = new DaoUsuario();
    return du.registrarUsuario(u);
}    

public int validate(EntUsuario u){
    DaoUsuario du = new DaoUsuario();
    return du.autenticar(u);
}

/*public String getViewUser(EntUsuario u){
    String htmlcode = "";
    htmlcode = "<h2>Bienvenido "+ u.getUserName() +  " con perfil de " + u.getIdProfile() +"</h2>";
    htmlcode +="<div><a href =''>Cerrar sesión</div>";
    return htmlcode;
}*/

}
