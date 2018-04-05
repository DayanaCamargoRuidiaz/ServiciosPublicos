

<%@page import="Entidades.EntUsuario"%>
<%@page import="Controladores.ControladorUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="css/bootstrap.min.css"type="text/css"></link>
         <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-teal.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"type="text/css"> </link><!--Iconos--> 
        <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500" rel="stylesheet"></link>
        <link rel="stylesheet" href="css/clogin.css"type="text/css"></link>

        <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="js/vallogin.js"></script>
        <script type="text/javascript" src="js/back.js"></script>

        <title>Iniciar sesión</title>

    </head>


  <body onload="nobackbutton();">
     
        <div class="my-content" >
            <div class="container" > 
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 myform-cont" >
                        <div class="myform-top">
                            <img src="imagenes/userP.png" alt="Avatar" class="avatar">    
                            <div class="myform-top-left">
                                <h3>Iniciar sesión</h3>
                            </div>
                        </div>
                        <div class="myform-bottom">
                            <form action="./iniciar" method="post" class="" id="form_inicio" >
                                <div class="form-group">
                                    <input type="text" name="usuario" placeholder="Usuario..." class="form-control" id="userName">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="pass" placeholder="Contraseña..." class="form-control" id="password">
                                </div>
                                <button type="submit" class="mybtn" name="btnI" id="btnI">Entrar</button>
                            </form>

                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>

</body>

</html>