# Etapa de construcción (Build Stage)
# Usamos una imagen de Maven con OpenJDK 17 para compilar el proyecto
FROM maven:3.8.5-openjdk-17 AS build

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo pom.xml para descargar las dependencias
COPY pom.xml .

# Descargamos las dependencias del proyecto (esto se hace antes de copiar el código fuente para aprovechar la caché de Docker)
RUN mvn dependency:go-offline -B

# Copiamos el código fuente del proyecto al contenedor
COPY src ./src

# Empaquetamos la aplicación omitiendo los tests para acelerar el proceso
RUN mvn clean package -DskipTests

# Etapa de ejecución (Run Stage)
# Usamos una imagen ligera de OpenJDK 17 para ejecutar la aplicación
FROM eclipse-temurin:17-jdk-alpine

# Establecemos el directorio de trabajo
WORKDIR /app

# Copiamos el archivo JAR generado en la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto 8080 en el que corre la aplicación Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
