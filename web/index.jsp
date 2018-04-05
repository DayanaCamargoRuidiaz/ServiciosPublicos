
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session= "true" %>
<%
    HttpSession sesion = request.getSession();

    String user = (String) sesion.getAttribute("userName");
     String perfil = (String) sesion.getAttribute("idProfile");
    if(sesion.getAttribute("userName") == null && sesion.getAttribute("idProfile") == null){
       out.print("<script>location.replace('login.jsp');</script>");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Servicios publicos</title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-teal.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="iconMoon/fonts/style.css">
        
        <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="js/indexval.js"></script>
    </head>

    <body>

        <!-- Side Navigation -->
        <nav class="w3-sidebar w3-bar-block w3-card-2 w3-animate-left w3-center" style="display:none" id="mySidebar">

             <h1 class="w3-text-theme"><% out.println(user);%> </h1>
            <h3 class="w3-text-theme"> <%  out.println(perfil);%></h3>
            <button class="w3-bar-item w3-button" onclick="w3_close()">Cerrar <i class="fa fa-remove"></i></button>
            <a href="ciclos_consumo.jsp" class="w3-bar-item w3-button">Ciclos de consumo</a>
            <a href="SubsidyType.jsp" class="w3-bar-item w3-button">Tipo de subsidio</a>
        </nav>


        <!-- Header -->
        <header class="w3-container w3-teal w3-padding" id="myHeader">

            <i onclick="w3_open()" class="fa fa-bars w3-xlarge w3-button w3-teal"></i>
            <div class="w3-center">
                <div class="w3-padding-25" style="text-align: right;">
                  <button class="w3-btn w3-theme-dark w3-hover-teal" onclick="document.getElementById('register').style.display = 'block'"> <span class="icon-user-plus"> Registrar personal</span></button> 
                    <button class="w3-btn w3-theme-dark w3-hover-teal" onclick="document.getElementById('logout').style.display = 'block'"><span class="icon-exit"> Cerrar sesión</span></button>
                </div>
                <h1 id ="sv" class="w3-xxxlarge w3-animate-bottom">SERVICIOS PÚBLICOS</h1>
            </div>
        </header>

        <!-- Modal registrarse-->
        <div id="register" class="w3-modal">
            <div class="w3-modal-content w3-card-4 w3-animate-top">
                <header class="w3-container w3-theme-l1"> 
                    <span onclick="document.getElementById('register').style.display = 'none'" class="w3-button w3-display-topright">×</span>
                    <h2><center><strong><span class="icon-user-plus"> Registrar personal</span></strong></center></h2>
                </header>
                <div class="w3-padding">
                    <form action="./registrar" method="post" id="form_registro">       
                        <div class="w3-section">   
                            <label>Usuario:</label>
                            <input class="w3-input" name="usuario" type="text" id="userName" placeholder="Usuario..">                         
                        </div>
                        <div class="w3-section">
                            <label>Contraseña:</label>
                            <input class="w3-input" name="pass" type="password" id="password" placeholder="Contraseña..">
                        </div>
                        <div class="w3-section">
                            <label>Confimar contraseña:</label>
                            <input class="w3-input" name="pass2" type="password" id="password2" placeholder="Confirmar contraseña..">
                        </div>
                        <div class="w3-section">     
                            <label>Seleciona el perfil de usuario:</label>
                            <select name="perfil" id="idProfile" class="w3-select">
                                <option value="1">Administrador</option>
                                <option value="2">Operador</option>
                            </select>
                        </div>  
                        <br>  
                        <div class="w3-section">
                            <button type="submit" id="btnR" class="w3-btn w3-theme w3-block" style="size: 500;">Registrarse</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Modal cerrar sesion-->
        <div id="logout" class="w3-modal">
            <div class="w3-modal-content w3-card-4 w3-animate-top">
                <header class="w3-container w3-theme-l1"> 
                    <span onclick="document.getElementById('logout').style.display = 'none'"
                          class="w3-button w3-display-topright">×</span>
                    <h2><span class="icon-exit">Cerrar sesión</span></h2>
                </header>
                <div class="w3-padding">
                    <p>¿Relamente desea cerrar la sesión?</p>
                    <form>
                        <br>  
                        <div class="w3-section">
                            <a href ='cerrar' class="w3-btn w3-theme w3-block">Aceptar</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!--Menu formularios-->
        <div class="w3-row-padding w3-center w3-margin-top">
            <div class="w3-third">
                <div class="w3-card-2 w3-container" style="min-height:460px">
                    <h2>Hogares</h2><br>
                    <i class="fa fa-desktop w3-margin-bottom w3-text-theme" style="font-size:120px"></i>
                    <p>Organiza los datos de los hogares en el sistema</p>
                    <br><br><br><br><br>
                    <a href="./Hogares.jsp"><button class="w3-btn w3-theme">Entrar</button></a>
                </div>
            </div>

            <div class="w3-third">
                <div class="w3-card-2 w3-container" style="min-height:460px">
                    <h2>Consumos</h2><br>
                    <i class="fa fa-css3 w3-margin-bottom w3-text-theme" style="font-size:120px"></i>
                    <p>Registra el valor de los consumos del hogar</p>
                    <br><br><br><br><br>
                    <a href="Consumos.jsp"><button class="w3-btn w3-theme">Entrar</button></a>
                </div>
            </div>

            <div class="w3-third">
                <div class="w3-card-2 w3-container" style="min-height:460px">
                    <h2>Subsidios</h2><br>
                    <i class="fa fa-diamond w3-margin-bottom w3-text-theme" style="font-size:120px"></i>
                    <p>Calcula si un hogar puede reclamar el beneficio</p>
                    <br><br><br><br><br>
                    <a href="Subsidy.jsp"><button class="w3-btn w3-theme">Entrar</button></a>
                </div>
            </div>

            <div class="w3-third">
                <div class="w3-card-2 w3-container" style="min-height:460px">
                    <h2>Informes</h2><br>
                    <i class="fa fa-diamond w3-margin-bottom w3-text-theme" style="font-size:120px"></i>
                    <p>Visualiza informes con la informacion de los hogares</p>
                    <br><br><br><br><br>
                    <a href="ReportServlet"><button class="w3-btn w3-theme">Entrar</button></a>
                </div>
            </div>
            
            <div class="w3-third">
                <div class="w3-card-2 w3-container" style="min-height:460px">
                    <h2>Responsable del hogar</h2><br>
                    <i class="fa fa-diamond w3-margin-bottom w3-text-theme" style="font-size:120px"></i>
                    <p>Registra los encargados de los hogares</p>
                    <br><br><br><br><br>
                    <a href="personas.jsp"><button class="w3-btn w3-theme">Entrar</button></a>
                </div>
            </div>

            <script src="js/menu.js"></script>   
    </body>
</html>