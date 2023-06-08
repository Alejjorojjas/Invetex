$(document).ready(function (){
    cargarInsumos();
    $('tablaInsumos').DataTable();
});

async function cargarInsumos() {
    const respuesta = await fetch('obtenerInsumos', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const insumos = await respuesta.json();
    let insumoHTML = "";
    for(let insumo of insumos){
        insumoHTML = insumoHTML+'<tr><td>'+insumo.referencia+'</td><td>'+insumo.nombreInsumo+'</td><td>'+insumo.descripcionInsumo+'</td><td>'+insumo.precioUnitario+'</td><td>'+insumo.cantidadInsumo+'</td><td>Pendiente</td></tr>';
    }
    document.querySelector('#tablaInsumos tbody').outerHTML = insumoHTML;
}