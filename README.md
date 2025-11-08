#  Proyecto: catalogos-arrays

## 1. Descripción general del proyecto

- **Propósito:**
  API REST con Spring Boot para gestionar catálogos de eventos y venues (lugares). Permite crear, listar, buscar y eliminar eventos y venues, así como asociar eventos a un venue específico.
- **Funcionalidades principales:**
  - CRUD de eventos (`EventDto`)
  - CRUD de venues (`VenueDto`)
  - Asociación de eventos a venues
- **Tipo de aplicación:**
  Microservicio/API REST (almacenamiento en memoria, sin base de datos relacional).

## 2. Estructura del proyecto

- **Paquetes principales:**
  - `controlador`: Controladores REST (`EventControlador`, `VenuesControlador`)
  - `service`: Lógica de negocio y almacenamiento en memoria (`EventService`, `ServiceVenues`)
  - `dto`: Objetos de transferencia de datos (`EventDto`, `VenueDto`)
  - `arrays`: Clase principal de arranque (`CatalogosArrays`)
- **Clases principales:**
  - `CatalogosArrays`: Clase principal con el método `main` para iniciar Spring Boot.
  - `EventControlador` y `VenuesControlador`: Endpoints REST para eventos y venues.
  - `EventService` y `ServiceVenues`: Lógica de negocio y almacenamiento en listas en memoria.
  - `EventDto` y `VenueDto`: Modelos de datos para eventos y venues.

## 3. Flujo de la aplicación

- **Interacción de módulos:**
  - Los controladores reciben peticiones HTTP y delegan en los servicios.
  - Los servicios gestionan la lógica de negocio y almacenan los datos en listas (`ArrayList`).
  - Los eventos requieren un venue existente para ser creados.
- **Endpoints importantes:**
  - `/eventos` (GET, POST): Listar y crear eventos.
  - `/eventos/{id}` (GET): Buscar evento por ID.
  - `/venues` (GET, POST): Listar y crear venues.
  - `/venues/{id}` (GET, DELETE): Buscar y eliminar venue por ID.
- **Lógica de negocio clave:**
  - Validación de existencia de venue al crear un evento.
  - Generación incremental de IDs en memoria.
  - Manejo de errores mediante excepciones si no se encuentra un recurso.

## 4. Dependencias y librerías externas

- **Spring Boot Starter Web:** API REST.
- **springdoc-openapi:** Documentación automática de la API (Swagger UI).
- **Spring Boot DevTools:** Recarga automática en desarrollo.
- **Base de datos:** No utiliza base de datos, los datos se almacenan en memoria.

## 5. Puntos fuertes y débiles del proyecto

- **Puntos fuertes:**
  - Uso de DTOs para separar lógica de negocio y datos.
  - Separación clara entre controladores y servicios.
  - Uso de anotaciones estándar de Spring Boot.
  - Documentación automática de la API con OpenAPI.
- **Puntos débiles / posibles mejoras:**
  - No hay persistencia: los datos se pierden al reiniciar.
  - No hay validaciones avanzadas.
  - No hay manejo global de excepciones.
  - No hay pruebas unitarias ni de integración.
  - No hay integración con base de datos real.
  - Mejorar nombres de métodos y variables para seguir convenciones Java.

## 6. Resumen final

El proyecto `catalogos-arrays` es una API REST sencilla y funcional para la gestión de eventos y venues, implementada con Spring Boot. Su arquitectura es clara y modular, ideal como base para proyectos educativos o prototipos. Se recomienda evolucionarlo integrando una base de datos, validaciones y pruebas para entornos productivos. Destaca por su simplicidad, separación de responsabilidades y facilidad de extensión.
