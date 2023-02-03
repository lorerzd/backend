let btnContactoEnviar = document.getElementById("btnContactoEnviar");
let idTimeout;
let correos = ["gbastoa17@gmail.com",
"josuetolvera@gmail.com",
"lore.rdz2802@gmail.com",
"ivancamposceron11@gmail.com",
"eh180793@gmail.com",
"maria.gonzalezbarrreda@gmail.com",
"marzo.2093@gmail.com",
"arguello.ramosadrian@gmail.com"];

let emailConfirmar = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
let telefonoConfirmar = /[^0]{1}[0-9]{1}-[0-9]{4}-[0-9]{4}/;
let nombreConfirmar =/^[a-zA-Z-ZÑñÁáÉéÍíÓóÚúÜü\s]+$/; 
let msjConfirmar =/^[a-zA-Z\-0-9-ZÑñÁáÉéÍíÓóÚúÜü\s.,!@?¿*+¡^$#"]+$/; 

let nameFrom=document.getElementById("exampleFormControlInput1");
let emailFrom=document.getElementById("exampleFormControlInput2");
let cellPhone=document.getElementById("exampleFormControlInput3");
let emailBody=document.getElementById("exampleFormControlTextarea1");

let alertName = document.getElementById("alertName");
let alertEmail = document.getElementById("alertEmail");
let alertTel = document.getElementById("alertTel");
let alertMessage = document.getElementById("alertMessage");
let alertSuccess = document.getElementById("alertSuccess");

btnContactoEnviar.addEventListener("click", function(event) 
{ 
    event.preventDefault();
    let validos=0;
    alertSuccess.style.display = "none";

    
    // let alertError = document.getElementById("alertError");
    emailBody.value= emailBody.value.trim(); 
    // alertError.style.display="none";
    // alertError.innerHTML = "";

   //---------------Nombre-------------------------------
   if (nameFrom.value.match(nombreConfirmar)==null)
   {
     alertName.style.display="block";
     nameFrom.style.border = "solid red 1px";
     
   }
   else
   {
    nameFrom.style.border = "solid green 1px";
    alertName.style.display="none";
    validos++;
   }

    //-------------------correo-------------------------
    if (emailFrom.value.match(emailConfirmar)==null)
  {
    alertEmail.style.display="block";
    emailFrom.style.border = "solid red 1px";
    
  }
  else
  {
    emailFrom.style.border = "solid green 1px"
    alertEmail.style.display="none";
    validos++;
  }
   //------------------numero telefonico----------
  if(cellPhone.value.match(telefonoConfirmar)==null)
  {
    alertTel.style.display="block";
    cellPhone.style.border = "solid red 1px";
    
  }
  else{
    cellPhone.style.border = "solid green 1px";
    alertTel.style.display="none";
    validos++;
}
//---------------------mensaje-----------------------
  if (emailBody.value.match(msjConfirmar) == null) {
    alertMessage.style.display="block";
    emailBody.style.border = "solid red 1px"
  }
  else
  {
    emailBody.style.border = "solid green 1px";
    alertMessage.style.display="none";
    validos++;
  }
//-----------------TimeOut--------
if ((idTimeout!=undefined) && (idTimeout!=null))
  {
    clearTimeout(idTimeout);
  }

  if (validos == 4){
    alertSuccess.style.display = "block";
    Email.send({
      SecureToken : "0d441985-cdef-4941-9931-d30a7ed8bde4",
      To : correos,
      From : `webosgeneration@gmail.com`,
      Subject : `${nameFrom.value} te ha enviado un mensaje.`,
      Body : `${emailBody.value}
              <br>
              <br>
              Información de contacto
              <br>
              <br>
              ${emailFrom.value}<br> 
              ${cellPhone.value}`
  });
    idTimeout =  setTimeout(function()
    {
      nameFrom.style.border="";
      emailFrom.style.border="";
      cellPhone.style.border="";
    }, 3000);
    nameFrom.value = "";
    emailFrom.value = "";
    cellPhone.value = "";
    emailBody.value = "";
  }
});

cellPhone.addEventListener("keypress", (event) => {
  if(cellPhone.value.length == 2){
    cellPhone.value += '-';
  }else if(cellPhone.value.length == 7){
    cellPhone.value += '-';
  }
  // do something
});