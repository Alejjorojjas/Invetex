const form = document.getElementById("FormTipoInsumo");
$(document).ready(function(){
    cargarTipoInsumos();
    $('tablaTipoInsumos').DataTable();
});
$(form).submit(function (){
    guardarTipoInsumos();
});
const FD = new FormData(form);

let tipoInsumo = [];

async function cargarTipoInsumos() {
    const respuesta = await fetch('obtenerTipoInsumos', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });


    tipoInsumo= await respuesta.json();
    let insumoHTML = "";
    for(let insumo of tipoInsumo){
        let botonEliminar = '<td><button class="btn_acc btn-del"  onclick="eliminarInsumo('+insumo.idTipo+')" ><i class="bi bi-trash-fill"></i></button>';
        let campoEliminar = '<input type="hidden" id="'+ insumo.idTipo+'" /></td>';
        let botonActualizar = '<td><button type="button" onclick="editarTipoInsumo('+insumo.idTipo+')" data-bs-toggle="modal" data-bs-target="#myModal"><i class="bi bi-pencil-fill"></i></button>';

        insumoHTML = insumoHTML+'<tr><td>'+insumo.codigoTipo+'</td><td>'+insumo.nombreTipo+'' +
            '</td><td>'+insumo.descripcionTipo+'</td>'+botonEliminar+campoEliminar+botonActualizar+'</tr>';
        }
    document.querySelector('#tablaTipoInsumos tbody').outerHTML = insumoHTML;
}

async function eliminarInsumo (idIsumo){
    let datos = {};
    datos.idTipo = idIsumo;
    const request = await fetch("eliminarTipoInsumo", {
        method: "DELETE",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(datos),
    });
    var respuesta = await request.text();
    console.log(respuesta.toString());
    cargarTipoInsumos()
    return respuesta;

}
async function guardarTipoInsumos() {
    let datos = {};
    datos.codigoTipo = document.getElementById("codigoTipo").value;
    datos.nombreTipo = document.getElementById("nombreTipo").value;
    datos.descripcionTipo = document.getElementById("descripcionTipo").value;
    console.log(datos);
    const request = await fetch("guardarTipoInsumo", {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(datos),
    });
    var respuesta = await request.text();
    console.log(respuesta.toString());
    cargarTipoInsumos()
    return respuesta;
}

function editarTipoInsumo (idTipo) {

    for (let i = 0; i < tipoInsumo.length; i ++ ){

        var TipoInsumoActual = tipoInsumo[i];
        if (TipoInsumoActual.idTipo == idTipo){


            document.getElementById("CodigoActualizar").value = TipoInsumoActual.codigoTipo;
            document.getElementById("NombreActualizar").value = TipoInsumoActual.nombreTipo;
            document.getElementById("DescripcionActualizar").value = TipoInsumoActual.descripcionTipo;
            document.getElementById("IdActualizar").value = TipoInsumoActual.idTipo;
            document.querySelector('#CuerpoActualizar').outerHTML = formulario;
        }


    }
}

const formActualizar = document.getElementById("ActualizarTipo");
$(formActualizar).submit(function (){
    actualizarTipoInsumo();
});

async function actualizarTipoInsumo() {
    let datos = {};
    datos.codigoTipo = document.getElementById("CodigoActualizar").value;
    datos.nombreTipo = document.getElementById("NombreActualizar").value;
    datos.descripcionTipo = document.getElementById("DescripcionActualizar").value;
    datos.idTipo = document.getElementById("IdActualizar").value;
    console.log(datos);
    const request = await fetch("actualizarTipoInsumo", {
        method: "PUT",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(datos),
    });
    var respuesta = await request.text();
    console.log(respuesta.toString());
    setTimeout(() => {
        location.reload();
    }, 500);
    cargarTipoInsumos();
    return respuesta;
}
