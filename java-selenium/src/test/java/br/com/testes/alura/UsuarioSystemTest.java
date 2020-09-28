package br.com.testes.alura;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsuarioSystemTest {

	private WebDriver driver;
    private UsuariosPage usuarios;

    @BeforeAll
    public void inicializa() {
        this.driver = new FirefoxDriver();
        this.usuarios = new UsuariosPage(driver);
    }

    @Test
    public void deveAdicionarUmUsuario() {

        usuarios.visita();
        usuarios.novo()
        .cadastra("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");

        assertTrue(usuarios.existeNaListagem(
                "Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));

    }

    @AfterAll
    public void encerra() {
        driver.close();
    }
}
