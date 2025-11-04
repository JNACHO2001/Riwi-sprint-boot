# Catálogos de Eventos (Spring Boot)

## Descripción

Aplicación REST para la gestión de eventos, usuarios e inscripciones. Permite crear, listar, editar y eliminar eventos y usuarios, y registrar inscripciones de usuarios a eventos. Proyecto organizado en capas para separar responsabilidades y facilitar el mantenimiento.

## Tecnologías

- Java 17+
- Spring Boot (Web, Validation, Data JPA)
- Hibernate / JPA
- MySQL (conector com.mysql.cj.jdbc.Driver)
- Maven (wrapper incluido)
- Jakarta Bean Validation (@NotNull, @NotBlank)

## Arquitectura en capas

- Controller: define los endpoints REST (`eventos.catalogos.controlador`).
- Service: lógica de negocio y validaciones adicionales (`eventos.catalogos.service`).
- Repository: acceso a datos con Spring Data JPA (`eventos.catalogos.repository`).
- Entity: entidades JPA que mapean la base de datos (`eventos.catalogos.entity`).
- DTO: objetos de transferencia para requests/responses (`eventos.catalogos.web.dto`).
- Advice: manejo global de excepciones y formato de errores (`eventos.catalogos.web.advice`).

En este proyecto existe un `@RestControllerAdvice` implementado en `eventos.catalogos.web.advice.GlobalExceptionHandler` que:

- Captura errores de validación (`MethodArgumentNotValidException`) y devuelve un JSON con `timestamp`, `status`, `error`, `message`, `path` y un mapa `fields` con los errores por campo (HTTP 400).
- Captura `IllegalArgumentException` y devuelve un JSON con información del conflicto (HTTP 409).
- Captura `NoSuchElementException` y devuelve un JSON con información de recurso no encontrado (HTTP 404).

## Estructura del proyecto

```
src/main/java/eventos/catalogos/
  controlador/        # REST controllers (EventControlador, UsuarioControlador, InscripcionControlador)
  service/            # Servicios e implementaciones (EventServiceIm, UsuarioServiceIm, InscripcionServiceIm)
  repository/         # Repositorios JPA (EventRepository, UsuarioRepository, IncripcionRepository)
  entity/             # Entidades JPA (Event, User, Inscripcion)
  web/dto/            # DTOs (Request/Response)
  web/advice/         # Manejador global de excepciones (GlobalExceptionHandler)
src/main/resources/
  application.properties
pom.xml
mvnw, mvnw.cmd
```

## Instalación y configuración

1. Prerrequisitos:
   - Java 17 o superior
   - Maven 3.6+ (puedes usar el wrapper `./mvnw`)
   - MySQL o MariaDB en ejecución

2. Crear base de datos (ejemplo):

```sql
CREATE DATABASE eventos CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

3. Configurar conexión en `src/main/resources/application.properties` (valores de ejemplo):

```properties
spring.datasource.url=jdbc:mysql://localhost/tu_base_de_datos
spring.datasource.username=tu_name
spring.datasource.password=tu_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

4. Construir y ejecutar:

```bash
# desde la raíz del proyecto
./mvnw clean package
./mvnw spring-boot:run
# o ejecutar el jar generado
java -jar target/*.jar
```

## Endpoints de la API

Base: `/api`

Usuarios
- POST `/api/usuario` — Crear usuario
  - Request (UsuarioRequest):
    ```json
    {
      "nombre": "Juan",
      "edad": 30,
      "email": "juan@example.com",
      "telefono": 600123456
    }
    ```
  - Response: `201 Created` con `UsuarioResponse` (nombre, edad, email, telefono)
  - Validaciones: `nombre` (NotBlank), `edad` (NotNull), `email` (NotBlank), `telefono` (NotNull). Servicio comprueba nombres duplicados.

- GET `/api/usuario` — Listar todos los usuarios (200 OK)
- GET `/api/usuario/{id}` — Obtener usuario por id (200 OK)
- PUT `/api/usuario/{id}` — Editar usuario (200 OK)
- DELETE `/api/usuario/{id}` — Eliminar usuario (200 OK)

Eventos
- POST `/api/event` — Crear evento
  - Request (EventRequest):
    ```json
    {
      "nombre": "Concierto Primavera",
      "fechaEvento": "2025-06-21",
      "ubicacion": "Auditorio Central",
      "ciudad": "Madrid"
    }
    ```
  - Response: `201 Created` con `EventResponse` (nombre, fechaEvento, ubicacion, ciudad)
  - Validaciones: `nombre`, `ubicacion`, `ciudad` -> @NotBlank; `fechaEvento` -> @NotNull. Servicio comprueba nombre duplicado.

- GET `/api/event` — Listar eventos
- GET `/api/event/{id}` — Obtener evento por id
- PUT `/api/event/{id}` — Editar evento
- DELETE `/api/event/{id}` — Eliminar evento

Inscripciones
- POST `/api/inscripcion` — Crear inscripcion
  - Request (InscrpcionRequest):
    ```json
    {
      "fechaIncripcion": "2025-05-01",
      "user": 1,
      "event": 2
    }
    ```
  - Response: `200 OK` con `InscripcionResponse` (fechaInscripcion, nombreUser, nombreEvento)
  - Validaciones: `fechaIncripcion`, `user`, `event` -> @NotNull. Servicio valida existencia de user y event.

- GET `/api/inscripcion` — Listar inscripciones
- DELETE `/api/inscripcion/{id}` — Eliminar inscripcion

## Ejemplos de uso (curl)

Crear usuario:

```bash
curl -X POST http://localhost:8080/api/usuario \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Ana","edad":28,"email":"ana@example.com","telefono":600111222}'
```

Crear evento:

```bash
curl -X POST http://localhost:8080/api/event \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Feria Tech","fechaEvento":"2025-11-15","ubicacion":"Recinto Ferial","ciudad":"Sevilla"}'
```

Inscribir usuario a evento:

```bash
curl -X POST http://localhost:8080/api/inscripcion \
  -H "Content-Type: application/json" \
  -d '{"fechaIncripcion":"2025-10-01","user":1,"event":1}'
```

Obtener lista de eventos:

```bash
curl http://localhost:8080/api/event
```

## Validaciones implementadas

1. Anotaciones de Jakarta Validation en DTOs
   - `@NotBlank` en: `EventRequest.nombre`, `EventRequest.ubicacion`, `EventRequest.ciudad`, `UsuarioRequest.nombre`, `UsuarioRequest.email`.
   - `@NotNull` en: `EventRequest.fechaEvento`, `InscrpcionRequest.fechaIncripcion`, `InscrpcionRequest.user`, `InscrpcionRequest.event`, `UsuarioRequest.edad`, `UsuarioRequest.telefono`.
   - Los endpoints usan `@Valid` en los controladores, por lo que las peticiones inválidas devolverán errores de validación (400) y el `GlobalExceptionHandler` los formatea.

2. Validaciones a nivel de servicio
   - Comprobación de duplicados: `EventServiceIm` y `UsuarioServiceIm` usan `existsByNombreIgnoreCase` y lanzan `IllegalArgumentException` con mensaje `"nombre duplicado"` cuando el nombre ya existe (capturado como 409 por el Advice).
   - Comprobación de existencia: `InscripcionServiceIm` verifica que `user` y `event` existen; si no, lanza `IllegalArgumentException` (409).
   - Búsqueda por id: servicios usan `orElseThrow` con `NoSuchElementException` para recursos no encontrados (capturado como 404 por el Advice).

## Contrato mínimo (inputs/outputs)

- Inputs: JSON en los endpoints REST conforme a los DTOs de `web/dto`.
- Outputs: DTOs `*Response` o mensajes simples (p.ej. "Eliminado").
- Errores: Validaciones vía Jakarta Validation (400), `IllegalArgumentException` para duplicados y errores de referencia (409), `NoSuchElementException` para no encontrado (404). El `GlobalExceptionHandler` normaliza estas respuestas.
