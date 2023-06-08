$(document).ready(function (){
    cargarClientes();
    $('tablaClientes').DataTable();
});
let clientes = [];
async function cargarClientes() {
    const respuesta = await fetch('obtenerClientes', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    clientes = await respuesta.json();
    let clientesHTML = "";
    for(let cliente of clientes){
        let botonEliminar = '<td><button class="btn_acc btn-del"  onclick="eliminarCliente('+cliente.idCliente+')" ><i class="bi bi-trash-fill"></i></button>';
        let campoEliminar = '<input type="hidden" id="'+ cliente.idCliente+'" /></td>'

        let botonActualizar = '<td><button type="button" onclick="editarCliente('+cliente.idCliente+')" data-bs-toggle="modal" data-bs-target="#myModal"><i class="bi bi-pencil-fill"></i></button>';
        clientesHTML = clientesHTML+'<tr><td>'+cliente.nombreCliente+'</td><td>'+cliente.correoCliente+'</td><td>'+cliente.telefonoCliente+'</td><td>'+cliente.direccionCliente+'</td>'+
            '<td>'+botonEliminar+campoEliminar+'</td><td>'+ botonActualizar +'</td></tr>';

    }
    document.querySelector('#tablaClientes tbody').outerHTML = clientesHTML;
}

const form = document.getElementById("formCliente");
$(form).submit(function (){
    guardarCliente();
});
const FD = new FormData(form);

function editarCliente (idCliente) {

    for (let i = 0; i < clientes.length; i ++ ){

        var clienteActual = clientes[i];
        if (clienteActual.idCliente == idCliente){


            document.getElementById("NombreActualizar").value = clienteActual.nombreCliente;
            document.getElementById("CorreoActualizar").value = clienteActual.correoCliente;
            document.getElementById("TelefonoActualizar").value = clienteActual.telefonoCliente;
            document.getElementById("DireccionActualizar").value = clienteActual.direccionCliente;
            document.getElementById("IdActualizar").value = clienteActual.idCliente;
            document.querySelector('#CuerpoActualizar').outerHTML = formulario;
        }


    }
}

const formActualizar = document.getElementById("ActualizarCliente");
$(formActualizar).submit(function (){
    actualizarCliente();
});

async function actualizarCliente() {
    let datos = {};
    datos.nombreCliente = document.getElementById("NombreActualizar").value;
    datos.correoCliente = document.getElementById("CorreoActualizar").value;
    datos.telefonoCliente = document.getElementById("TelefonoActualizar").value;
    datos.direccionCliente = document.getElementById("DireccionActualizar").value;
    datos.idCliente = document.getElementById("IdActualizar").value;
    console.log(datos);
    const request = await fetch("actualizarCliente", {
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
    cargarClientes();
    return respuesta;
}

async function eliminarCliente (idCliente){
    let datos = {};
    datos.idCliente = idCliente;
    const request = await fetch("eliminarCliente", {
        method: "DELETE",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(datos),
    });
    var respuesta = await request.text();
    console.log(respuesta.toString());
    cargarClientes()
    return respuesta;

}
async function guardarCliente() {
    let datos = {};
    datos.nombreCliente = document.getElementById("nombreCliente").value;
    datos.correoCliente = document.getElementById("correoCliente").value;
    datos.telefonoCliente = document.getElementById("telefonoCliente").value;
    datos.direccionCliente = document.getElementById("direccionCliente").value;
    console.log(datos);
    const request = await fetch("guardarCliente", {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(datos),
    });
    var respuesta = await request.text();
    console.log(respuesta.toString());
    cargarClientes();
    return respuesta;
}