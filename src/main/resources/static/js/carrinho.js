

const urlParams = new URLSearchParams(window.location.search);
const comidaId = urlParams.get('id');
console.log(comidaId);

fetch(`http://localhost:3000/api/comidas/${comidaId}`)
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao buscar a comida.')
        }
        return response.json()
    })
    .then(comida => {
        console.log(comida)
        
        // Mock para a imagem da comida
        const valorDaComida = document.querySelector('.price');
        valorDaComida.textContent = comida.preco.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });   
        
        // Mock para o nome da comida
        const pedidoDoCliente = document.querySelector('.pedido');
        pedidoDoCliente.textContent = comida.nome;

        // Mock para o cálculo do subtotal
        const subTotal = document.querySelector('.subtotal');
        subTotal.textContent = comida.preco.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });


        let taxa = Math.floor(Math.random()*2.1) // Mock para o cálculo da taxa de entrega
        const taxaDeEntrega = document.querySelector('.taxa');
        taxaDeEntrega.textContent = (taxa).toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });

        // Mock para o cálculo do total do pedido
        const totalPedido = document.querySelector('.total-pedido');
        totalPedido.textContent = (comida.preco + taxa).toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
    })
    .catch(error => {
        console.error('Erro ao buscar a comida:', error)
    })

fetch("http://localhost:3000/cliente/comprar", {
    method: "POST",
    credentials: "include", // Inclui cookies na requisição
})
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao buscar o carrinho')

        }
        return response.json();
    })
    .then(carrinho => {
        console.log(carrinho);

        //rua do cliente
        const ruanDoCliente = document.querySelector('.street')
        ruanDoCliente.textContent = carrinho.enderecoEntrega.rua

        const cidadeDoCliente = document.querySelector('.city')
        cidadeDoCliente.textContent = carrinho.enderecoEntrega.cidade

    })
    .catch(error => {
        console.error('Erro:', error);
        alert("Erro ao buscar o carrinho. Verifique o console.");
    })