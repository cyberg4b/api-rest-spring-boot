# 📚 API de Cursos (CRUD)

Uma API básica que faz conexão com um banco de dados PostgreSQL e realiza operações de CRUD básicas.

## 🛠️ Instalação

Clone o projeto para seu computador:

```bash
    $ git clone https://github.com/cyber/api-rest-spring-boot
    $ cd api-rest-spring-boot
```

### ⚙️ Configurações Básicas (application.properties)

Antes de colocar o projeto no ar existem algumas configurações que precisam ser definidas no [application.properties](https://github.com/cyber/api-rest-spring-boot/src/main/resources/application.properties) não haja nenhum erro na execução do projeto:

```
    spring.datasource.url=jdbc:postgresql://localhost:5432/db_course
    spring.datasource.username=
    spring.datasource.password=
    spring.jpa.hibernate.ddl-auto=update
```

### 🚀 Rodando o Projeto

Agora que está tudo configurado basta encontrar o arquivo principal e apertar o botão de Run da sua IDE ou digitar o seguinte comando no terminal:

```bash
    $ mvn spring-boot:run
```
## 📖 Dependências

- [Spring Data JPA]()
- [Spring Security]()
- [Spring Web]()
- [Hibernate]()