# Utilise une image légère basée sur Node.js pour la construction
FROM node:14-alpine AS builder

# Définis le répertoire de travail dans le conteneur
WORKDIR /app

# Copie les fichiers package.json et package-lock.json dans le répertoire de travail
COPY package*.json ./

# Installe les dépendances
RUN npm install

# Copie tous les fichiers du projet dans le répertoire de travail
COPY . .

# Construit l'application pour la production
RUN npm run build

# Utilise une image légère basée sur Nginx pour servir l'application
FROM nginx:alpine

# Copie les fichiers de construction de l'application Vue.js à partir du premier conteneur dans le répertoire approprié de Nginx
COPY --from=builder /app/dist /usr/share/nginx/html

# Expose le port 80 pour permettre l'accès à l'application
EXPOSE 80

# Commande à exécuter lors du démarrage du conteneur
CMD ["nginx", "-g", "daemon off;"]
