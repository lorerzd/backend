import { userLogin, userAdminLogin } from "./auth.js";
let idTimeOut;
let password = document.getElementById("password");
let btnLogIn = document.getElementById("btnLogIn");
let email = document.getElementById("email");
let ModalRegistro=document.getElementById("ModalRegistro");
// let emailConfirmar = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/

let alertErrorPassword = document.getElementById("alertErrorPassword");
let alertCorreo = document.getElementById("alertCorreo");
let btnAdmin = document.getElementById("adminLogin");


btnLogIn.addEventListener("click", function (event) {
  event.preventDefault();


  //-----------------TimeOut--------
  if ((idTimeOut != undefined) && (idTimeOut != null)) {
    clearTimeout(idTimeout);
  }

  

  //---------------- Validación Usuario-------
  let login = {
    "correo": `${email.value}`,
    "contrasena": `${password.value}`
  }

  userLogin(login).then(response => {
    if (response.ok) {
      response.json().then(data => localStorage.setItem("token", JSON.stringify(data.accessToken)));
      ModalRegistro.style.display = "block";
      setTimeout(function () {
        window.location = '../index.html';
      }, 3000);
    }else {
      alertErrorLogin.style.display="block";
      password.style.border = "solid red 1px";
      email.style.border = "solid red 1px";
    }
  });
});

btnAdmin.addEventListener("click", function (event) {
  event.preventDefault();


  //-----------------TimeOut--------
  if ((idTimeOut != undefined) && (idTimeOut != null)) {
    clearTimeout(idTimeout);
  }

  

  //---------------- Validación Usuario-------
  let login = {
    "correo": `${email.value}`,
    "contrasena": `${password.value}`
  }

  userAdminLogin(login).then(response => {
    if (response.ok) {
      response.json().then(data => localStorage.setItem("token", JSON.stringify(data.accessToken)));
      ModalRegistro.style.display = "block";
      setTimeout(function () {
        window.location = '../index.html';
      }, 3000);
    }else {
      alertErrorLogin.style.display="block";
      password.style.border = "solid red 1px";
      email.style.border = "solid red 1px";
    }
  });
});
