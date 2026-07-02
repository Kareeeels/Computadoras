# Proyecto de Marcas de Computadoras

Proyecto completo con frontend HTML, backend Spring Boot y base de datos H2 en memoria.

## Estructura del Proyecto

```
Computadoras/
├── backend/          # Backend Spring Boot
├── frontend/         # Frontend HTML
└── README.md
```

## Requisitos

- Java 17 o superior
- Maven

## Instrucciones de Ejecución

### 1. Ejecutar el Backend Spring Boot

Ve al directorio del backend y ejecuta:

```bash
cd backend
mvn spring-boot:run
```

El backend se ejecutará en `http://localhost:8080`

### 2. Abrir H2 Console (opcional)

Para ver la base de datos:
- Abre tu navegador y ve a `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:computadorasdb`
- **User Name**: `sa`
- **Password**: (dejar vacío)
- Clic en "Connect"

### 3. Abrir el Frontend

Abre el archivo `frontend/index.html` en tu navegador web.

## Funcionalidades CRUD

- **Crear**: Llenar el formulario y hacer clic en "Guardar"
- **Leer**: Ver la lista de computadoras en la tabla
- **Actualizar**: Hacer clic en "Editar", modificar los datos y guardar
- **Eliminar**: Hacer clic en "Eliminar" y confirmar

## Endpoints API REST

- `GET /api/computadoras` - Obtener todas las computadoras
- `GET /api/computadoras/{id}` - Obtener una computadora por ID
- `POST /api/computadoras` - Crear una nueva computadora
- `PUT /api/computadoras/{id}` - Actualizar una computadora
- `DELETE /api/computadoras/{id}` - Eliminar una computadora
