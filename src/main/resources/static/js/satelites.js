$(document).ready(function (){
    cargarSatelites();
    $('tablaSatelites').DataTable();
});
let satelites = [];
async function cargarSatelites() {
    const respuesta = await fetch('obtenerSatelites', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    satelites = await respuesta.json();
    let satelitesHTML = "";
    for(let satelite of satelites){
        let botonEliminar = '<td><button class="btn_acc btn-del"  onclick="eliminarSatelite('+satelite.idSatelite+')" ><i class="bi bi-trash-fill"></i></button>';
        let campoEliminar = '<input type="hidden" id="'+ satelite.idSatelite+'" /></td>'

        let botonActualizar = '<td><button type="button" onclick="editarSatelite('+satelite.idSatelite+')" data-bs-toggle="modal" data-bs-target="#myModal"><i class="bi bi-pencil-fill"></i></button>';
        satelitesHTML = satelitesHTML+'<tr><td>'+satelite.nombreSatelite+'</td><td>'+satelite.correoSatelite+'</td><td>'+satelite.telefonoSatelite+'</td><td>'+satelite.direccionSatelite+'</td>'+
            '<td>'+botonEliminar+campoEliminar+'</td><td>'+ botonActualizar +'</td></tr>';

    }
    document.querySelector('#tablaSatelites tbody').outerHTML = satelitesHTML;
}

const form = document.getElementById("formSatelite");
$(form).submit(function (){
    guardarSatelite();
});
const FD = new FormData(form);

function editarSatelite (idSatelite) {

    for (let i = 0; i < satelites.length; i ++ ){

        var sateliteActual = satelites[i];
        if (sateliteActual.idSatelite == idSatelite){


            document.getElementById("NombreActualizar").value = sateliteActual.nombreSatelite;
            document.getElementById("CorreoActualizar").value = sateliteActual.correoSatelite;
            document.getElementById("TelefonoActualizar").value = sateliteActual.telefonoSatelite;
            document.getElementById("DireccionActualizar").value = sateliteActual.direccionSatelite;
            document.getElementById("IdActualizar").value = sateliteActual.idSatelite;
            document.querySelector('#CuerpoActualizar').outerHTML = formulario;
        }


    }
}

const formActualizar = document.getElementById("ActualizarSatelite");
$(formActualizar).submit(function (){
    actualizarSatelite();
});

async function actualizarSatelite() {
    let datos = {};
    datos.nombreSatelite = document.getElementById("NombreActualizar").value;
    datos.correoSatelite = document.getElementById("CorreoActualizar").value;
    datos.telefonoSatelite = document.getElementById("TelefonoActualizar").value;
    datos.direccionSatelite = document.getElementById("DireccionActualizar").value;
    datos.idSatelite = document.getElementById("IdActualizar").value;
    console.log(datos);
    const request = await fetch("actualizarSatelite", {
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
    cargarSatelites();
    return respuesta;
}

async function eliminarSatelite (idSatelite){
    let datos = {};
    datos.idSatelite = idSatelite;
    const request = await fetch("eliminarSatelite", {
        method: "DELETE",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(datos),
    });
    var respuesta = await request.text();
    console.log(respuesta.toString());
    cargarSatelites()
    return respuesta;

}
async function guardarSatelite() {
    let datos = {};
    datos.nombreSatelite = document.getElementById("nombreSatelite").value;
    datos.correoSatelite = document.getElementById("correoSatelite").value;
    datos.telefonoSatelite = document.getElementById("telefonoSatelite").value;
    datos.direccionSatelite = document.getElementById("direccionSatelite").value;
    console.log(datos);
    const request = await fetch("guardarSatelite", {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(datos),
    });
    var respuesta = await request.text();
    console.log(respuesta.toString());
    cargarSatelites();
    return respuesta;
}