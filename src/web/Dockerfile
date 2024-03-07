# Utiliser une image Node.js
FROM node:18.17.1 AS builder
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


# Stage 2 - Setup NGINX
FROM nginx:latest

# Copy build from previous stage
COPY --from=builder /app/dist /usr/share/nginx/html

# Expose port
EXPOSE 80

# Définir la commande à exécuter lorsque le conteneur démarre
CMD ["nginx", "-g", "daemon off;"]
