# Imagem base Node.js para construir o aplicativo
FROM node:22-alpine as builder

# Definição do diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia os arquivos do projeto para o contêiner
COPY package.json ./
COPY package-lock.json ./

# Instala as dependências do projeto
RUN npm ci

# Instala o Angular CLI globalmente
RUN npm install -g @angular/cli

COPY . .

# Build do aplicativo Angular
RUN npm run build

# Imagem base Nginx para server
FROM nginx:1.23-alpine

# Configuração de porta 80
EXPOSE 80

# Remoção da configuração padrão do Nginx
RUN rm -rf /etc/nginx/conf.d/*

# Copia a configuração do Nginx
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Copia os arquivos estáticos do build do Angular
COPY --from=builder /app/dist/app/browser /usr/share/nginx/html
