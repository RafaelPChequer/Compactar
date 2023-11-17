    function paraCadastro() {
        var select = document.querySelector('select');
        var selectedOption = select.options[select.selectedIndex].value;

        if (selectedOption === "Cliente Comum") {
            window.location.href = "../HTML/Cadastro.html";
        } else if (selectedOption === "Trabalhador Autônomo") {
            window.location.href = "./CadastroAutonomo.html";
        }
    }

    function showUserTypeFields() {
        var userTypeSelect = document.getElementById("userType");
        var userTrabalhadorFields = document.getElementById("userTrabalhadorFields");

        if (userTypeSelect.value === "trabalhador") {
            userTrabalhadorFields.style.display = "block";
        } else {
            userTrabalhadorFields.style.display = "none";
        }
    }

const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const port = 3000; // Escolha a porta que desejar

// Middleware para analisar dados do corpo do formulário
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// Rota para lidar com o envio do formulário
app.post('/cadastrar-usuario', (req, res) => {
    // Recuperar dados do corpo da solicitação
    const userData = req.body;

    // Faça o que quiser com os dados (por exemplo, armazenar em um banco de dados)
    console.log('Dados do usuário:', userData);

    // Envie uma resposta de volta ao cliente (pode ser uma página HTML, JSON, etc.)
    res.send('Usuário cadastrado com sucesso!');
});

// Inicie o servidor
app.listen(port, () => {
    console.log(`Servidor rodando em http://localhost:${port}`);
});
