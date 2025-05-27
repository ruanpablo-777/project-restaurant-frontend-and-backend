const urlParams = new URLSearchParams(window.location.search);
const comidaId = urlParams.get('id');
console.log('ID da comida:', comidaId);
const id = urlParams.toString().split('')[0]
//console.log(id); // Verifica se o ID está correto


fetch(`http://localhost:3000/api/comidas/${id}`)
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
        foodDiv.appendChild(comprarButton);

  
    })
    .catch(error => {
        console.error('Erro:', error);
    });