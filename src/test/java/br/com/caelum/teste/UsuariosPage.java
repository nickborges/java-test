package br.com.caelum.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsuariosPage {

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
        // retorna a classe que representa a nova pagina
        return new NovoUsuarioPage(driver);
    }

	public boolean existeNaListagem(String nome, String email) {
		// verifica se ambos existem na listagem
		return driver.getPageSource().contains(nome) && 
				driver.getPageSource().contains(email);
	}

}
