### TDD
* Conceito:

### Junit
* **Como testar?**
  * Implementar primeiro o teste(necessidade - regra) e ver ele falhar.
  * Dar sempre passos pequenos (baby steps).
  * Testar cada "if" (regras).
  * Criar um Test Data Builder, utilizar aqui o pattern Builder.
  * Testar Exceptions.
  * Utilizar a lib Hamcrest - lib auxiliar para o junit que serve para deixar o teste mais legível, existem mais métodos Matchers.
* **Itens**
  * @Before - executado antes todas vezes a cada execução de um método de teste.
  * @After - executado depois todas vezes a cada execução de um método de teste.
  * @BeforeClass - são executados apenas uma vez, antes de todos os métodos de teste.
  * @AfterClass - por sua vez, é executado uma vez, após a execução do último método de teste da classe.
* **JUnit 5** As novas anotações em comparação com o JUnit 4 são:
    * @TestFactory - denota um método que é uma fábrica de teste para testes dinâmicos.
    * @DisplayName - define o nome de exibição personalizado para uma classe de teste ou um método de teste
    * @Nested - denota que a classe anotada é uma classe de teste aninhada e não estática
    * @Tag - declara tags para testes de filtragem
    * @ExtendWith - é usado para registrar extensões personalizadas
    * @BeforeEach - denota que o método anotado será executado antes de cada método de teste (anteriormente @Before)
    * @AfterEach - denota que o método anotado será executado após cada método de teste (anteriormente @After)
    * @BeforeAll - denota que o método anotado será executado antes de todos os métodos de teste na classe atual (anteriormente @BeforeClass)
    * @AfterAll - denota que o método anotado será executado após todos os métodos de teste na classe atual (anteriormente @AfterClass)
    * @Disable - é usado para desabilitar uma classe ou método de teste (anteriormente @Ignore)
  
### Mock
* 

### Testes de Integração - SQL e DAOs
* Testar as transações reais conectando no banco de dados, sem usar mock.
* Nos testes de consulta, inserir antes o registro para garantir que o registro exista no banco.
* Sempre que abrir uma conexão com o banco, fechar ela depois, exemplo @After.
* **Spring Data:**
  * **@DataJpaTest** - fornece uma maneira conveniente de configurar um ambiente com um banco de dados embutido para testar nossas consultas de banco de dados.
    * A partir da versão 2.1 do Spring não é mais necessário utilizar o @ExtendWith(SpringExtension.class)
  * **@RunWith(SpringRunner.class)** - fornece uma ponte entre os recursos de teste do Spring Boot e JUnit. Sempre que estivermos usando qualquer recurso de teste do Spring Boot em nossos testes JUnit, essa anotação será necessária.
  
### Spring Data JPA
* referência: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods