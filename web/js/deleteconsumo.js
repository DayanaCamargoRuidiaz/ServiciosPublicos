$(function () {
    $('tr #btnE').click(function (e) {
        e.preventDefault();
        var opcion = confirm("Desea Eliminar el consumo? ")

        if (opcion) {
            var fila = $(this).parent().parent();
            var idHome = fila.find('#id_home').text();
            var data = {idHome: idHome};
            $.post("eliminarco", data, function (res, est, jqXHR) {
                alert(res);
                 setTimeout(function (){
                  window.location = "Consumos.jsp";
                });
                fila.remove();
            });
        }

    });
});