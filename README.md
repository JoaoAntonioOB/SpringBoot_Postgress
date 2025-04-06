# 💳 Sistema de Cadastro Bancário

Um sistema simples de contas bancárias desenvolvido com Java, Spring Boot e PostgreSQL.  
Ideal para fins de estudo e prática com API REST, banco de dados relacional e boas práticas de desenvolvimento backend.

---

### 🚀 Tecnologias utilizadas

- ✅ Java 17  
- ✅ Spring Boot  
- ✅ Spring Data JPA  
- ✅ PostgreSQL  
- ✅ Maven  
- ✅ IntelliJ IDEA

---

### 📦 Funcionalidades

- [x] Criar clientes  
- [x] Criar contas bancárias  
- [x] Listar contas por cliente  
- [x] Deletar contas  
- [ ] Realizar transações (em desenvolvimento)

---

### 🛠️ Como rodar o projeto

1. **Clone o repositório**

```bash
git clone https://github.com/joaoAntonioOB/SpringBoot_Postgress.git
cd SpringBoot_Postgress
Configure o banco de dados PostgreSQL

Certifique-se de que o PostgreSQL está instalado e rodando.

Crie um banco de dados chamado banco_db

Edite o arquivo src/main/resources/application.properties com seu usuário e senha:

properties
Copiar
Editar
spring.datasource.url=jdbc:postgresql://localhost:5432/banco_db
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
💡 Dica: você pode usar o PgAdmin ou outro cliente SQL para criar o banco.

Execute o projeto

No terminal, execute:

bash
Copiar
Editar
./mvnw spring-boot:run
O sistema estará disponível em: http://localhost:8080
```

👤 Desenvolvido por / Developed by
João Antônio
