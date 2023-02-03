import { addProductCart } from "./items.js";

const userArticles = document.getElementById("userArticles");
const productosCarrito = Array.from(JSON.parse(localStorage.getItem("carrito")));

//Encontramos duplicados por el product.id y los metemos a un map id => cantidad de repetidos
function findDuplicates(productos){
  let map1 = new Map();
  productos.forEach(producto => {
    let id = producto.id;
    if(map1.get(id)){
      map1.set(id,map1.get(id)+1);
    }else{
      map1.set(id,1);
    }
  })
  return map1;
}


//Encontramos el producto por el id
function findProductId(productos,id){
  return productos.filter(product => product.id == id)[0];
}

findDuplicates(productosCarrito).forEach((value,key) => {
  let product = findProductId(productosCarrito,key);
  let cantidad = value;
  let num = document.getElementById(`count-${key}`);
  let a = value;
  userArticles.innerHTML += addProductCart(product,cantidad);
  let plus = document.getElementById(`plus-${key}`);
  let minus = document.getElementById(`minus-${key}`);
  let precioTotal = product.precio*cantidad;
  let estado = "ENTREGADO";

  let ordenes = {
    "cantidad": ``,
    "estado": ``,
    "fecha": ``,
    "productos": ``,
    "totalOrden": ``
  }

  plus.addEventListener("click", (e) => {
    a++;
    a = a < 10 ? "0" + a : a;
    num.innerHTML = a;
  });
  
  minus.addEventListener("click", (e) => {
    if (a > 1) {
      a--;
      a = a < 10 ? "0" + a : a;
      num.innerHTML = a;
    }
  });
});



// <!-- <p>Su carrito actualmente está vacío.</p>
//         <a href="./maquillaje.html">Continúe explorando aquí</a> -->