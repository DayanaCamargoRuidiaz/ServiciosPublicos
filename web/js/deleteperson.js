
$(function () {
    $('tr #btnE').click(function (e) {
        e.preventDefault();
        var opcion = confirm("Desea Eliminar el responsable? ");

        if (opcion) {
            var fila = $(this).parent().parent();
            var idPerson = fila.find('#id_person').text();
            var data = {idPerson: idPerson};
            $.post("eliminarPe", data, function (res, est, jqXHR) {
                alert(res);
                 setTimeout(function (){
                  window.location = "personas.jsp";
                });
                fila.remove();
            });
        }

    });
});