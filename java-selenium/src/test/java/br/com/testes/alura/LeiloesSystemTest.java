package br.com.testes.alura;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LeiloesSystemTest {

	private WebDriver driver;
	private LeiloesPage leiloes;

	@BeforeAll
	public void inicializa() {
		this.driver = new FirefoxDriver();
		leiloes = new LeiloesPage(driver);

		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
	}
	
	@Test
	public void deveCadastrarUmLeilao() {

		leiloes.visita();
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.preenche("Geladeira", 123, "Paulo Henrique", true);

		assertTrue(leiloes.existe("Geladeira", 123, "Paulo Henrique", true));

	}
}
