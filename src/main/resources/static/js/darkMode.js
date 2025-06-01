

// Ao carregar a página, verifica se estava no modo escuro
window.onload = () => {
  const darkMode = localStorage.getItem('darkMode');
  if (darkMode === 'enabled') {
    document.body.classList.add('dark-mode');
  }
}

// Função para alternar o modo escuro
function toggleDarkMode() {
  const darkMode = localStorage.getItem('darkMode');

  if (darkMode !== 'enabled') {
    document.body.classList.add('dark-mode');
    localStorage.setItem('darkMode', 'enabled');
  } else {
    document.body.classList.remove('dark-mode');
    localStorage.setItem('darkMode', null);
  }
}
