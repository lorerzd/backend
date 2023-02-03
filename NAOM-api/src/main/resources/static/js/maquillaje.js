import { addItems, getProducts } from "./items.js";

const cardWrapper = document.getElementById("card-wrapper");
let maxVal = document.getElementById("maxVal");
let minVal = document.getElementById("minVal");
const filtrarBtn = document.getElementById("filtrarBtn");
const productos = await getProducts(1).then((response) => response.json());
productos.forEach((product) => maquillajeItems(product));

function maquillajeItems(product) {
  cardWrapper.innerHTML += addItems(product);
}

filtrarBtn.addEventListener("click", () => {
  cardWrapper.innerHTML = "";
  let min = minVal.value;
  let max = maxVal.value;

  if (!min) {
    min = "0";
  }

  if (!max) {
    max = "1500";
  }

  productos
    .filter((product) => {
      if (product.precio >= parseInt(min) && product.precio <= parseInt(max))
        return true;
    })
    .forEach((product) => maquillajeItems(product));
});

let btnAddCart = document.getElementsByClassName("addCartProd");
for (let i = 0; i <= btnAddCart.length; i++) {
  btnAddCart[i].addEventListener("click", () => {
    let id = btnAddCart[i].id;
    if (localStorage.getItem("carrito")) {
      let carritoList = JSON.parse(localStorage.getItem("carrito"));
      carritoList.push(findProductId(productos,id));
      localStorage.setItem("carrito", JSON.stringify(carritoList));
    } else {
      let carritoList = [findProductId(productos,id)];
      localStorage.setItem("carrito", JSON.stringify(carritoList));
    }
  });
}

function findProductId(productos,id){
  return productos.filter(product => product.id == id)[0];
}
