// import { searchResult } from "./items";

const resultHeader = document.getElementById("resultHeader");
const cardWrapper = document.getElementById("card-wrapper");
const params = new URLSearchParams(document.location.search);
const keyword = params.get("busqueda");



// function resultItems(product) {
//     cardWrapper.innerHTML += addItem(product);
// }


//Va a funcionar con la call al API
window.onload = function() {
    resultHeader.innerHTML = `Resultado de ${keyword}`; 
    // searchResult(keyword).then(data => resultItems(data));
}