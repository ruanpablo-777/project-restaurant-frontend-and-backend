document.getElementById('login-form').addEventListener('submit', async function (e) {
    e.preventDefault();

    const email = document.getElementById('username').value;
    const senha = document.getElementById('password').value;

    try {
        const resposta = await fetch('http://localhost:3000/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            credentials: 'include',
            body: JSON.stringify({ email, senha })
        });

        const resultado = await resposta.text();

        if (resposta.ok) {
            alert("Login realizado com sucesso!");
            // Redirecionar para outra página
            window.location.href = "./pages/restaurante.html";
        } else {
            alert("Erro: " + resultado);
        }
    } catch (err) {
        alert("Erro de conexão com o servidor.");
        console.error(err);
    }
});
