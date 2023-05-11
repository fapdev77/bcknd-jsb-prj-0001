# Projeto de Portifolio e estudos

- **Definição do nome do projeto utilizado** utilizei um padrão que eu mesmo criei onde nomeio o projeto da seguinte forma: *bckndjsb.prj0001* onde *bcknd* significa backend, *jsb* significa a tecnologia/framework principal, neste caso Java Spring Boot e *prj0001* é um numero de controle sequencial para projeto número 0001

## Projeto desenvolvido em Java Spring Boot usando JPA e DTO

### **Ambiente/Ferramentas utilizadas no desenvolvimento desse projeto**

    - Java: Oracle Java 17 JDK
    - IDE: Visual Studio Code
    - Testes: Postman para os testes da api
    - Container: Docker
    - Git and Github
    - Windows 10 ou 11 com WSL 2
    - Spring Boot
    - Mavem como gerenciador de dependencias
    - H2 Database e PostgreSQL

### **Configuração inicial do projeto Spring Boot**

#### *Configuração inicial do projeto spring boot utilizando a ferramenta spring initializr*

- [start.spring.io](https://start.spring.io/)

#### *Opções utilizadas na criação do projeto*

- Gerenciador de pacotes Maven
- Linguagem Java (versão 17)
- Spring Boot (versão 3.0.6)
- Metadata:
  - Group: bckndjsb
  - Artifact/Name: prj0001
  - Description: Projeto de Lista de Games desenvolvido durante o curso de Java Spring Boot
  - Package Name: com.bckndjsb.prj0001
  - Packaging: JAR
  - Java 17

#### *Dependencias do projeto*

- Spring Web
- Spring Data JPA
- H2 Database (Testes locais)
- PostgreSQL Driver

#### *Conceitos aplicados nesse projeto*

- Sistemas web e recursos
- Cliente/Servidor, HTTP, JSON
- Padrão RESTApi para Web
- Estruturação de projeto Spring REST
- Entidades e ORM
- Database seeding
- Padrão de camadas
- Controller, service e repository
- Padrão DTO

#### Referencias utilizadas

- [H2 Database](https://www.baeldung.com/spring-boot-h2-database)