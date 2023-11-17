const express = require('express');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

// Middleware to parse incoming JSON data
app.use(bodyParser.json());

// Route for Detalhar Serviço
app.post('/detalhar-servico', (req, res) => {
  // Handle the Detalhar Serviço form submission
  // You can access form data from req.body
  const { area, especificacao, metodoTrabalho, cargaHoraria, descricao } = req.body;
  
  // Process the data as needed
  
  // Respond with a success or error message
  res.json({ message: 'Detalhar Serviço form submitted successfully' });
});

// Route for Adicionar Fotos
app.post('/adicionar-fotos', (req, res) => {
  // Handle the Adicionar Fotos form submission
  // You can access form data from req.body
  const { fotos } = req.body;

  // Process the data as needed

  // Respond with a success or error message
  res.json({ message: 'Adicionar Fotos form submitted successfully' });
});

// Route for Verificar Conteúdo
app.post('/verificar-conteudo', (req, res) => {
  // Handle the Verificar Conteúdo form submission
  // You can access form data from req.body
  const { orientacao } = req.body;

  // Process the data as needed

  // Respond with a success or error message
  res.json({ message: 'Verificar Conteúdo form submitted successfully' });
});

// Route for Confirmar Publicação
app.post('/confirmar-publicacao', (req, res) => {
  // Handle the Confirmar Publicação form submission
  // You can access form data from req.body
  const { termoCompromisso } = req.body;

  // Process the data as needed

  // Respond with a success or error message
  res.json({ message: 'Confirmar Publicação form submitted successfully' });
});

// Route for Notificar Erro sobre as Fotos
app.post('/notificar-erro-fotos', (req, res) => {
  // Handle the Notificar Erro sobre as Fotos form submission
  // You can access form data from req.body
  const { detalhesBloqueio } = req.body;

  // Process the data as needed

  // Respond with a success or error message
  res.json({ message: 'Notificar Erro sobre as Fotos form submitted successfully' });
});

// Start the server
app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
