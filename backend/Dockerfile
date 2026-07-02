# Usa una imagen de Spring Boot oficial con Java 17
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copia solo el pom primero para cachear dependencias
COPY pom.xml .
COPY mvnw ./
COPY .mvn ./.mvn

# Da permisos y descarga dependencias
RUN chmod +x mvnw && ./mvnw dependency:go-offline

# Ahora copia el código y compila
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Imagen final ligera
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
