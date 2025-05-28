const form = document.getElementById("form-cadastro");

form.addEventListener("submit", function (event) {
    event.preventDefault(); // Impede o formulário de recarregar a página

    const cliente = {
        nome: document.getElementById("nome").value,
        idade: parseInt(document.getElementById("idade").value),
        email: document.getElementById("email").value,
        senha: document.getElementById("senha").value,
        endereco: {
            cep: document.getElementById("cep").value,
            estado: document.getElementById("estado").value,
            cidade: document.getElementById("cidade").value,
            bairro: document.getElementById("bairro").value,
            rua: document.getElementById("rua").value,
            numero: document.getElementById("numero").value
        }
    };

    console.log("Enviando cliente:", cliente);

    fetch("http://localhost:3000/cliente/cadastrar", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
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
        form.reset();
    })
    .catch(error => {
        console.error("Erro:", error);
        alert("Erro ao cadastrar. Verifique o console.");
    });
});
