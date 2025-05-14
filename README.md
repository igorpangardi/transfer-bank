# 💸 Agendamento de Transferências Financeiras

## 📝 Descrição

Este projeto faz o papel do backend de um sistema para **agendamento de transferências financeiras**, onde o valor da taxa de cada transação é **calculado automaticamente** com base na data da transferência. A aplicação foi construída utilizando **Spring Boot** para o backend, oferecendo uma **API RESTful** para agendamento e visualização das transferências agendadas.

---

## 🚀 Funcionalidades

- **Agendamento de transferências**  
  O usuário pode agendar uma transferência financeira, fornecendo:
    - Conta de origem
    - Conta de destino
    - Valor da transferência
    - Data do agendamento
    - A data da transferência é o sempre o dia atual.
    - A taxa é calculada automaticamente com base nas regras do sistema

- **Cálculo automático de taxas**  
  A taxa da transferência é calculada de acordo com a data da transferência, utilizando o padrão Strategy para facilitar manutenção e extensibilidade.

- **Visualização de extrato**  
  O usuário pode consultar todos os agendamentos realizados.

---

## 🛠️ Tecnologias Utilizadas

- **Backend:** Spring Boot 2.5.10, Java 11
- **Banco de Dados:** H2 (in-memory)
- **Documentação da API:** Swagger (Springdoc OpenAPI)

### 📦 Dependências

- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- MapStruct
- Flyway
- Springdoc OpenAPI
- Bean Validation

---

## ▶️ Como Executar

Para executar a aplicação de agendamento de transferências financeiras, siga os passos abaixo:

### 1. Clone o repositório

```bash
git clone [https://github.com/igorpangardi/transfer-bank](https://github.com/igorpangardi/transfer-bank)
cd transfer-bank
```

Este comando irá baixar o código fonte do projeto para o seu computador e te direcionar para o diretório raiz do projeto.

### 2. Execute a aplicação Spring Boot

A forma de executar a aplicação depende do seu gerenciador de build. Você pode usar o Maven Wrapper (`mvnw`) ou o Gradle Wrapper (`gradlew`) que já estão incluídos no projeto.

**Usando Maven Wrapper (recomendado):**

```bash
./mvnw spring-boot:run
```

**Usando Gradle Wrapper:**

```bash
./gradlew bootRun
```

Escolha o comando correspondente ao seu gerenciador de build. Este comando irá baixar as dependências necessárias e iniciar o servidor Spring Boot. Você verá logs no seu terminal indicando que a aplicação está sendo iniciada.

### 3. Acesse a documentação da API (Swagger)

Após a aplicação ser iniciada com sucesso, você pode acessar a documentação da API RESTful através do seguinte link no seu navegador:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

Nesta página, você poderá interagir com os endpoints da API, como agendar novas transferências e visualizar o extrato.

**Observações:**

* Certifique-se de ter o Java 11 instalado em sua máquina para executar a aplicação.
* A primeira execução pode demorar um pouco, pois o Maven ou Gradle irão baixar as dependências.
* Caso a aplicação não inicie na porta 8080, verifique os logs para identificar a porta em que ela está rodando ou as configurações do seu ambiente.