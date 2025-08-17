# Etapa de build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa de execução
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copia o JAR gerado
COPY --from=build /app/target/*.jar app.jar

# Define variável de ambiente para porta do Render
ENV SERVER_PORT=${PORT}

EXPOSE ${PORT}

ENTRYPOINT ["java", "-jar", "app.jar"]
