const urlParams = new URLSearchParams(window.location.search);
console.log(urlParams.toString()); // Verifica os parâmetros da URL
const paramsComida = urlParams.toString().split('=')[0]; // Extrai o ID da comida da URL
const id = urlParams.toString().split('=')[1]; // Extrai o ID da comida da URL
console.log(paramsComida)

fetch(`http://localhost:3000/${paramsComida}/${id}`)
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao buscar a comida');
        }
        return response.json();
    })
    .then(comida => {
        console.log('Comida:', comida);

        const foodDiv = document.querySelector('.comida-container');
        foodDiv.innerHTML = ''; // Limpar conteúdo existente

        const imagemDaComida = document.createElement('img');
         imagemDaComida.classList.add('image-food');
         imagemDaComida.src = comida.imagens;
        foodDiv.appendChild(imagemDaComida);
        
        const nomeDaComida = document.createElement('div');
        nomeDaComida.classList.add('nome-food');
        nomeDaComida.textContent = comida.nome;
        foodDiv.appendChild(nomeDaComida);
        
        
        const descricaoDaComida = document.createElement('div');
        descricaoDaComida.classList.add('descricao-food');
        descricaoDaComida.textContent = comida.descricao;
        foodDiv.appendChild(descricaoDaComida);

        const precoDaComida = document.createElement('div');
        precoDaComida.classList.add('preco-food');
        precoDaComida.textContent = `Preço: R$ ${comida.preco ? comida.preco.toFixed(2) : '0.00'}`;
        foodDiv.appendChild(precoDaComida);

        

        const comprarButton = document.createElement('button');
        comprarButton.classList.add('comprar-comida');
        comprarButton.textContent = 'Comprar';
        comprarButton.addEventListener('click', () => {
            // Aqui você pode adicionar a lógica para adicionar a comida ao carrinho
            alert(`Você comprou ${comida.nome}!`);
            window.location.href = `./carrinho.html?${paramsComida}=${comida.id}`; // Redireciona para a página do carrinho
        });
        foodDiv.appendChild(comprarButton);

  
    })
    .catch(error => {
        console.error('Erro:', error);
    });