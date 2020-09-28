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
* Utilizado para simular dados de retorno.
* *mock*(ClasseASerMockada.class) - define a classe que deve ser mockada.
* *when*(classeAserMockada.seuMetodo()).*thenReturn*(colocarAquiRetornoDesejado); - quando chamado um método então retorna dados mockados.
* *verify*(classeAserMockada).seuMetodo(); - verifica se o método da classe de mock foi realmente chamado.
* *verify*(classeAserMockada, *times*(1)).seuMetodo(); - verifica se o método da classe de mock foi realmente chamado apenas uma vez neste caso times = 1 .
  * Ainda podemos passar *atLeastOnce*(), *atLeast*(numero), *atMost*(numero) e *never*() para o verify().
* *inOrder*(classeAserMockada1, classeAserMockada2); - garante que as execução foram feitas na ordem esperada
* *doThrow*(new ExceptionDesejada()).when(classeAserMockada).seuMetodo(); - Lança uma exception quando o método dentro da classe de mock é chamado.
* *any*() - não importa qual objeto o métodos de mock vai receber. Exemplo: verify(carteiroFalso, never()).envia(any(Leilao.class));
* ArgumentCaptor - possibilita capturar a instância que foi passada para o Mock e recuperar o valor passado para ele. Exemplo:
```
    ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
    verify(pagamentos).salva(argumento.capture());
    Pagamento pagamentoGerado = argumento.getValue();
    assertEquals(2500.0, pagamentoGerado.getValor(), 0.00001);
```
* desvantagem: Ao usar mocks, estamos "enganando" nosso teste. Um bom teste de DAO por exemplo, é aquele que garante que sua consulta SQL realmente funciona quando enviada para o banco de dados; e a melhor maneira de garantir isso é enviando-a para o banco.

### Testes de Integração - SQL e DAOs
* Testar as transações reais conectando no banco de dados, sem usar mock.
* Nos testes de consulta, inserir antes o registro para garantir que o registro exista no banco.
* Sempre que abrir uma conexão com o banco fechar ela depois, limpar o banco de dados para que o próximo teste consiga executar sem problemas. Fazemos isso dando rollback no banco de dados. Exemplo: utilizar o @After
  
### Testes com Selenium
* Teste de formulário de pesquisa:
```
    // abre firefox
    WebDriver driver = new FirefoxDriver();

    // acessa o site do google
    driver.get("http://www.google.com.br/");

    // captura o nome do input de busca do google, name="q"
    WebElement query = driver.findElement(By.name("q"));
    query.sendKeys("Caelum");

    // submete o form
    query.submit();
```
* Teste de formulário de cadastro:
```
@Test
public void deveAdicionarUmUsuario() {
    WebDriver driver = new FirefoxDriver();
    driver.get("http://localhost:8080/usuarios/new");

    WebElement nome = driver.findElement(By.name("usuario.nome"));
    WebElement email = driver.findElement(By.name("usuario.email"));

    nome.sendKeys("Ronaldo Luiz de Albuquerque");
    email.sendKeys("ronaldo2009@terra.com.br");
    nome.submit();

    boolean achouNome = driver.getPageSource()
        .contains("Ronaldo Luiz de Albuquerque");
    boolean achouEmail = driver.getPageSource()
        .contains("ronaldo2009@terra.com.br");

    assertTrue(achouNome);
    assertTrue(achouEmail);

    driver.close();
}
```
* padrão Page Object: é ter um objeto por página. Exemplo:
```
class UsuariosPage {

    private WebDriver driver;

    public UsuariosPage(WebDriver driver) {
        this.driver = driver;
    }

    public void visita() {
        driver.get("localhost:8080/usuarios");
    }

    public NovoUsuarioPage novo() {
        // clica no link de novo usuario
        driver.findElement(By.linkText("Novo Usuário")).click();
        return new NovoUsuarioPage(driver);
    }

    public boolean existeNaListagem(String nome, String email) {
        // verifica se ambos existem na listagem
        return driver.getPageSource().contains(nome) && 
                driver.getPageSource().contains(email);
    }

}
class NovoUsuarioPage {

    private WebDriver driver;

    public NovoUsuarioPage(WebDriver driver) {
        this.driver = driver;
    }

    public void cadastra(String nome, String email) {
        WebElement nome = driver.findElement(By.name("usuario.nome"));
        WebElement email = driver.findElement(By.name("usuario.email"));

        nome.sendKeys(nome);
        email.sendKeys(email);

        nome.submit();
    }
}
``
  
* **Testes em Paralelo:**
```
#execução dos teste em paralelo, default é executar um após o outro.
junit:
  jupiter:
    execution:
      parallel:
        enabled: true
        model:
          default: concurrent
```