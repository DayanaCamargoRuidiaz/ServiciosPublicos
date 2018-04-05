$(function () {
    $('#responsable').validate({
        rules: {
            name: {
                required: true
            },
            lastName: {
                required: true

            },
            documentNumber: {
                required: true
               
            },
            email: {
                required: true
               
            }
        },
        messages: {
            name: {
                required: "Este campo es obligatorio"
            },
            lastName: {
                required: "Este campo es obligatorio"
            },
            documentNumber: {
                required: "Este campo es obligatorio"
            },
            email: {
                required: "Este campo es obligatorio"
            }
         
        },
        submitHandler: function(form){
           //Funcion AJAX para registrar usuario
        
         var data = $("#responsable").serialize();
            $.post("../guardarPe", data, function(res, est, jqXHR){
                if(res == '1'){
                $("#name").val("");
                $("#lastName").val("");
                $("#documentNumber").val("");
                $("#email").val("");
                alert("El Respondable ha sido registrado correctamente");
                setTimeout(function (){
                  window.location = "personasOP.jsp";
                });
                }else{
                    alert("Error al registrar");
                }
        });
    }
    
    });
    });

