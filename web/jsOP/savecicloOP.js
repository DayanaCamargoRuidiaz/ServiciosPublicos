$(function () {
    $('#form_ciclos').validate({
        rules: {
            nombre: {
                required: true
            },
            fecha_inicio: {
                required: true

            },
            fecha_final: {
                required: true
               
            }
        },
        messages: {
            nombre: {
                required: "Este campo es obligatorio"
            },
            fecha_inicio: {
                required: "Este campo es obligatorio"
            },
            fecha_final: {
                required: "Este campo es obligatorio"
            }
         
        },
        submitHandler: function(form){
           //Funcion AJAX para registrar usuario
        
         var data = $("#form_ciclos").serialize();
            $.post("../ciclos", data, function(res, est, jqXHR){
                if(res == '1'){
                $("#name").val("");
                $("#startDate").val("");
                $("#endDate").val("");
                alert("El ciclo ha sido registrado correctamente");
                setTimeout(function (){
                  window.location = "ciclos_consumoOP.jsp";
                });
                }else{
                    alert("Error al registrar");
                }
        });
    }
    
    });
    });

