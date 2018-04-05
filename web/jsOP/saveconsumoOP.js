$(function () {
    $('#Consumos').validate({
        rules: {
            idHome: {
                required: true
            },
            idCycle: {
                required: true

            },
            electricity: {
                required: true
               
            },
            water: {
                required: true
   
            },
            naturalGas:{
                required: true
            }
        },
        messages: {
            idHome: {
                required: "Este campo es obligatorio"
            },
            idCycle: {
                required: "Este campo es obligatorio"
            },
            electricity: {
                required: "Este campo es obligatorio"
            },
            water: {
                required: "Este campo es obligatorio"
            },
            naturalGas:{
                required: "Este campo es obligatorio"
            }
         
        },
        submitHandler: function(form){
           //Funcion AJAX para registrar usuario
        
         var data = $("#Consumos").serialize();
            $.post("../guardarco", data, function(res, est, jqXHR){
                if(res == '1'){
                $("#idHome").val("");
                $("#idCycle").val("");
                $("#electricity").val("");
                $("#water").val("");
                $("#naturalGas").val("");
                alert("El Consumo ha sido registrado correctamente");
                setTimeout(function (){
                  window.location = "ConsumosOP.jsp";
                });
                }else{
                    alert("Error al registrar");
                }
        });
    }
    
    });
    });

