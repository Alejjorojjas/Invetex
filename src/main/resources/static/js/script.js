window.addEventListener("load", () => {

  
    // Get the form element
    const elemen = document.getElementById("myBotton");
    elemen.addEventListener("click", validarLogin);
  });

  function sendData(email, pass) {
    const XHR = new XMLHttpRequest();

    // Bind the FormData object and the form element
    //const FD = new FormData(form);
  
    // Define what happens on successful data submission
    XHR.addEventListener("load", (event) => {
      
      if(XHR.status==200){
        window.location.href = '../menu.html';
      }else{
        Swal.fire(event.target.responseText);    
      }
        
    });

    // Define what happens in case of error
    XHR.addEventListener("error", (event) => {
      alert('Oops! Something went wrong.');
    });

    // Set up our request
    XHR.open("POST", "http://localhost:8081/Login/v1/Autenticar");
    XHR.setRequestHeader("Content-Type", "application/json");
    
    var object = {};
    object['email'] = email;
    object['pass'] = pass;
  
  
    var json = JSON.stringify(object);
    console.log(json);
  
    XHR.send(json);
    //XHR.send();
  }


  











