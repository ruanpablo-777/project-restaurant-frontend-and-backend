const buttonSwitchTheme = document.querySelector('.switch-theme');
const bodyLogin = document.querySelector('.light');


buttonSwitchTheme.addEventListener('click', () => {
        bodyLogin.classList.toggle('dark-mode');
})
