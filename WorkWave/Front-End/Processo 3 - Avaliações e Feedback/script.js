const express = require('express');
const path = require('path');
const app = express();
const PORT = process.env.PORT || 3000;

app.use(express.static('public'));

// Rota para anexar-imagem.html
app.get('/anexar-imagem', (req, res) => {
    res.sendFile(path.join(__dirname, 'anexar-imagem.html'));
});

// Rota para aprimorar-trabalho.html
app.get('/aprimorar-trabalho', (req, res) => {
    res.sendFile(path.join(__dirname, 'aprimorar-trabalho.html'));
});

// Rota para aprimorar.html
app.get('/aprimorar', (req, res) => {
    res.sendFile(path.join(__dirname, 'aprimorar.html'));
});

// Rota para feedback.html
app.get('/feedback', (req, res) => {
    res.sendFile(path.join(__dirname, 'feedback.html'));
});

app.listen(PORT, () => {
    console.log(`Servidor rodando na porta ${PORT}`);
});

