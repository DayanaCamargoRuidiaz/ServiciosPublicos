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
    <script src="jsOP/saverespOP.js"></script>  

    <body>
        <!-- Header -->
        <header class="w3-container w3-teal w3-padding" id="myHeader">
            <a href="indexOP.jsp" class="hoverable"><button class="w3-btn w3-xlarge w3-theme-dark w3-hover-teal"><span class="icon-arrow-left"> </span>
                </button></a>
            <div class="w3-center">
                <h4>SERVICIOS PUBLICOS</h4>
                <h1 class="w3-xxxlarge w3-animate-bottom">GESTIÓN DE RESPONSABLES DEL HOGAR</h1>
                <div class="w3-padding-32">
                    <button id="btnPe" class="w3-btn w3-xlarge w3-theme-dark w3-hover-teal" onclick="document.getElementById('person').style.display = 'block'" style="font-weight:900;">GESTIONAR RESPONSABLE</button>
                </div>
            </div>
        </header>
        <div id="person" class="w3-modal">
            <div class="w3-modal-content w3-card-4 w3-animate-top">
                <header class="w3-container w3-theme-l1"> 
                    <span onclick="document.getElementById('person').style.display = 'none'"
                          class="w3-button w3-display-topright">×</span>
                    <h2><center><strong>Registrar Responsable</strong></center></h2>
                </header>
                <div class="w3-padding">
                    <form action="../guardarPe" method="post" id="responsable">       
                        <div class="w3-section">  
                            <label>Nombre:</label>
                            <input class="w3-input" name="name" type="text" id="name" placeholder="Nombre..">
                        </div>
                        <div class="w3-section">
                            <label>Apellidos:</label>
                            <input class="w3-input" name="lastName" type="text" id="lastName" placeholder="Apellidos..">
                        </div>
                        <div class="w3-section">
                            <label>Documento:</label>
                            <input class="w3-input" name="documentNumber" type="text" id="documentNumber" placeholder="Documento..">
                        </div>
                        <div class="w3-section">
                            <label>Correo electronico:</label>
                            <input class="w3-input" name="email" type="text" id="email" placeholder="alguien@example.com">
                        </div>
                        <br>  
                        <div class="w3-section">
                            <button type="submit" id="btnR" class="w3-btn w3-theme w3-block" style="size: 500;">Registrar</button>
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
                        <th>Cód.Responsable</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Número documento</th>
                        <th>Email</th>
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
                                    rs = sta.executeQuery("select * from person");

                                    while (rs.next()) {
                            %>
                    <tr>
                        <td id="id_person"><%=rs.getString(1)%></td>
                        <td><%=rs.getString(2)%></td>
                        <td><%=rs.getString(3)%></td>
                        <td><%=rs.getString(4)%></td>
                        <td><%=rs.getString(5)%></td>
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