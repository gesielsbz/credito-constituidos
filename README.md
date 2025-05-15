# credito-constituidos

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
