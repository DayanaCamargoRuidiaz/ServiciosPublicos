<%-- 
    Document   : panel
    Created on : Nov 4, 2017, 8:38:18 PM
    Author     : User
--%>
<%@page import="Entidades.EntUsuario"%>
<%@page import="Persistencia.ControladorUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession sesion = request.getSession();

    String usuario = (String) sesion.getAttribute("userName");
     String perfil = (String) sesion.getAttribute("idProfile");
    if(sesion.getAttribute("userName") == null && sesion.getAttribute("idProfile") == null){
       response.getWriter().print("Por favor inicie sesión");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido <% out.println(usuario);%>  con perfil de <% out.println(perfil);%></h1>
        <div><a href ='cerrar'>Cerrar sesión</div>
    </body>
</html>
