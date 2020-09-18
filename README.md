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
  
### Mock
* 

### Testes de Integração - SQL e DAOs
* Testar as transações reais conectando no banco de dados, sem usar mock.
* Nos testes de consulta, inserir antes o registro para garantir que o registro exista no banco.
* Sempre que abrir uma conexão com o banco, fechar ela depois, exemplo @After.
