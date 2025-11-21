# Módulo de Administración de Eventos y Venues (HU-SEMANA-4)

Este proyecto implementa el módulo de administración de **Eventos y Venues** para la plataforma de gestión de catálogos. Se ha desarrollado siguiendo una **Arquitectura Hexagonal** para garantizar la separación de responsabilidades, la mantenibilidad y la escalabilidad del código.

## 🏗️ Arquitectura y Diseño

El proyecto sigue los principios de la **Arquitectura Hexagonal (Puertos y Adaptadores)**:

*   **Domain (Núcleo):** Contiene la lógica de negocio pura y las entidades del dominio (`Event`, `Venue`). Es agnóstico a frameworks y bases de datos.
*   **Application (Servicios):** Orquesta los casos de uso (`EventService`, `VenueService`) e implementa la lógica transaccional.
*   **Infrastructure (Adaptadores):**
    *   **Input:** Controladores REST (`EventController`, `VenueController`) que exponen la API.
    *   **Output:** Adaptadores de persistencia (`JpaEventRepository`, `JpaVenueRepository`) que implementan los puertos definidos en el dominio.

### Características Técnicas Clave

1.  **Optimización de Consultas (N+1):**
    *   Se implementó `@EntityGraph` en los repositorios JPA para realizar cargas ansiosas (EAGER) selectivas de las relaciones (`Event` -> `Venue`), evitando el problema de N+1 consultas y mejorando drásticamente el rendimiento.
    *   Uso de `JPA Specifications` para filtros dinámicos y complejos.

2.  **Gestión de Transacciones:**
    *   Uso de `@Transactional` en la capa de servicio para garantizar la atomicidad de las operaciones (ACID), diferenciando entre transacciones de solo lectura (`readOnly = true`) y de escritura.

3.  **Migraciones de Base de Datos:**
    *   Integración de **Flyway** para el control de versiones del esquema de base de datos.
    *   Scripts versionados (`V1__init.sql`, `V2__relaciones.sql`, `V3__ajustes.sql`) para una evolución controlada y reproducible de la BD.

4.  **Limpieza de Código Legacy:**
    *   Se eliminó todo el código obsoleto relacionado con `Task` y `User`, dejando un microservicio limpio y enfocado en su dominio principal.

## 🚀 Tecnologías

*   **Java 17**
*   **Spring Boot 3** (Web, Data JPA)
*   **MySQL 8** (Base de datos relacional)
*   **Flyway** (Migraciones de BD)
*   **Maven** (Gestión de dependencias)

## 🔌 API Endpoints

La aplicación expone los siguientes endpoints REST en el puerto **8081**:

### Venues
*   `GET /api/venues` - Listar todos los venues.
*   `POST /api/venues` - Crear un nuevo venue.
*   `GET /api/venues/{id}` - Obtener un venue por ID.
*   `DELETE /api/venues/{id}` - Eliminar un venue.
*   `PUT /api/venues/{id}` - Actualizar un venue.

### Eventos
*   `GET /api/events` - Listar todos los eventos (paginado).
*   `POST /api/events` - Crear un nuevo evento.
*   `GET /api/events/{id}` - Obtener un evento por ID.
*   `DELETE /api/events/{id}` - Eliminar un evento.
*   `GET /api/events/search` - Búsqueda avanzada.
    *   Parámetros: `status` (ACTIVE, INACTIVE), `date` (YYYY-MM-DD), `venueId`.

## ⚙️ Configuración y Ejecución

### Prerrequisitos
*   JDK 17+
*   MySQL Server corriendo en `localhost:3307` (o configurar en `application.properties`).

### Configuración
El archivo `src/main/resources/application.properties` contiene la configuración:

```properties
server.port=8081
spring.datasource.url=jdbc:mysql://127.0.0.1:3307/db_users_hexagonal
spring.datasource.username=root
spring.datasource.password=123456
spring.flyway.enabled=true
```

### Ejecutar la aplicación

```bash
./mvnw spring-boot:run
```

La aplicación estará disponible en `http://localhost:8081`.
