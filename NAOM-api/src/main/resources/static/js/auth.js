export async function userRegister(registro){
    const response = await fetch('http://localhost:8080/api/auth/register', {
      method: 'POST',
      body: JSON.stringify(registro),
      headers: {
        'Content-Type': 'application/json'
      }
    })
    return response;
}


export async function userLogin(login){
    const response = await fetch('http://localhost:8080/api/auth/login', {
      method: 'POST',
      body: JSON.stringify(login),
      headers: {
        'Content-Type': 'application/json'
      }
    })
    return response;
}

export async function userAdminLogin(login){
  const response = await fetch('http://localhost:8080/api/auth/login/w3b0s', {
    method: 'POST',
    body: JSON.stringify(login),
    headers: {
      'Content-Type': 'application/json'
    }
  })
  return response;
}

export async function getUser(token){
    const response = await fetch('http://localhost:8080/api/usuario', {
      method: 'GET',
      headers: {
        'Authorization': `Bearer: ${token.replaceAll('"',"")}`
      }
    })
    return response;
}