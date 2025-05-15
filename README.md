# Olá! Meu nome é Gesiel Soares Bezerra,

Sou Analista de sistemas, formado em Bacharelado em Sistemas de Informação em 2012, e cursando MBA em Cybersecurity e cybercrimes.

### Você pode me encontrar por esses meios:

[![E-mail](https://img.shields.io/badge/-Email-000?style=for-the-badge&logo=microsoft-outlook&logoColor=E94D5F)](mailto:gesielsbz@gmail.com)
[![LinkedIn](https://img.shields.io/badge/-LinkedIn-000?style=for-the-badge&logo=linkedin&logoColor=30A3DC)](https://www.linkedin.com/in/gesiel-soares-bezerra-81419a34/)


## Habilidades

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-000.svg?style=for-the-badge&logo=spring&logoColor=white)
![C#](https://img.shields.io/badge/C%23-239120?style=for-the-badge&logo=c-sharp&logoColor=white)
![TypeScript](https://img.shields.io/badge/TypeScript-007ACC?style=for-the-badge&logo=typescript&logoColor=white)
![Next](https://img.shields.io/badge/Next-black?style=for-the-badge&logo=next.js&logoColor=white)
![Angular](https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white)
![Flutter](https://img.shields.io/badge/Flutter-02569B?style=for-the-badge&logo=flutter&logoColor=white)
![Bootstrap](https://img.shields.io/badge/-boostrap-0D1117?style=for-the-badge&logo=bootstrap&labelColor=0D1117)
![.NET](https://img.shields.io/badge/.NET-5C2D91?style=for-the-badge&logo=.net&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
[![Git](https://img.shields.io/badge/Git-000?style=for-the-badge&logo=git&logoColor=E94D5F)](https://git-scm.com/doc) 
[![GitHub](https://img.shields.io/badge/GitHub-000?style=for-the-badge&logo=github&logoColor=30A3DC)](https://docs.github.com/)
![PL](https://img.shields.io/badge/PL%2FSQL-FFFFFF?style=for-the-badge&logo=oracle&logoColor=FF0000&labelColor=FFFFFF&color=FF0000)
![MySQL](https://img.shields.io/badge/MySQL-0CABA8?style=for-the-badge&logo=mysql&logoColor=white) 
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-0FC2C0?style=for-the-badge&logo=postgresql&logoColor=white) 
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![Postman](https://img.shields.io/badge/postman-000?style=for-the-badge&logo=postman&logoColor=white)
![Docker](https://img.shields.io/badge/docker-000?style=for-the-badge&logo=docker&logoColor=white)
![Docker Desktop](https://img.shields.io/badge/dockerdesktop-000?style=for-the-badge&logo=docker&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-000?style=for-the-badge&logo=amazon-aws&logoColor=white)
![Azure](https://img.shields.io/badge/Azure-blue?style=for-the-badge&logo=microsoft%20azure&logoColor=blue&labelColor=FFFFFF&link=https%3A%2F%2Fimages.app.goo.gl%2FK7PN1jYJd57x4q7A8)
![Linux](https://img.shields.io/badge/Linux-000?style=for-the-badge&logo=linux&logoColor=FCC624)
![Windows](https://img.shields.io/badge/Windows-000?style=for-the-badge&logo=windows&logoColor=2CA5E0)
![VSCode](https://img.shields.io/badge/VSCode-000?style=for-the-badge&logo=visual-studio-code&logoColor=white)
![Eclipse](https://img.shields.io/badge/Eclipse-000?style=for-the-badge&logo=eclipse&logoColor=white)
![NodeJS](https://img.shields.io/badge/node.js-6DA55F?style=for-the-badge&logo=node.js&logoColor=white)



## credito-constituidos

### Pré-requisitos

* Certifique-se de que o Docker esteja instalado em sua máquina.
* Certifique-se de que o Node.js versão 22 esteja instalado em sua máquina.

### Clonagem do Projeto

1.  Clone o repositório do projeto para sua máquina local:

    ```bash
    git clone https://github.com/gesielsbz/credito-constituidos.git
    ```

### Execução do Projeto

1.  Navegue até o diretório do projeto:

    ```bash
    cd credito-constituidos
    ```

2.  Execute o seguinte comando para construir e iniciar os serviços do Docker:

    ```bash
    docker compose up -d --build
    ```

    Este comando irá construir as imagens Docker necessárias e iniciar os seguintes serviços:

    * Banco de dados (PostgreSQL)
    * Kafka (mensageria)
    * Backend (API)
    * Frontend

### Frontend

1.  A aplicação estará disponível em [http://localhost:80](http://localhost:80)    


### Visualizando dados do Kafka

Para visualizar os dados de tópico do Kafka, você pode entrar no terminal do container e usar o console consumer.

1.  Execute o comando para encontrar o nome do container Kafka (geralmente algo como `kafka_credito`):

    ```bash
    docker ps
    ```

2.  Entre no terminal do container Kafka:

    ```bash
    docker exec -it kafka /bin/bash
    ```

3.  Liste todos os tópicos disponíveis:

    ```bash
    kafka-topics.sh --list --bootstrap-server localhost:9092
    ```

4.  Execute o console consumer do Kafka, para inspecionar:

    ```bash
    kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic-consultas --from-beginning
    ```

    Isso exibirá as mensagens no tópico do Kafka no seu terminal.
