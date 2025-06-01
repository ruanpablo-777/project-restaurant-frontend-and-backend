

fetch('http://localhost:3000/perfildousuario', {
    method: 'POST',
    credentials: 'include'
})
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao buscar a comida.')
        }
        return response.json()
    })
    .then(usuario => {
        console.log(usuario)})