FROM php:8.2-cli

# Installation des dépendances système
RUN apt-get update -y \
    && apt-get install -y libmcrypt-dev libonig-dev unzip \
    && rm -rf /var/lib/apt/lists/*

# Installation de Composer
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer

# Installation de symfony
RUN curl -1sLf 'https://dl.cloudsmith.io/public/symfony/stable/setup.deb.sh' | bash
RUN apt-get install -y symfony-cli
RUN docker-php-ext-install mysqli pdo_mysql

# Définition de la variable d'environnement COMPOSER_ALLOW_SUPERUSER
ENV COMPOSER_ALLOW_SUPERUSER=1

WORKDIR /app

# Copie de votre projet Symfony dans le conteneur
COPY infraAPI /app

# Installation des dépendances du projet
RUN composer install

# Exposition du port 8000
EXPOSE 8000

# Commande par défaut pour exécuter le serveur Symfony
CMD symfony server:start