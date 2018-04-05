<%-- 
    Document   : Consumos
    Created on : 06-nov-2017, 18:45:59
    Author     : Juan Mesa
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@pageimport ="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consumos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-teal.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="iconMoon/fonts/style.css">
        
        <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <script src="./js/saveconsumo.js"></script>  
        <script src="./js/deleteconsumo.js"></script>
    </head>

    <!-- Header -->
    <header class="w3-container w3-teal w3-padding" id="myHeader">
        <a href="index.jsp" class="hoverable"><button class="w3-btn w3-xlarge w3-theme-dark w3-hover-teal"><span class="icon-arrow-left2"> </span>
                </button></a>
        <div class="w3-center">
            <h4>SERVICIOS PUBLICOS</h4>
            <h1 class="w3-xxxlarge w3-animate-bottom">GESTIÓN DE CONSUMO</h1>
            <div class="w3-padding-32">
                <button id="btnCo" class="w3-btn w3-xlarge w3-theme-dark w3-hover-teal" onclick="document.getElementById('consumo').style.display = 'block'" style="font-weight:900;">GESTIONAR CONSUMOS</button>
            </div>
        </div>
    </header>
    <div id="consumo" class="w3-modal">
        <div class="w3-modal-content w3-card-4 w3-animate-top">
            <header class="w3-container w3-theme-l1"> 
                <span onclick="document.getElementById('consumo').style.display = 'none'"
                      class="w3-button w3-display-topright">×</span>
               <h2><center><strong>Consumos</strong></center></h2>
            </header>
            <div class="w3-padding">
                <form id="Consumos" name="Consumos" method="POST" action="./guardarco">
                    <div class="w3-section">
                        <label>Identificador del hogar:</label>
                        <input type="text" class="w3-input" id="idHome" name="idHome" placeholder="Identificador hogar.." >
                    </div>
                    <div class="w3-section">
                        <label>Identificador del ciclo:</label>
                        <input type="text" class="w3-input" id="idCycle" name="idCycle" placeholder="Identificador ciclo.." >
                    </div>
                    <div class="w3-section">
                         <label>Consumo de electricidad:</label>
                        <input type="text" class="w3-input" id="electricity" name="electricity" placeholder="Consumo de electricidad.." >
                    </div>
                    <div class="w3-section">
                         <label>Consumo de agua:</label>
                        <input type="text" class="w3-input" id="water" name="water" placeholder="Consumo de agua.." >
                    </div>
                    <div class="w3-section">
                         <label>Consumo de gas natural:</label>
                        <input type="text" class="w3-input" id="naturalGas" name="naturalGas" placeholder="Consumo de gas natural.." >
                    </div>
                    <br>
                    <div class="w3-section" style="text-align: center;">
                        <button type="submit" id="btnG" name="action" class="w3-btn w3-theme w3-block" style="size:500;">Guardar</button>

                    </div>
                </form>
            </div>
        </div>
    </div>
    <br>
    <br><br>
    <div class="w3-container">
        <table class="w3-table w3-striped w3-bordered">
            <thead>
                <tr class="w3-theme">
                    <th>Cód. Hogar</th>
                    <th>Ciclo</th>
                    <th>Electricidad</th>
                    <th>Agua</th>
                    <th>Gas natural</th>
                    <th>Acciones</th>
                        <%

                            Connection conectar = null;
                            Statement sta = null;
                            ResultSet rs = null;

                            try {
                                String url = "jdbc:mysql://localhost/serviciospublicos";
                                String usuario = "root";
                                String contraseña = "";
                                Class.forName("com.mysql.jdbc.Driver");
                                conectar = DriverManager.getConnection(url, usuario, contraseña);

                                sta = conectar.createStatement();
                                rs = sta.executeQuery("select * from home_x_cycle");

                                while (rs.next()) {
                        %>
                <tr>
                    <td id="id_home"><%=rs.getString(1)%></td>
                    <td><%=rs.getString(2)%></td>
                    <td><%=rs.getString(3)%></td>
                    <td><%=rs.getString(4)%></td>
                    <td><%=rs.getString(5)%></td>
                    <th><a href='modificar_consumo.jsp?id="<%=rs.getString(1)%>"'>Modificar</a>   <a id="btnE" href="">Eliminar</a></th>
                </tr>


                </tr>

                <%

                        }
                        sta.close();
                        rs.close();
                        conectar.close();

                    } catch (Exception e) {
                    }

                %>

                </tr>

                </div>
                </body>
                </html>
