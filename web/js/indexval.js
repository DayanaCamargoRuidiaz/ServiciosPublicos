
$(function () {
    
    $('#form_registro').validate({
        rules: {
            usuario: {
                required: true
            },
            pass: {
                required: true,
                minlength: 8,
                maxlength: 10
            },
            pass2: {
                required: true,
                minlength: 8,
                maxlength: 10,
                equalTo: "#password"
            },
            perfil:{
            required: true
            }
        },
        messages: {
            usuario: {
                required: "Este campo es obligatorio"
            },
            pass: {
                required: "Este campo es obligatorio",
                minlength: "La contraseña debe tener minimo 8 caracteres",
                maxlength: "La contraseña deber tener maximo 10 caracteres"
            },
            pass2: {
                required: "Este campo es obligatorio",
                equalTo:  "Las contraseñas no coinciden",
                minlength: "La contraseña debe tener minimo 8 caracteres",
                maxlength: "La contraseña deber tener maximo 10 caracteres"
            }
         
        },
        submitHandler: function(form){
           //Funcion AJAX para registrar usuario
        
         var data = $("#form_registro").serialize();
            $.post("./registrar", data, function(res, est, jqXHR){
                if(res == '1'){
                $("#userName").val("");
                $("#password").val("");
                $("#password2").val("");
                $("#idProfile").val("");
                alert("Registro correcto");
                setTimeout(function (){
                  window.location = "index.jsp";
                });
                }else{
                    alert("Error al registrar");
                }
        });
    }
    
    });
    
    
});
