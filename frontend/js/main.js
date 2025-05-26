function logar(data, nome ,senha) {
   data.forEach((element) => {
        if(nome === element.nome && senha === element.senha){
            window.location.href = "./pages/restaurante.html"
        }
    });

    //console.log()
}