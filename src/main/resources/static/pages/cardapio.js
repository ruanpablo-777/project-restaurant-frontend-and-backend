async function carregarCardapio() {
    try {
        const response = await fetch('http://localhost:3000/api/cardapio');
        const comidas = await response.json();

        const cardapioDiv = document.querySelector('.cardapio');
        cardapioDiv.innerHTML = ''; // limpar conteúdo existente

        // Agrupar por tipo da comida
        const grupos = {};

        comidas.forEach(comida => {
            if (!grupos[comida.tipo]) {
                grupos[comida.tipo] = [];
            }
            grupos[comida.tipo].push(comida);
        });
        console.log(comidas);

        for (const tipo in grupos) {
            const grupoComidas = grupos[tipo];

            const foodDiv = document.createElement('div');
            foodDiv.classList.add('food');

            const h2 = document.createElement('h2');
            h2.classList.add('tipo-da-comida');
            h2.textContent = tipo;
            foodDiv.appendChild(h2);

            const grupoItemCardapio = document.createElement('div');
            grupoItemCardapio.classList.add('grupo-item-cardapio');

            grupoComidas.forEach(comida => {
                const itemCardapio = document.createElement('div');
                itemCardapio.classList.add('item-cardapio');

                const img = document.createElement('img');
                img.classList.add('image-food');
                img.src = comida.imagens;
                img.alt = comida.nome;
                itemCardapio.appendChild(img);

                const infoFood = document.createElement('div');
                infoFood.classList.add('info-food');

                const h3 = document.createElement('h3');
                h3.textContent = comida.nome;
                infoFood.appendChild(h3);

                const pDescricao = document.createElement('p');
                pDescricao.textContent = comida.descricao;
                infoFood.appendChild(pDescricao);

                const pPreco = document.createElement('p');
              pPreco.textContent = `Preço: R$ ${comida.preco ? comida.preco.toFixed(2) : '0.00'}`;

                infoFood.appendChild(pPreco);

                itemCardapio.appendChild(infoFood);

                const nota = document.createElement('div');
                nota.classList.add('nota');
                nota.textContent = comida.nota
                itemCardapio.appendChild(nota);

                const linkComida = document.createElement('a');
                linkComida.href = `http://localhost:3000/api/comida/${comida.id}`;
                linkComida.appendChild(itemCardapio);
                grupoItemCardapio.appendChild(linkComida);

            });

            foodDiv.appendChild(grupoItemCardapio);
            cardapioDiv.appendChild(foodDiv);
        }

    } catch (error) {
        console.error('Erro ao carregar cardápio:', error);
    }
}

carregarCardapio();
