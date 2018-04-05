
$(function () {
    $('tr #btnE').click(function (e) {
        e.preventDefault();
        var opcion = confirm("Desea Eliminar el Ciclo? ");

        if (opcion) {
            var fila = $(this).parent().parent();
            var idCycles = fila.find('#id_cycles').text();
            var data = {idCycles: idCycles};
            $.post("./EliminarCiclo", data, function (res, est, jqXHR) {
                alert(res);
                 setTimeout(function (){
                  window.location = "ciclos_consumo.jsp";
                });
                fila.remove();
            });
        }

    });
});