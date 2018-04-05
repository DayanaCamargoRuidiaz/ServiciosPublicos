<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@pageimport ="java.sql.Connection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Servicios publicos</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-teal.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="iconMoon/fonts/style.css">

    <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="js/jquery.validate.min.js"></script>
    <script src="./js/savehome.js"></script>  
    <script src="./js/deletehome.js"></script>
    <body>
        <!-- Header -->
        <header class="w3-container w3-teal w3-padding" id="myHeader">
            <a href="index.jsp" class="hoverable"><button class="w3-btn w3-xlarge w3-theme-dark w3-hover-teal"><span class="icon-arrow-left2"> </span>
                </button></a>
            <div class="w3-center">
                <div class="w3-padding-25" style="text-align: right;">
                </div>
                <h4>SERVICIOS PUBLICOS</h4>
                <h1 class="w3-xxxlarge w3-animate-bottom">GESTIÓN DE HOGARES</h1>
                <div class="w3-padding-32">
                    <button id="btnH" class="w3-btn w3-xlarge w3-theme-dark w3-hover-teal" onclick="document.getElementById('home').style.display = 'block'" style="font-weight:900;">GESTIONAR HOGAR</button>
                </div>
            </div>
        </header>

        <div id="home" class="w3-modal">  
            <div class="w3-modal-content w3-card-4 w3-animate-top">
                <header class="w3-container w3-theme-l1"> 
                    <span onclick="document.getElementById('home').style.display = 'none'"
                          class="w3-button w3-display-topright">×</span>
                    <h2><center><strong>Registrar Hogares</strong></center></h2>
                </header>
                <div class="w3-padding">
                    <form id="Hogares" name="Hogares" method="POST" action="./guardar">
                        <div class="w3-section">
                           <label>Dirección:</label>
                            <input type="text" class="w3-input" id="address" name="address" placeholder="Dirección.. " > 
                          <span class="icon-warning"> Ejemplo: "Cr 74 #37 sur 62 </span>
                        </div>
                        <div class="w3-section">
                            <label>Teléfono:</label>
                            <input type="text" class="w3-input" id="landline" name="landline" placeholder="Teléfono.." >
                        </div>
                        <div class="w3-section">
                            <label>Identificación del responsable:</label>
                            <input type="text" class="w3-input" id="idPerson" name="idPerson"placeholder="Identificación responsable.." >
                        </div>
                        <br>
                        <div class="w3-section" style="text-align: center;">
                            <button type="submit" id="btnG" name="action" class="w3-btn w3-theme w3-block" style="size:500;">Guardar</button>

                        </div>
                    </form>
                </div>
            </div>
        </div>

        <br><br>
        <div class="w3-container">
            <table class="w3-table w3-striped w3-bordered">
                <thead>
                    <tr class="w3-theme">
                        <th>Cód.Hogar</th>
                        <th>Dirreción</th>
                        <th>Teléfono</th>
                        <th>Identificación responsable</th>
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
                                    rs = sta.executeQuery("select * from home");

                                    while (rs.next()) {
                            %>
                    <tr>
                        <td id="id_home"><%=rs.getString(1)%></td>
                        <td><%=rs.getString(2)%></td>
                        <td><%=rs.getString(3)%></td>
                        <td><%=rs.getString(4)%></td>
                        <th><a href='modificar_hogar.jsp?id="<%=rs.getString(1)%>"'>Modificar</a>   <a id="btnE" href="">Eliminar</a></th>

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