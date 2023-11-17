const searchForm = document.getElementById("search-form");
const categoriaInput = document.getElementById("categoria");
const profileCards = document.getElementById("profile-cards");

const perfisCorrespondentes = [
    {
        id: 1,
        nome: "Prestador 1",
        categoria: "Limpeza",
        servico: "Serviço de Limpeza Profissional",
    },
    {
        id: 2,
        nome: "Prestador 2",
        categoria: "Construção",
        servico: "Construção de Casas e Renovações",
    },
    {
        id: 3,
        nome: "Prestador 3",
        categoria: "Manutenção",
        servico: "Manutenção de Aparelhos/Utensílios Domésticos",
    },
];

searchForm.addEventListener("submit", function (event) {
    event.preventDefault();
    const categoriaSelecionada = categoriaInput.value;

    const resultados = buscarPerfis(categoriaSelecionada);

    updateVisualizarPerfis(resultados);
});

function buscarPerfis(categoriaSelecionada) {
    const resultados = perfisCorrespondentes.filter((perfil) => {
        return perfil.categoria === categoriaSelecionada;
    });

    return resultados;
}

function updateVisualizarPerfis(resultados) {
    profileCards.innerHTML = "";

    if (resultados.length === 0) {
        profileCards.innerHTML = "<p>Nenhum resultado encontrado</p>";
    } else {
        resultados.forEach((perfil) => {
            const card = document.createElement("div");
            card.classList.add("profile-card");
            card.innerHTML = `
            <div class="card" style="width: 18rem;">
                <img src="" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${perfil.nome}</h5>
                    <p>Categoria: ${perfil.categoria}</p>
                    <p>Serviço: ${perfil.servico}</p>
                    <button type="button" onclick="selecionarServico('${perfil.id}')" class="btn btn-primary">Selecionar Serviço</button>
                </div>
            </div>`;

            profileCards.appendChild(card);
        });
    }
}

function selecionarServico(idPerfil) {
    window.location.href = "agendamentoServico.html";
}

const express = require('express');
const app = express();
const path = require('path');

app.use(express.static('public'));

app.get('/buscar-servico', (req, res) => {
    res.sendFile(path.join(__dirname, 'buscarServico.html'));
});

app.get('/agendamento', (req, res) => {
    res.sendFile(path.join(__dirname, 'agendamento.html'));
});

app.get('/analisar-solicitacao', (req, res) => {
    res.sendFile(path.join(__dirname, 'analisarSolicitacao.html'));
});

const PORT = process.env.PORT || 3000;

app.listen(PORT, () => {
    console.log(`Servidor rodando na porta ${PORT}`);
});

