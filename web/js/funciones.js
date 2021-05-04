$(document).ready(function () {
    $("tr #Cant").click(function (e) {
        var idp = $(this).parent().find('#item1').val();
        var cantidad = $(this).parent().find('#Cant').val();
        var url = "Controlador?accion=ActualizarCantidad";
        console.log(idp, cantidad);
        $.ajax({
            type: 'POST',
            url: url,
            data: "idProducto=" + idp + "&cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR) {
                location.href = "Controlador?accion=carrito";
            }
        });
    });    
    
    
    function eliminar(idp) {
        var url = "Controlador?accion=deleteProducto&id=" + idp;
        console.log("hol");
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            success: function (r) {
            }
        });
    }
    
    
    
});



