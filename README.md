# Agrix - Sistema de Gestão de Fazendas e Plantações

Agrix é uma aplicação Spring Boot que visa melhorar a eficiência no cultivo de plantações, reduzindo o desperdício de recursos e promovendo práticas agrícolas mais sustentáveis. Este sistema está sendo desenvolvido em fases; atualmente, estamos na Fase C. 

## Funcionalidades

Na Fase C, o Agrix inclui as seguintes funcionalidades:

1. **Cadastro de Fazendas**:
   - Rota `POST /farms` para cadastrar novas fazendas.
2. **Listagem de Fazendas**:
   - Rota `GET /farms` para listar todas as fazendas cadastradas.
3. **Detalhes de uma Fazenda**:
   - Rota `GET /farms/{id}` para obter informações específicas de uma fazenda.
4. **Cadastro de Plantações**:
   - Rota `POST /plantations` para cadastrar novas plantações.
5. **Listagem de Plantações**:
   - Rota `GET /plantations` para listar todas as plantações cadastradas.
6. **Detalhes de uma Plantação**:
   - Rota `GET /plantations/{id}` para obter informações específicas de uma plantação.
7. **Cadastro de Fertilizantes**:
   - Rota `POST /fertilizers` para cadastrar novos fertilizantes.
8. **Listagem de Fertilizantes**:
   - Rota `GET /fertilizers` para listar todos os fertilizantes cadastrados.
9. **Detalhes de um Fertilizante**:
   - Rota `GET /fertilizers/{id}` para obter informações específicas de um fertilizante.

## Segurança

Para garantir que apenas usuários autenticados e autorizados acessem os recursos da aplicação, implementamos segurança utilizando Spring Security. A autenticação e autorização são gerenciadas por meio de tokens JWT, assegurando sessões seguras. 

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal do projeto.
- **Spring Boot**: Framework para facilitar o desenvolvimento da aplicação.
- **Spring Data JPA**: Para persistência e gerenciamento de dados.
- **Spring Security**: Para implementação de autenticação e autorização.
- **JWT (JSON Web Tokens)**: Para gerenciamento seguro de sessões de usuário.
