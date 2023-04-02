## Gym API

Esse é o backend de um projeto de um back-end em Java de um site/aplicativo feito para academias. Ele conta com um sistema de autenticação usando Spring Security, onde o usuário precisa fazer o login e ai gerará um token JWT (com validade de 1 dia), que acompanhará todas as requisições do usuário na API.<br>
Todas as funções usam DTO na entrada e saída de dados.

## Funções da API
### Clientes:
- Listar clientes
- Detalhar cliente
- Cadastrar cliente
- Atualizar cliente

### Treinadores:
- Listar treinadores
- Detalhar treinador
- Cadastrar treinador
- Atualizar treinador

### Cálculo de treino:
- Mostrar treino (Com base no seu peso e altura ele envia uma lista de treinos)

### Agendamento:
- Agendar um horário com um professor seguindo as regras de negócio.

### Regras de negócio:
- Cada aluno pode agendar um treinamento uma vez ao dia
- Um professor não pode ter mais de um agendamento na mesma data/hora.

## Tecnologias usadas:

- Java
- Spring Boot
- Lombok
- JPA
- Tomcat
- Maven
- MySQL
- Flyway (Migrations)
- Spring Doc (Open API - Swagger)
- Spring Security
- Auth0 (Gerador de token JWT)
- BCrypt Password Encoder

## Documentação
Clone ou baixe a aplicação e a execute-a, após isso consulte a documentação com todos os métodos no seguinte link: <br>
http://localhost:8080/swagger-ui.html

## Autor

#### Allas Assis de Oliveira
https://www.linkedin.com/in/allasassis
