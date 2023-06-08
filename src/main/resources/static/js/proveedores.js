$(document).ready(function (){
    console.log("Cargar formulario");
    cargarProveedor();
    $('TablaProveedor').DataTable();
});
let proveedores = [];
async function cargarProveedor() {
    const respuesta = await fetch('obtenerProveedor', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    proveedores = await respuesta.json();
    let proveedoresHTML = "";
    for(let proveedor of proveedores){
        let botonEliminar = '<td><button class="btn_acc btn-del"  onclick="eliminarProveedor('+proveedor.idProveedor+')" ><i class="bi bi-trash-fill"></i></button>';
        let campoEliminar = '<input type="hidden" id="'+ proveedor.idProveedor+'" /></td>'

        let botonActualizar = '<td><button type="button" onclick="editarProveedor('+proveedor.idProveedor+')" data-bs-toggle="modal" data-bs-target="#myModal"><i class="bi bi-pencil-fill"></i></button>';
        proveedoresHTML = proveedoresHTML+'<tr><td>'+proveedor.nombreProveedor+'</td><td>'+proveedor.correoProveedor+'</td><td>'+proveedor.telefonoProveedor+'</td><td>'+proveedor.direccionProveedor+'</td>'+
            '<td>'+botonEliminar+campoEliminar+'</td><td>'+ botonActualizar +'</td></tr>';

    }
    document.querySelector('#TablaProveedor tbody').outerHTML = proveedoresHTML;
}

const form = document.getElementById("formProveedor");
$(form).submit(function (){
    console.log("Submit formulario");
    guardarProveedor();
});
const FD = new FormData(form);

function editarProveedor (idProveedor) {

    for (let i = 0; i < proveedores.length; i ++ ){

        var proveedorActual = proveedores[i];
        if (proveedorActual.idProveedor == idProveedor){


            document.getElementById("NombreActualizar").value = proveedorActual.nombreProveedor;
            document.getElementById("CorreoActualizar").value = proveedorActual.correoProveedor;
            document.getElementById("TelefonoActualizar").value = proveedorActual.telefonoProveedor;
            document.getElementById("DireccionActualizar").value = proveedorActual.direccionProveedor;
            document.getElementById("IdActualizar").value = proveedorActual.idProveedor;
            document.querySelector('#CuerpoActualizar').outerHTML = formulario;
        }


    }
}

const formActualizar = document.getElementById("ActualizarProveedor");
$(formActualizar).submit(function (){
    actualizarProveedor();
});

async function actualizarProveedor() {
    let datos = {};
    datos.nombreProveedor = document.getElementById("NombreActualizar").value;
    datos.correoProveedor = document.getElementById("CorreoActualizar").value;
    datos.telefonoProveedor = document.getElementById("TelefonoActualizar").value;
    datos.direccionProveedor = document.getElementById("DireccionActualizar").value;
    datos.idProveedor = document.getElementById("IdActualizar").value;
    console.log(datos);
    const request = await fetch("actualizarProveedor", {
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
    cargarProveedor();
    return respuesta;
}

async function eliminarProveedor (idProveedor){
    let datos = {};
    datos.idProveedor = idProveedor;
    const request = await fetch("eliminarProveedor", {
        method: "DELETE",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(datos),
    });
    var respuesta = await request.text();
    console.log(respuesta.toString());
    cargarProveedor()
    return respuesta;

}
async function guardarProveedor() {
    let datos = {};
    datos.nombreProveedor = document.getElementById("NombreProveedor").value;
    datos.correoProveedor = document.getElementById("CorreoProveedor").value;
    datos.telefonoProveedor = document.getElementById("TelefonoProveedor").value;
    datos.direccionProveedor = document.getElementById("DireccionProveedor").value;
    console.log(datos);
    const request = await fetch("guardarProveedor", {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(datos),
    });
    var respuesta = await request.text();
    console.log(respuesta.toString());
    cargarProveedor();
    return respuesta;
}