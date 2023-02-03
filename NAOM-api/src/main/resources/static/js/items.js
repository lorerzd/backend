export function addItem(product) {
  return `
    <div class="swiper-slide">
    <img src="${product.foto}" "class="card-img-top" alt="image">
    <div class="card-body"><br>
    <div class="hearts-outer">
            <div class="hearts-inner" style="width:100%;"></div>
        </div>
        <div class="card-title">
        <p class="card-title"><font color="#1C315E">${product.nombre.slice(
          0,
          53
        )}...</font></p>
        </div>

        <div class="card-price">$${product.precio}</div>
    </div>
    <a href="#" id="${
      product.id
    }" class="addCartProd mt-1 mb-2 position-relative bottom-0" type="submit"><strong>Agregar al carrito</a>
    </div>
    `;
}

export function addItems(product) {
  return `
    <div class="card col-xl-2 col-lg-3 col-sm-5 col-10  my-2 mx-2" >
    <div class="text-center">
    <img src="${product.foto}" "class="card-img-top" alt="image">
    </div>
    <div class="card-body"><br>
    <div class="hearts-outer">
            <div class="hearts-inner" style="width:100%;"></div>
        </div>
        <div class="card-title text-center">
        <p class="card-text mb-3"><font color="#1C315E">${product.nombre}</font></p>
        </div>

        <div class="card-price">$${product.precio}</div>
    </div>
    <a href="#" id="${product.id}" class="addCartProd mt-1 mb-2 position-relative bottom-0" type="submit">Agregar al carrito</strong></a>
    </div>
    `;
}

export function addTableRows(product) {
  return `
    <tr>
    <td>${product.id}</td>
    <td>${product.nombre}</td>
    <td>${product.precio}</td>
    <td>${product.descripcion}</td>
    <td>${product.stock}</td>
    <td class="justify-content-around">
      <button class="col-12 my-2 crud" id="update-${product.id}">Editar</button>
      <button class="col-12 crud" id="delete-${product.id}">Borrar</button>
    </td>
    </tr>
    `;
}

export function addProductCart(product,cantidad) {
  return `
  <div class="article" id="product#${product.id}">
          <img class="img-article" src="${product.foto}" alt="">
          <div class="purchase-info">
              <div class="article-info">
                <p class="article-title">${product.nombre}</p>
                <p class="article-name">${product.descripcion.slice(0,35)}...</p>
              </div>
              <div class="delete">
                <span class="material-symbols-rounded" role="button" id="delete${product.id}">delete</span>
              </div>
              <div class="article-total">
                <p>Cantidad: ${cantidad}</p>
                <p class="total-price">$${product.precio*cantidad}</p>
              </div>
              <div class="btnIncDec">
                <div class="btn-commands">
                  <span class="minus" id="minus-${product.id}">-</span>
                  <span class="num" id="count-${cantidad}">${cantidad}</span>
                  <span class="plus" id="plus-${product.id}">+</span>
                </div>
              </div>
          </div>
        </div>
  
  `;
}

export async function getAllProducts() {
  const response = await fetch("http://localhost:8080/api/productos/", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  });
  return response;
}

export async function getProducts(id) {
  const response = await fetch(
    `http://localhost:8080/api/productos/all/${id}`,
    {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    }
  );
  return response;
}

export async function addProduct(product, token) {
  const response = await fetch("http://localhost:8080/api/productos", {
    method: "POST",
    body: JSON.stringify(product),
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer: ${token.replaceAll('"', "")}`,
    },
  });
  return response;
}

export async function deleteProduct(id, token) {
  const response = await fetch(`http://localhost:8080/api/productos/${id}`, {
    method: "DELETE",
    headers: {
      Authorization: `Bearer: ${token.replaceAll('"', "")}`,
    },
  });
  return response;
}

export async function updateProduct(id, product, token) {
  const response = await fetch(`http://localhost:8080/api/productos/${id}`, {
    method: "PUT",
    body: JSON.stringify(product),
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer: ${token.replaceAll('"', "")}`,
    },
  });
  return response;
}

//Se va a implementar cuando el API este funcional.
// export async function searchResult(keyword){
//     return fetch("APIURL"+keyword);
//
