$(function () {
    $('#Hogares').validate({
        rules: {
            idHome: {
                required: true
            },
            address: {
                required: true

            },
            landline: {
                required: true
               
            },
            idPerson: {
                required: true
               
            }
        },
        messages: {
            idHome: {
                required: "Este campo es obligatorio"
            },
            address: {
                required: "Este campo es obligatorio"
            },
            landline: {
                required: "Este campo es obligatorio"
            },
            idPerson: {
                required: "Este campo es obligatorio"
            }
         
        },
        submitHandler: function(form){
           //Funcion AJAX para registrar usuario
        
         var data = $("#Hogares").serialize();
            $.post("guardar", data, function(res, est, jqXHR){
                if(res == '1'){
                $("#idHome").val("");
                $("#address").val("");
                $("#landline").val("");
                $("#idPerson").val("");
                alert("El Hogar ha sido registrado correctamente");
                setTimeout(function (){
                  window.location = "Hogares.jsp";
                });
                }else{
                    alert("Error al registrar");
                }
        });
    }
    
    });
    });

