# Sistema de Gestión de Eventos y Venues - Arquitectura Hexagonal

## 📋 Descripción del Proyecto

Sistema de gestión de eventos y venues implementado con **Arquitectura Hexagonal (Puertos y Adaptadores)** utilizando una **arquitectura híbrida de bases de datos**: MongoDB para Venues y MySQL para Events. El proyecto sigue las mejores prácticas de diseño de software, separación de responsabilidades y principios SOLID.

## 🏗️ Arquitectura

### Arquitectura Hexagonal

El proyecto está organizado en tres capas principales:

```
eventos.catalogos/
├── domain/                    # Núcleo del negocio
│   ├── model/                # Entidades de dominio puras
│   │   ├── Venue.java
│   │   └── Event.java
│   └── ports/                # Interfaces (contratos)
│       ├── in/               # Puertos de entrada (Use Cases)
│       │   ├── VenueUseCase.java
│       │   └── EventUseCase.java
│       └── out/              # Puertos de salida (Repositorios)
│           ├── VenueRepositoryPort.java
│           └── EventRepositoryPort.java
├── application/              # Lógica de aplicación
│   └── services/            # Implementación de Use Cases
│       ├── VenueService.java
│       └── EventService.java
└── infrastructure/          # Adaptadores externos
    ├── controllers/         # API REST
    │   ├── VenueController.java
    │   └── EventController.java
    ├── dto/                 # Data Transfer Objects
    │   ├── VenueRequest.java
    │   ├── VenueResponse.java
    │   ├── EventRequest.java
    │   ├── EventResponse.java
    │   └── mapper/
    │       ├── VenueDTOMapper.java
    │       └── EventDTOMapper.java
    ├── entities/            # Entidades de persistencia
    │   ├── VenueDocument.java    # MongoDB
    │   ├── EventEntity.java      # MySQL/JPA
    │   └── mapper/
    │       ├── VenueMapper.java
    │       └── EventMapper.java
    └── repository/          # Adaptadores de persistencia
        ├── MongoVenueRepository.java
        ├── VenueRepositoryAdapter.java
        ├── JpaEventRepository.java
        └── EventRepositoryAdapter.java
```

### Arquitectura Híbrida de Bases de Datos

- **Venues**: Almacenados en **MongoDB** (Base de datos NoSQL orientada a documentos)
  - Colección: `venues`
  - Puerto: `27018`
  - Ideal para datos flexibles y escalabilidad horizontal

- **Events**: Almacenados en **MySQL** (Base de datos relacional)
  - Tabla: `events`
  - Puerto: `3309`
  - Gestión con Flyway para migraciones versionadas
  - Relación lógica con Venues mediante `venueId` (String)

## 🚀 Tecnologías

- **Java 17**
- **Spring Boot 3.5.7**
  - Spring Web
  - Spring Data JPA
  - Spring Data MongoDB
- **MySQL 8.0** (Base de datos relacional)
- **MongoDB** (Base de datos NoSQL)
- **Flyway** (Migraciones de base de datos)
- **Maven** (Gestión de dependencias)
- **Docker & Docker Compose** (Contenedorización)

## 📦 Características Principales

### Separación de Responsabilidades

1. **DTOs (Data Transfer Objects)**: Separan la capa de presentación del dominio
2. **Use Cases**: Definen los casos de uso del sistema como interfaces
3. **Servicios**: Implementan la lógica de negocio y los Use Cases
4. **Mappers**: Transforman entre DTOs ↔ Domain ↔ Entities
5. **Controladores**: Exponen la API REST usando DTOs

### Validación y Transaccionalidad

- `@Transactional` en servicios para garantizar ACID
- `readOnly = true` para operaciones de lectura
- Validación de relaciones entre Events y Venues

## 🔌 API Endpoints

### Venues (MongoDB)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/venues` | Crear un nuevo venue |
| `GET` | `/api/venues` | Listar todos los venues |
| `GET` | `/api/venues/{id}` | Obtener un venue por ID |
| `DELETE` | `/api/venues/{id}` | Eliminar un venue |

**Ejemplo Request (POST /api/venues)**:
```json
{
  "name": "Estadio Nacional",
  "location": "Bogotá, Colombia",
  "capacity": 50000
}
```

**Ejemplo Response**:
```json
{
  "id": "674532a1b2c3d4e5f6789012",
  "name": "Estadio Nacional",
  "location": "Bogotá, Colombia",
  "capacity": 50000
}
```

### Events (MySQL)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/events` | Crear un nuevo evento |
| `GET` | `/api/events` | Listar todos los eventos |
| `GET` | `/api/events/{id}` | Obtener un evento por ID |
| `DELETE` | `/api/events/{id}` | Eliminar un evento |
| `GET` | `/api/events/venue/{venueId}` | Listar eventos por venue |

**Ejemplo Request (POST /api/events)**:
```json
{
  "name": "Concierto de Rock",
  "date": "2025-12-31T20:00:00",
  "status": "ACTIVE",
  "venueId": "674532a1b2c3d4e5f6789012"
}
```

**Ejemplo Response**:
```json
{
  "id": 1,
  "name": "Concierto de Rock",
  "date": "2025-12-31T20:00:00",
  "status": "ACTIVE",
  "venueId": "674532a1b2c3d4e5f6789012"
}
```

## ⚙️ Configuración

### Requisitos Previos

- JDK 17+
- Docker y Docker Compose
- Maven 3.8+

### Variables de Entorno

El archivo `application.properties` contiene:

```properties
server.port=8081

# MySQL Configuration
spring.datasource.url=jdbc:mysql://127.0.0.1:3309/db_users_hexagonal
spring.datasource.username=root
spring.datasource.password=123456

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true

# Flyway
spring.flyway.enabled=true

# MongoDB Configuration
spring.data.mongodb.uri=mongodb://localhost:27018/db_venues_mongo
```

## 🐳 Ejecución con Docker

### 1. Levantar las bases de datos

```bash
docker compose up -d
```

Esto iniciará:
- MySQL en puerto `3309`
- MongoDB en puerto `27018`

### 2. Ejecutar la aplicación

```bash
./mvnw spring-boot:run
```

La aplicación estará disponible en `http://localhost:8081`

### 3. Verificar contenedores

```bash
docker compose ps
```

## 🗄️ Migraciones de Base de Datos

Las migraciones de Flyway se encuentran en `src/main/resources/db/migration/`:

- `V1__init.sql`: Creación de tabla `events`
- `V2__relaciones.sql`: Configuración de relaciones (vacío en arquitectura híbrida)
- `V3__ajustes.sql`: Ajustes adicionales

Flyway aplica automáticamente las migraciones al iniciar la aplicación.

## 🧪 Pruebas

### Crear un Venue (MongoDB)

```bash
curl -X POST http://localhost:8081/api/venues \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Teatro Colón",
    "location": "Buenos Aires",
    "capacity": 2500
  }'
```

### Crear un Event (MySQL)

```bash
curl -X POST http://localhost:8081/api/events \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Obra de Teatro",
    "date": "2025-11-30T19:00:00",
    "status": "ACTIVE",
    "venueId": "674532a1b2c3d4e5f6789012"
  }'
```

### Listar todos los Venues

```bash
curl http://localhost:8081/api/venues
```

### Listar eventos por Venue

```bash
curl http://localhost:8081/api/events/venue/674532a1b2c3d4e5f6789012
```

## 📚 Principios de Diseño Aplicados

1. **Hexagonal Architecture**: Separación clara entre dominio, aplicación e infraestructura
2. **Dependency Inversion**: El dominio no depende de la infraestructura
3. **Single Responsibility**: Cada clase tiene una única responsabilidad
4. **Open/Closed**: Abierto para extensión, cerrado para modificación
5. **Interface Segregation**: Interfaces específicas (Use Cases y Repository Ports)
6. **DTO Pattern**: Separación entre modelos de dominio y de presentación

## 🔒 Validaciones

- **Validación de Venue**: Al crear un Event, se valida que el `venueId` exista en MongoDB
- **Transaccionalidad**: Operaciones de escritura envueltas en transacciones
- **Integridad**: Flyway garantiza que el esquema MySQL esté sincronizado

## 📝 Notas Técnicas

- **Relación Lógica**: Events y Venues están relacionados lógicamente por `venueId`, no por foreign key de base de datos
- **ID Types**: Venues usan `String` (ObjectId de MongoDB), Events usan `Long` (AUTO_INCREMENT de MySQL)
- **Mappers Dobles**: Existen mappers para DTO↔Domain y Domain↔Entity
- **Use Cases como Interfaces**: Permiten cambiar implementaciones sin afectar controladores

## 👥 Autor

Proyecto desarrollado como parte de HU-SEMANA-4 - Administración de Eventos y Venues

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.
