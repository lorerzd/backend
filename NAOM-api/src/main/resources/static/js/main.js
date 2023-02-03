import { addItem, getAllProducts } from "./items.js";

const itemsContainer = document.getElementById("list-items");
const productos = await getAllProducts().then((response) => response.json());
productos.forEach((product) => novedadesItems(product));

function novedadesItems(product) {
  itemsContainer.innerHTML += addItem(product);
}

// Carousel
let swiper = new Swiper(".mySwiper", {
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
  slidesPerView: 1,
  spaceBetween: 10,

  breakpoints: {
    600: {
      slidesPerView: 1,
      spaceBetween: 20,
    },
    680: {
      slidesPerView: 3,
      spaceBetween: 40,
    },
    1200: {
      slidesPerView: 5,
      spaceBetween: 40,
    },
  },
});

let btnAddCart = document.getElementsByClassName("addCartProd");
for (let i = 0; i < btnAddCart.length; i++) {
  btnAddCart[i].addEventListener("click", () => {
    let id = btnAddCart[i].id;
    if (localStorage.getItem("carrito")) {
      let carritoList = JSON.parse(localStorage.getItem("carrito"));
      carritoList.push(productos[id]);
      localStorage.setItem("carrito", JSON.stringify(carritoList));
    } else {
      let carritoList = [productos[id]];
      localStorage.setItem("carrito", JSON.stringify(carritoList));
    }
  });
}
