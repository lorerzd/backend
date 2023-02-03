import { userRegister } from "./auth.js";

let idTimeOut;
let password = document.getElementById("password");
let confirmPassword = document.getElementById("confirmPassword");
let btnRegistro = document.getElementById("btnRegistro");
let emailConfirmar = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
let telefonoConfirmar = /[^0]{1}[0-9]{1}-[0-9]{4}-[0-9]{4}/;
let nombreConfirmar = /^[a-zA-Z-ZÑñÁáÉéÍíÓóÚúÜü\s]+$/;
let apellidoConfirmar = /^[a-zA-Z-ZÑñÁáÉéÍíÓóÚúÜü\s]+$/;

let alertErrorPassword = document.getElementById("alertErrorPassword");
let alertConfPassword = document.getElementById("alertConfPassword");
let alertNombre = document.getElementById("alertNombre");
let alertApellido = document.getElementById("alertApellido");
let alertCorreo = document.getElementById("alertCorreo");
let alertTel = document.getElementById("alertTel");

let nombre = document.getElementById("nombre");
let apellido = document.getElementById("apellido");
let email = document.getElementById("email");
let tel = document.getElementById("tel");
let ModalRegistro = document.getElementById("ModalRegistro");

btnRegistro.addEventListener("click", function (event) {
  event.preventDefault();
  let validos = 0;


  //---------------Nombre-------------------------------
  if (nombre.value.match(nombreConfirmar) == null) {
    alertNombre.style.display = "block";
    nombre.style.border = "solid red 1px";
  }
  else {
    nombre.style.border = "solid green 1px"
    alertNombre.style.display = "none";
    validos++;
  }
  //---------------Apellido-------------------------------
  if (apellido.value.match(apellidoConfirmar) == null) {
    alertApellido.style.display = "block";
    apellido.style.border = "solid red 1px";

  }
  else {
    apellido.style.border = "solid green 1px"
    alertApellido.style.display = "none";
    validos++;
  }

  //------------------numero telefonico----------
  if (tel.value.match(telefonoConfirmar) == null) {
    alertTel.style.display = "block";
    tel.style.border = "solid red 1px";

  }
  else {
    tel.style.border = "solid green 1px";
    alertTel.style.display = "none";
    validos++;
  }

  //---------------Contraseñas

  if (password.value.length < 6) {
    alertErrorPassword.style.display = "block";
    password.style.border = "solid red 1px";
  } else {
    alertErrorPassword.style.display = "none";
    password.style.border = "solid green 1px";
    validos++;
  }

  if (password.value != confirmPassword.value) {
    alertConfPassword.style.display = "block";
    password.style.border = "solid red 1px";
    confirmPassword.style.border = "solid red 1px";
  } else if (password.value.length >= 6 && confirmPassword.value.length >= 6) {
    alertConfPassword.style.display = "none";
    password.style.border = "solid green 1px";
    confirmPassword.style.border = "solid green 1px";
    validos++;
  }

  //---------Email---------
  if (email.value.match(emailConfirmar) == null) {
    alertCorreo.style.display = "block";
    email.style.border = "solid red 1px";
  }
  else {
    email.style.border = "solid green 1px"
    alertCorreo.style.display = "none";
    validos++;
  }

  //-----------------TimeOut--------
  if ((idTimeOut != undefined) && (idTimeOut != null)) {
    clearTimeout(idTimeout);
  }

 


  if (validos == 6) {
    userRegister(registro).then(response => {
      if (response.ok) {
        ModalRegistro.style.display = "block";
        setTimeout(function () {
          window.location = '../HTML/login.html';
        }, 3000);
      }
    });
  }
});

tel.addEventListener("keypress", (event) => {
  if (tel.value.length == 2) {
    tel.value += '-';
  } else if (tel.value.length == 7) {
    tel.value += '-';
  }
  // do something
});


