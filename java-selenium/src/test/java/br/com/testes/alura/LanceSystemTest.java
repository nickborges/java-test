package br.com.testes.alura;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LanceSystemTest {
	
	private WebDriver driver;
    private LeiloesPage leiloes;

    @BeforeAll
    public void inicializa() {
        
    	this.driver = new FirefoxDriver();
        leiloes = new LeiloesPage(driver);
        
        driver.get("http://localhost:8080/apenas-teste/limpa");
        
        UsuariosPage usuarios = new UsuariosPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra("nome", "email");
        usuarios.novo().cadastra("nome2", "email2");
        
        LeiloesPage leiloes = new LeiloesPage(driver);
        leiloes.novo().preenche("obj", 0, "nome", false);
    }

    @Test
    public void deveFazerUmLance() {

        DetalhesDoLeilaoPage lances = leiloes.detalhes(1);

        lances.lance("José Alberto", 150);

        assertTrue(lances.existeLance("José Alberto", 150));
    }
}
