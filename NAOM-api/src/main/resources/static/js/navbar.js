let toggleUserView = document.getElementsByClassName("toggleUserView");
let searchButton = document.getElementById("searchButton");
let searchBar = document.getElementById("searchBar");

if(localStorage.getItem("token")){
  toggleUserView[0].innerHTML = "Mi cuenta";
  toggleUserView[0].href = "../HTML/usuario.html";
  toggleUserView[1].innerHTML = "Cerrar sesión";
  toggleUserView[1].href = "../HTML/logIn.html";
}

toggleUserView[1].addEventListener("click", () => {
  localStorage.removeItem("token");
})

searchButton.addEventListener("click", (e) => {
  e.preventDefault();
  if(searchBar.value.length > 2){
    let url = `../HTML/searchResult.html?busqueda=${searchBar.value}`;
    window.location.href = url;
  }else{
    searchBar.style.border = "1px solid red";
  }
})

