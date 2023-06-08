const form = document.getElementById("myForm");
window.addEventListener("load", () => {
    function sendData() {
        const XHR = new XMLHttpRequest();

        // Get the form element


        // Bind the FormData object and the form element
        const FD = new FormData(form);

        // Define what happens on successful data submission
        XHR.addEventListener("load", (event) => {

            Swal.fire({
                icon: 'success',
                title: 'Registro Exitoso',
                text: event.target.responseText,
            }).then(function() {
                window.location = "index.html";
            });

            //window.location.replace("index.html");
        });

        // Define what happens in case of error
        XHR.addEventListener("error", (event) => {
            alert('Oops! Something went wrong.');
        });

        // Set up our request
        XHR.open("POST", "http://localhost:8081/registrar");
        XHR.setRequestHeader("Content-Type", "application/json");


        var object = {};
        FD.forEach(function(value, key){
            if(key!="input_pass")
            object[key] = value;
        });



        var json = JSON.stringify(object);

        console.log(json);
        var password1 = document.getElementById("input_pass").value;
        var password2 = document.getElementById("input_pass2").value;

        if (password1 == password2) {
            // The data sent is what the user provided in the form
            XHR.send(json);
        }
        else{
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Las contraseñas no corresponden!',
            })

        }
    }



    // Add 'submit' event handler
    form.addEventListener("submit", (event) => {
        console.log("enviado");
        event.preventDefault();

        //xhr.send(data);
        sendData();
    });

});