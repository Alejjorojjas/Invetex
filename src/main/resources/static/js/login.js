//Funcion que me valida el login
document.addEventListener("DOMContentLoaded", function () {
  document
    .getElementById("formulario")
    .addEventListener("submit", validarLogin);
});

const validarLogin = async (e) => {
  e.preventDefault();

  let $email = document.getElementById("email").value;
  let $pass = document.getElementById("pass").value;
  if ($email === "" || $pass === "")
    return Swal.fire({
      icon: "error",
      title: "Oops...",
      text: "Los campos no pueden estar vacios!",
    });

  if (!$email.includes("@") || !$email.includes(".com"))
    return Swal.fire({
      icon: "error",
      title: "Oops...",
      text: "El dato ingresado no corresponde a un correo valido!",
    });
  else {
    console.log("Entro else");
    let validado = await validarUsuario();
    console.log("validado " + validado);
    if (validado != "0") {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "No fue posible autenticar el usuario",
      });
    } else {
      Swal.fire(`Bienvenido ${$email}`);
      setTimeout(() => {
        location.href = "menu.html";
      }, 3000);
    }
  }
};

async function validarUsuario() {
  let datos = {};
  datos.password = document.getElementById("pass").value;
  datos.email = document.getElementById("email").value;
  console.log(datos);
  const request = await fetch("usuario", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(datos),
  });
  var respuesta = await request.text();
  console.log(respuesta.toString());
  return respuesta;
}

//Navegación
const navegar = (valor) => {
  switch (valor) {
    case 1:
      location.href = "insumos.html";
      break;
    case 2:
      location.href = "clientes.html";
      break;
    case 3:
      location.href = "entrada.html";
      break;
    case 4:
      location.href = "salida.html";
      break;
    case 5:
      location.href = "proveedor.html";
      break;
    case 6:
      location.href = "satelite.html";
      break;
    case 7:
      location.href = "categoria.html";
      break;
    case 8:
      location.href = "inventario.html";
      break;           
  }
};
function darkMode(){
  const bodyDark = document.getElementById("body-dark");
  bodyDark.classList.toggle("body-dark");
  
}

const btndark = document.getElementById("btn-dark");
btndark.addEventListener("click", darkMode);

function exportar(){
  window.print();
}

/* window.addEventListener("load", () => {
    function sendData() {
      const XHR = new XMLHttpRequest();
  
      // Bind the FormData object and the form element
      const FD = new FormData(form);
    
      // Define what happens on successful data submission
      XHR.addEventListener("load", (event) => {
        alert(event.target.responseText);
      });
  
      // Define what happens in case of error
      XHR.addEventListener("error", (event) => {
        alert('Oops! Something went wrong.');
      });
  
      // Set up our request
      XHR.open("GET", "http://localhost:8080/Login/v1/Autenticar");
      XHR.setRequestHeader("Content-Type", "application/json");
      
      var object = {};
    FD.forEach(function(value, key){
    object[key] = value;
    });
    
    var json = JSON.stringify(object);

    
      XHR.send(json);
    
    }
  
    // Get the form element
    const form = document.getElementById("myFormLogin");
  
    // Add 'submit' event handler
    form.addEventListener("submit", (event) => {
      event.preventDefault();
     
    //xhr.send(data);  
      sendData();
      
    });

  


  }); */
