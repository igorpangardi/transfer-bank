Agendamento de Transferências Financeiras
Descrição
Este projeto implementa um sistema para agendamento de transferências financeiras, onde o valor da taxa de cada transação é calculado automaticamente com base na data da transferência. A aplicação foi construída utilizando Spring Boot para o backend, oferecendo uma API RESTful para agendamento e visualização das transferências.

Funcionalidades
Agendamento de transferências: O usuário pode agendar uma transferência financeira, fornecendo a conta de origem, conta de destino, valor da transferência, a taxa calculada automaticamente, a data de transferência e a data de agendamento.
Cálculo automático de taxas: A taxa da transferência é calculada de acordo com a data da transferência, seguindo uma tabela definida no sistema.
Visualização de extrato: O usuário pode consultar todos os agendamentos de transferências realizadas.
Tecnologias Utilizadas
Backend: Spring Boot 2.5.10, Java 11
Banco de Dados: H2 (banco de dados em memória)
Swagger: Utilizado para documentar e testar a API
Dependências:
Spring Web
Spring Data JPA
H2 Database
Lombok
MapStruct
Flyway
Springdoc (para Swagger)
Bean Validation para validação de dados
Como Executar
Clone o repositório:

git clone https://github.com/igorpangardi/app.schedule-pay
Acesse o diretório do projeto:

cd app.schedule-pay
Execute o projeto com o comando:

./mvnw spring-boot:run
Ou, se você estiver utilizando Maven diretamente:

mvn spring-boot:run
Após a execução, acesse a API via:

Swagger UI: http://localhost:8080/swagger-ui/index.html
Endpoints:
POST: /api/scheduling-payments - Para criar um novo agendamento de transferência
GET: /api/scheduling-payments - Para listar todos os agendamentos cadastrados
Estrutura do Projeto
Controller: Gerencia as requisições HTTP e envia as respostas adequadas para o frontend.
Service: Contém a lógica de negócios para o agendamento e cálculo das taxas.
Model: Define as entidades que são persistidas no banco de dados (como SchedulingPayment).
Mapper: Responsável pelo mapeamento entre as entidades e os modelos de requisição/resposta.
Repository: Interface que interage diretamente com o banco de dados, utilizando Spring Data JPA.
Strategy: Implementação do padrão Strategy para cálculo das taxas com base nas regras de datas.
Considerações Arquiteturais
Arquitetura Monolítica: O projeto foi desenvolvido como uma aplicação monolítica, sem uso de microservices, a fim de simplificar o desenvolvimento e foco no desafio proposto.
Padrão Strategy: Utilizei o padrão Strategy para calcular as taxas de transferência, o que facilita a manutenção e a adição de novas regras de cálculo, caso necessário.
Bean Validation: Todas as entradas da API são validadas utilizando o Bean Validation, garantindo que os dados sejam consistentes e corretos antes de serem processados.
Instruções para Subir o Projeto
Clone o repositório e siga as etapas de execução descritas acima.
Acesse o Swagger UI para explorar os endpoints e interagir com a API de maneira mais visual.
