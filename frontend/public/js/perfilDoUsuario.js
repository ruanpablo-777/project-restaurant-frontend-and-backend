const API_URL="https://project-restaurant-backend-gn0j.onrender.com"


fetch(`${API_URL}/perfildousuario`, {
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
        console.log(usuario)
        const nomeUsuario = document.querySelector('.nome-do-usuario');
        nomeUsuario.textContent = usuario.perfilDoUsuario.nome;

        const emailUsuario = document.querySelector('.email-do-usuario');
        emailUsuario.textContent = usuario.perfilDoUsuario.email;

        const idadeUsuario = document.querySelector('.idade-do-usuario');
        idadeUsuario.textContent = usuario.perfilDoUsuario.idade;

        const enderecoUsuario = document.querySelector('.endereco-do-usuario');
        enderecoUsuario.textContent = usuario.perfilDoUsuario.endereco.rua + ', ' + usuario.perfilDoUsuario.endereco.numero + ' - ' + usuario.perfilDoUsuario.endereco.bairro + ' - ' + usuario.perfilDoUsuario.endereco.cidade + ' - ' + usuario.perfilDoUsuario.endereco.estado;


    })


const editarPerfilButton = document.getElementById('editarPerfil');
editarPerfilButton.addEventListener('click', () => {
    editarPerfil();
});

function editarPerfil() {

    const perfilDoUsuario = document.getElementById('profile-container');
    const editandoPerfil = document.getElementById('editando-perfil');

    perfilDoUsuario.style.display = 'none';
    editandoPerfil.style.display = 'flex';
}   

function salvarEdicao() {

 const perfilDoUsuario = document.getElementById('profile-container');
    const editandoPerfil = document.getElementById('editando-perfil');

    perfilDoUsuario.style.display = 'flex';
    editandoPerfil.style.display = 'none';

      const cliente = {
        nome: document.getElementById("nome").value,
        idade: parseInt(document.getElementById("idade").value),
        email: document.getElementById("email").value
        
        }
    

      console.log("Enviando cliente:", cliente);

    fetch("http://localhost:3000/editarperfil", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        credentials: 'include', // Inclui cookies na requisição
        body: JSON.stringify(cliente)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro na requisição');
        }
        return response.json();
    })
    .then(data => {
        console.log("Resposta do servidor:", data);
        alert("Cadastro realizado com sucesso!");
    })
    .catch(error => {
        console.error("Erro:", error);
        alert("Erro ao cadastrar. Verifique o console.");
    });
    
}

function deletarPerfil() {
    fetch("http://localhost:3000/deletarperfil", {
        method: "DELETE",
        credentials: 'include' // Inclui cookies na requisição
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao deletar o perfil');
        }
        return response.json();
    })
    .then(data => {
        console.log("Perfil deletado:", data);
        alert("Perfil deletado com sucesso!");
        window.location.href = './index.html'; // Redireciona para a página inicial
    })
    .catch(error => {
        console.error("Erro:", error);
        alert("Erro ao deletar o perfil. Verifique o console.");
    });
}