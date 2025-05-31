async function carregarCardapioCompleto() {
    try {
        const endpoints = [
            { url: 'http://localhost:3000/pratoprincipal', nome: 'Pratos' },
            { url: 'http://localhost:3000/bebida', nome: 'Bebidas' },
            { url: 'http://localhost:3000/sobremesa', nome: 'Sobremesas' } // Se tiver
        ];

        const cardapioDiv = document.querySelector('.cardapio');
        cardapioDiv.innerHTML = ''; // Limpa antes de renderizar
        for (const endpoint of endpoints) {
            const response = await fetch(endpoint.url);
            const itens = await response.json();
            
            console.log(itens)
            // Agrupar por tipo (se houver tipos dentro de cada categoria)
            const grupos = {};

            itens.forEach(item => {
                const tipo = item.tipo || endpoint.nome; // Se não tiver tipo, usa o nome do endpoint
                if (!grupos[tipo]) {
                    grupos[tipo] = [];
                }
                grupos[tipo].push(item);
            });

            // Renderiza cada grupo
            for (const tipo in grupos) {
                const grupoItens = grupos[tipo];

                const foodDiv = document.createElement('div');
                foodDiv.classList.add('food');

                const h2 = document.createElement('h2');
                h2.classList.add('tipo-da-comida');
                h2.textContent = tipo;
                console.log(tipo)
                foodDiv.appendChild(h2);

                const grupoItemCardapio = document.createElement('div');
                grupoItemCardapio.classList.add(tipo);
                

                grupoItens.forEach(item => {
                    const itemCardapio = document.createElement('div');
                    itemCardapio.classList.add('item-cardapio');

                    const img = document.createElement('img');
                    img.classList.add('image-food');
                    img.src = item.imagens;
                    img.alt = item.nome;
                    itemCardapio.appendChild(img);

                    const infoFood = document.createElement('div');
                    infoFood.classList.add('info-food');

                    const h3 = document.createElement('h3');
                    h3.textContent = item.nome;
                    infoFood.appendChild(h3);

                    const pDescricao = document.createElement('p');
                    pDescricao.textContent = item.descricao;
                    infoFood.appendChild(pDescricao);

                    const pPreco = document.createElement('p');
                    pPreco.textContent = `Preço: R$ ${item.preco ? item.preco.toFixed(2) : '0.00'}`;
                    infoFood.appendChild(pPreco);

                    itemCardapio.appendChild(infoFood);

                    const nota = document.createElement('div');
                    nota.classList.add('nota');
                    nota.textContent = item.nota || '5.0';
                    itemCardapio.appendChild(nota);

                    const linkItem = document.createElement('a');
                    grupoItemCardapio.addEventListener('click', function() {
                    console.log(`Clicou no grupo: ${tipo}`);
                    linkItem.href = `./comida.html?${tipo}=${item.id}`;
                })
                    linkItem.appendChild(itemCardapio);

                    grupoItemCardapio.appendChild(linkItem);
                });

                foodDiv.appendChild(grupoItemCardapio);
                cardapioDiv.appendChild(foodDiv);
            }
        }
    } catch (error) {
        console.error('Erro ao carregar cardápio:', error);
    }
}

carregarCardapioCompleto();
