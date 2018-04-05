<%-- 
    Document   : modificar
    Created on : Nov 19, 2017, 3:54:29 PM
    Author     : User
--%>

<%@page import="Controladores.ControladorHogares"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-teal.css">
        <title>Modificar Hogar</title>
    </head>
    <body>
        <% 
        ControladorHogares ch = new ControladorHogares();
        String idHome = request.getParameter("id");
        %>
        </header>         
        <div id="home" class="w3-padding" w3-teal w3-padding> 
            <div class="w3-modal-content w3-card-4 w3-animate-top">
                <header class="w3-container w3-theme"> 
                    <h2><center><strong>Modificar Hogar</strong></center></h2>
                </header>   
        
       <div class="w3-padding">
                    <form id="Hogares" name="Hogares" method="POST" action="./guardar">
                        <div class="w3-section">
                            <input type="text" class="w3-input" id="idHome" name="idHome" >
                            <label for="id">Identificador</label>
                           </div>
                        <div class="w3-section">
                            <input type="text" class="w3-input" id="address" name="address" >
                            <label for="address">Dirección</label>
                        </div>
                        <div class="w3-section">
                            <input type="text" class="w3-input" id="landline" name="landline" >
                            <label for="telephone">Teléfono</label>
                            <div id="valTel" class="oculto" style="background-color: #E85F5F;">
                        </div>
                        <div class="w3-section">
                            <input type="text" class="w3-input" id="idPerson" name="idPerson">
                            <label for="idResponsable">identificación responsable</labe>
                        </div>
                        <br>
                        <div class="w3-section" style="text-align: center;">
                      <button type="submit" id="btnG" name="action" class="w3-btn w3-theme w3-block" style="size:500;">Guardar</button>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
    </body>
</html>
