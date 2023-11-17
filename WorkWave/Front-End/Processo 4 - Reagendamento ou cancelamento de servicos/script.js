document.addEventListener("DOMContentLoaded", function () {
    carregarServicos();
});

// Função para gerar serviços aleatórios
function gerarServicosAleatorios() {
    const servicos = [];

    for (let i = 1; i <= 7; i++) {
        const servico = {
            nome: `Serviço ${i}`,
            categoria: "Categoria Aleatória",
            valor: (Math.random() * 100 + 20).toFixed(2), // Valor aleatório entre 20 e 119
            data: `2023-11-${Math.floor(Math.random() * 30) + 1}`,
            hora: `${Math.floor(Math.random() * 24).toString().padStart(2, '0')}:${Math.floor(Math.random() * 60).toString().padStart(2, '0')}`,
            profissional: "Profissional Aleatório"
        };

        servicos.push(servico);
    }

    return servicos;
}


// Função para obter serviços do armazenamento local (localStorage)
function obterServicos() {
    const servicos = JSON.parse(localStorage.getItem("servicos")) || [];
    return servicos;
}

// Função para salvar serviços no armazenamento local (localStorage)
function salvarServicos(servicos) {
    localStorage.setItem("servicos", JSON.stringify(servicos));
}

function carregarServicos() {
    const servicosContainer = document.getElementById("servicos-container");
    servicosContainer.innerHTML = ""; // Limpar o conteúdo anterior

    const servicos = obterServicos();

    servicos.forEach((servico, index) => {
        const servicoContainer = criarServicoContainer(servico, index);
        servicosContainer.appendChild(servicoContainer);
    });
}

function criarServicoContainer(servico, index) {
    const servicoContainer = document.createElement("div");
    servicoContainer.className = "servico-container";

    servicoContainer.innerHTML = `
        <p>${servico.nome} - Categoria: ${servico.categoria}</p>
        <p>Valor: R$${servico.valor.toFixed(2)}</p>
        <p>Data: ${servico.data}</p>
        <p>Hora: ${servico.hora}</p>
        <p>Profissional: ${servico.profissional}</p>
        <button class="reagendar" data-index="${index}">Reagendar</button>
        <button class="cancelar" data-index="${index}">Cancelar</button>
    `;

    const reagendarButton = servicoContainer.querySelector(".reagendar");
    const cancelarButton = servicoContainer.querySelector(".cancelar");

    reagendarButton.addEventListener("click", reagendarServico);
    cancelarButton.addEventListener("click", cancelarServico);

    return servicoContainer;
}

function reagendarServico(event) {
    const index = event.target.getAttribute("data-index");
    const servicos = obterServicos();

    const novaData = prompt("Insira a nova data (AAAA-MM-DD):");
    const novaHora = prompt("Insira a nova hora (HH:MM):");

    if (novaData && novaHora) {
        servicos[index].data = novaData;
        servicos[index].hora = novaHora;

        salvarServicos(servicos);

        carregarServicos();
    }
}

function cancelarServico(event) {
    const index = event.target.getAttribute("data-index");
    const servicos = obterServicos();

    servicos.splice(index, 1);

    salvarServicos(servicos);

    carregarServicos();
}
// Importar módulos necessários
const express = require('express');
const bodyParser = require('body-parser');

// Criar uma instância do aplicativo Express
const app = express();

// Configurar o middleware para analisar corpos de solicitação JSON
app.use(bodyParser.json());

// Definir uma rota para receber dados do front-end
app.post('/api/servicos', (req, res) => {
    // Os dados do serviço estarão em req.body
    const novoServico = req.body;

    // Aqui pode salvar o novo serviço no seu sistema de armazenamento (banco de dados, por exemplo)
    // Exemplo: salvarServicoNoBancoDeDados(novoServico);

    // Responder ao front-end que o serviço foi adicionado com sucesso
    res.status(201).json({ mensagem: 'Serviço adicionado com sucesso!' });
});

// Iniciar o servidor na porta 3000
const porta = 3000;
app.listen(porta, () => {
    console.log(`Servidor rodando na porta ${porta}`);
});

function reagendarServico(event) {
    const index = event.target.getAttribute("data-index");
    const servicos = obterServicos();

    const novaData = prompt("Insira a nova data (AAAA-MM-DD):");
    const novaHora = prompt("Insira a nova hora (HH:MM):");

    if (novaData && novaHora) {
        servicos[index].data = novaData;
        servicos[index].hora = novaHora;

        // Enviar os novos dados para o back-end
        fetch('/api/servicos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(servicos[index]),
        })
        .then(response => response.json())
        .then(data => {
            console.log(data);
            // Atualizar os serviços após o sucesso da solicitação
            salvarServicos(servicos);
            carregarServicos();
        })
        .catch(error => {
            console.error('Erro ao reagendar serviço:', error);
        });
    }
}
