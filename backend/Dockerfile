# Usa una imagen de Maven con Java 17 para compilar
FROM maven:3.9-eclipse-temurin-17 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos del proyecto
COPY pom.xml .
COPY src ./src
COPY .mvn ./.mvn
COPY mvnw ./

# Compila el proyecto (sin tests)
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Usa una imagen ligera de Java 17 para ejecutar
FROM eclipse-temurin:17-jre-alpine

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR compilado desde la etapa "build"
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto que usa la app (8080)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
