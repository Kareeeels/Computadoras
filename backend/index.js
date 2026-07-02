const express = require('express');
const cors = require('cors');

const app = express();
const PORT = process.env.PORT || 8080;

app.use(cors());
app.use(express.json());

// Base de datos en memoria
let computadoras = [];
let nextId = 1;

// Obtener todas las computadoras
app.get('/api/computadoras', (req, res) => {
  res.json(computadoras);
});

// Obtener una computadora por ID
app.get('/api/computadoras/:id', (req, res) => {
  const computadora = computadoras.find(c => c.id === parseInt(req.params.id));
  if (!computadora) {
    return res.status(404).json({ error: 'Computadora no encontrada' });
  }
  res.json(computadora);
});

// Crear una nueva computadora
app.post('/api/computadoras', (req, res) => {
  const { marca, modelo, precio, descripcion } = req.body;
  
  if (!marca || !modelo || !precio) {
    return res.status(400).json({ error: 'Marca, modelo y precio son obligatorios' });
  }
  
  const nuevaComputadora = {
    id: nextId++,
    marca,
    modelo,
    precio: parseFloat(precio),
    descripcion: descripcion || ''
  };
  
  computadoras.push(nuevaComputadora);
  res.status(201).json(nuevaComputadora);
});

// Actualizar una computadora
app.put('/api/computadoras/:id', (req, res) => {
  const id = parseInt(req.params.id);
  const index = computadoras.findIndex(c => c.id === id);
  
  if (index === -1) {
    return res.status(404).json({ error: 'Computadora no encontrada' });
  }
  
  const { marca, modelo, precio, descripcion } = req.body;
  
  if (!marca || !modelo || !precio) {
    return res.status(400).json({ error: 'Marca, modelo y precio son obligatorios' });
  }
  
  computadoras[index] = {
    id,
    marca,
    modelo,
    precio: parseFloat(precio),
    descripcion: descripcion || ''
  };
  
  res.json(computadoras[index]);
});

// Eliminar una computadora
app.delete('/api/computadoras/:id', (req, res) => {
  const id = parseInt(req.params.id);
  const index = computadoras.findIndex(c => c.id === id);
  
  if (index === -1) {
    return res.status(404).json({ error: 'Computadora no encontrada' });
  }
  
  computadoras.splice(index, 1);
  res.status(204).send();
});

app.listen(PORT, () => {
  console.log(`Servidor corriendo en el puerto ${PORT}`);
});
