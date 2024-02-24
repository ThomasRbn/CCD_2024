# Utiliser l'image OpenJDK officielle en tant qu'image de base
FROM openjdk:21

# Répertoire de travail dans le conteneur
#WORKDIR /

# Copier le jar de l'application dans le conteneur
COPY CCD_2024.jar /app/CCD_2024.jar

# Commande à exécuter lorsque le conteneur démarre
CMD ["java", "-jar", "/app/CCD_2024.jar"]
