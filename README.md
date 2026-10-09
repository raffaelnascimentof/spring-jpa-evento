# spring-jpa-evento

Projeto desenvolvido para demonstrar, na prática, os conceitos de Mapeamento Objeto-Relacional (ORM) e construção de Modelo de Domínio utilizando Java, Spring Boot e JPA/Hibernate.

## 📚 Conceitos Aplicados

### 1. Mapeamento Objeto-Relacional (ORM)
Tradicionalmente, os dados residem em tabelas relacionais e a aplicação roda através de objetos na memória. O ORM é a ponte que conecta esses dois mundos.
* **Sem ORM:** Teríamos que escrever queries SQL manuais (JDBC) e mapear os resultados coluna por coluna para as classes Java.
* **Com ORM (JPA/Hibernate):** As tabelas tornam-se classes (`@Entity`), as colunas tornam-se atributos, e o framework gera e executa o SQL automaticamente em tempo de execução.
Isso traz extrema produtividade e independência da infraestrutura de banco de dados subjacente.

### 2. Relacionamentos de Domínio (Cardinalidade)
O projeto implementa rigorosamente um diagrama de classes através das anotações da JPA:
* **Muitos para Um (`@ManyToOne`):** Múltiplas atividades pertencem a uma mesma categoria.
* **Um para Muitos (`@OneToMany`):** Uma atividade possui vários blocos de horário isolados.
* **Muitos para Muitos (`@ManyToMany`):** Participantes podem se inscrever em várias atividades, e atividades possuem vários participantes. Esse desafio foi resolvido de forma elegante utilizando a anotação `@JoinTable` para criar a tabela associativa de matrícula sem a necessidade de instanciar uma terceira classe Java.

### 3. Database Seeding (Povoamento Inicial)
Para facilitar os testes, a aplicação utiliza a estratégia de carga inicial de dados via script SQL (`import.sql`). [cite_start]Assim que o Hibernate finaliza a construção da estrutura de tabelas (DDL) no banco em memória, os dados de teste pré-definidos são inseridos automaticamente[cite: 8].

## 🛠 Como foi implementado

Neste exemplo, utilizamos o ecossistema **Spring Data JPA** e o banco de dados **H2** para um desenvolvimento ágil.

* **`@Entity`:** Define classe como entidade.
* **`@Table`:** Nomeia tabela no banco.
* **`@Id`:** Define chave primária (PK).
* **`@GeneratedValue`:** Gera ID automaticamente.
* **`@Column`:** Configura atributos da coluna.
* **`@ManyToOne`:** Relação muitos para um.
* **`@OneToMany`:** Relação um para muitos.
* **`@ManyToMany`:** Relação muitos para muitos.
* **`@JoinColumn`:** Nomeia chave estrangeira (FK).
* **`@JoinTable`:** Cria tabela associativa (N:N).

```java
@ManyToMany
@JoinTable(
    name = "tb_participante_atividade",
    joinColumns = @JoinColumn(name = "participante_id"),
    inverseJoinColumns = @JoinColumn(name = "atividade_id")
)
private Set<Atividade> atividades = new HashSet<>();
```

## 🚀 Execução e Tecnologias
Execução: O projeto inicia pela classe principal executável do Spring Boot. Para validar a integridade das tabelas criadas e os relacionamentos do seeding, o Console do H2 deve ser acessado no navegador via http://localhost:8080/h2-console.

JDBC URL: jdbc:h2:mem:testdb

Username: sa

Password: (deixar em branco)

* Java 17+
* Spring Boot
