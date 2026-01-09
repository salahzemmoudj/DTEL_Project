# Image Java 17
FROM eclipse-temurin:17-jdk-alpine

# Dossier de travail
WORKDIR /app

# Copier le jar (quel que soit son nom)
#COPY target/*.jar app.jar
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Port exposé
EXPOSE 8087

# Lancer l’application
ENTRYPOINT ["java","-jar","app.jar"]
