import { addProduct, addTableRows, getAllProducts, deleteProduct, updateProduct } from "./items.js";


let tableRow = document.getElementById("tableRow");
let form = document.getElementById("form");
let name1 = document.getElementById("form1");
let price = document.getElementById("form2");
let description = document.getElementById("form3");
let stock = document.getElementById("form4");
let prevImg = document.getElementById("prevImg");
let btnProductCancel = document.getElementById("btnProductCancel");
let btnProduct = document.getElementById("btnProduct");
let alertSuccess = document.getElementById("alertSuccess");
let valorCategoria = document.getElementById("selectorCategoria");
let categoria;

let alertName = document.getElementById("alertProductName");
let alertPrice = document.getElementById("alertPrice");
let alertDescription = document.getElementById("alertDescription");
let alertStock = document.getElementById("alertAvailable");
let alertImg = document.getElementById("alertFile");

let exampleModal = document.getElementById("exampleModal");
let btnConfirm = document.getElementById("btnConfirm");
let btnCerrar = document.getElementById("btnCerrar");
let CloseModal = document.getElementById("CloseModal");
let token = localStorage.getItem("token");
let productos = await getAllProducts().then(response => response.json());
productos.forEach(producto => tableRowAdd(producto));
let image;

var myWidget = cloudinary.createUploadWidget({
  cloudName: 'domamliq5', 
  uploadPreset: 'xvfhpubb'}, (error, result) => { 
    if (!error && result && result.event === "success") { 
      prevImg.src = result.info.url;
    }
  }
);

document.getElementById("upload_widget").addEventListener("click", function(e){
  e.preventDefault();
  myWidget.open();
});


form.addEventListener("submit", (e) => {
  e.preventDefault();
  alertSuccess.innerHTML = "";
  alertSuccess.style.display="none";

  image = prevImg.src;

  let valido = true;

  console.log(valorCategoria.value)
  switch (valorCategoria.value) {
    case "1":
      categoria = {"id": 1, "tipoDeProducto": "Maquillaje"};
      console.log(categoria);
      break;
    case "2":
      categoria = {"id": 2,  "tipoDeProducto": "Brochas"};
      console.log(categoria);
      break;
    case "3":
      categoria = {"id": 3,  "tipoDeProducto": "Cuidado Facial"};
      console.log(categoria);
      break;
    case "4":
      categoria = {"id": 4,  "tipoDeProducto": "Accesorios"};
      console.log(categoria);
      break;
  
    default:
      break;
  }

  let product = {"nombre":`${name1.value}`,
      "precio":`${price.value}`,
      "descripcion":`${description.value}`,
      "stock":`${stock.value}`,
      "foto":`${prevImg.src}`,
      "rating": 10,
      "foto":`${image}}`,
      "categorias": categoria}

  if (product.nombre.length < 3 || product.nombre.length > 20)
  {
    valido = false;
    alertName.style.display="block";
    name1.style.border = "solid red 1px";
  } else {
    name1.style.border = "solid green 1px";
    alertName.style.display="none";
  }

  
  if (parseInt(product.precio)<=0 || isNaN(parseInt(product.precio)))
  {
    valido = false;
    alertPrice.style.display="block";
    price.style.border = "solid red 1px";
  } else {
    alertPrice.style.display="none";
    price.style.border = "solid green 1px";
  }

  if (product.descripcion.length < 15)
  {
    valido = false;
    alertDescription.style.display="block";
    description.style.border = "solid red 1px";
  } else {
    alertDescription.style.display="none";
    description.style.border = "solid green 1px";
  }

  if (prevImg == undefined){
    valido = false;
    alertImg.style.display = "block";
  }else{
    alertImg.style.display = "none";
  }

  if (parseInt(product.stock) < 0 || isNaN(parseInt(product.stock)) )
  {
    valido = false;
    alertStock.style.display="block";
    stock.style.border = "solid red 1px";
  } else {
    alertStock.style.display="none";
    stock.style.border = "solid green 1px";
  }

  if(valido){
    exampleModal.style.display="block";
  }
});



btnConfirm.addEventListener("click", (e) => {
  e.preventDefault();
  switch (valorCategoria.value) {
    case "1":
      categoria = {"id": 1, "tipoDeProducto": "Maquillaje"};
      console.log(categoria);
      break;
    case "2":
      categoria = {"id": 2,  "tipoDeProducto": "Brochas"};
      console.log(categoria);
      break;
    case "3":
      categoria = {"id": 3,  "tipoDeProducto": "Cuidado Facial"};
      console.log(categoria);
      break;
    case "4":
      categoria = {"id": 4,  "tipoDeProducto": "Accesorios"};
      console.log(categoria);
      break;
  
    default:
      break;
  }

  let product = {"nombre":`${name1.value}`,
      "precio":`${price.value}`,
      "descripcion":`${description.value}`,
      "stock":`${stock.value}`,
      "foto":`${image}`,
      "rating": 10,
      "categorias": categoria}

  addProduct(product,localStorage.getItem("token")).then(response => response.json()).then(data =>console.log(data))


  
  exampleModal.style.display="none";
});

btnCerrar.addEventListener("click", function() {
      
  exampleModal.style.display="none";
});

CloseModal.addEventListener("click", function() {
      
  exampleModal.style.display="none";
});

btnProductCancel.addEventListener("click", (e) => {
  e.preventDefault();
  name1.value = "";
  price.value = "";
  description.value = "";
  stock.value = "";
  img = undefined;
  prevImg.src = "../Fotos_pagina/photo-camera.png";
  alertName.style.display="none";
  alertPrice.style.display="none";
  alertDescription.style.display="none";
  alertStock.style.display="none";
  name1.style.border = "";
  price.style.border = "";
  description.style.border = "";
  stock.style.border = "";
  alertImg.style.display = "none";
});


window.addEventListener("load", () => {
  let crud = document.getElementsByClassName("crud");
  Array.from(crud).forEach(button => button.addEventListener("click", () => {
    let method = button.id.split("-")[0];
    let id = button.id.split("-")[1];
    if(method == "delete"){
      deleteProduct(id,token);
      location.reload();
    }else if(method == "update"){
      //AQUI VA EL FILTRO POR ID PARA SACAR LOS DATOS DEL OBJETO Y EL editProduct
    }
  }));
})

function tableRowAdd(product) {
  tableRow.innerHTML += addTableRows(product);
}

function filterId(productos,id){
  return productos.filter(producto => producto.id == id);
}

function editProduct(product){
  //AQUI VAN LOS INPUTS DEL MODAL PARA LA EDICION
}



