# Utiliser une image Node.js
FROM node:18.17.1
# Set the working directory
WORKDIR /app
# Copy package.json and package-lock.json
COPY package*.json ./
# Install dependencies
RUN npm install
# Copy the rest of the application
COPY . .
# Build the Angular application
RUN npm run build
# le port sur lequel votre application écoute
EXPOSE 4200
# Définir la commande à exécuter lorsque le conteneur démarre
CMD ["npm", "start"]
