
$(function () {
    $('#form_inicio').validate({
        rules: {
            usuario: {
                required: true
            },
            pass: {
                required: true
            }
        },
        messages: {
            usuario: {
                required: "Por favor ingrese su nombre de usuario"
            },
            pass: {
                required: "Por favoras ingrese su contraseña"
            }
        },
        submitHandler: function(form){
            
             var data = $("#form_inicio").serialize();
           $.post("./iniciar", data, function(res, est, jqXHR){
                if(res == '1'){
                   alert("Sesion iniciada como administrador, pulse aceptar para ser redireccionado a la pagina principal");
                   setTimeout(function(){
                       window.location = "index.jsp";
                   },100);
               } else if(res == '2'){
                   alert("Sesion iniciada como operador, pulse aceptar para ser redireccionado a la pagina principal");
                setTimeout(function(){
                       window.location = "indexOP.jsp";
                   },100); 
               }else{
                   alert("Usuario incorrecto");
               }
                
            });
            
    }
    
    });
    
    });
