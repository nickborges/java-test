package br.com.alura.leilao.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

//  Documentação
//	http://chromedriver.storage.googleapis.com/index.html
//	https://github.com/mozilla/geckodriver/releases	

	public WebDriver createWebDriver() {
		String webdriver = System.getProperty("browser", "htmlunit"); //VM Argument: -Dbrowser=firefox
		switch (webdriver) {
			case "firefox":
				return initFirefoxDriver();
			case "chrome":
				return initChromeDriver();
			default:
				return new HtmlUnitDriver();
		}
	}

	public WebDriver initChromeDriver() {
		/*System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\stepp\\Desktop\\curso-bdd\\workspace\\leilao\\drivers\\chromedriver.exe");
		return new ChromeDriver();*/
		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette",true);
			return new ChromeDriver(capabilities);
		} catch(Exception exception){
			System.out.println(exception);
		}
		return null;
	}

	public  WebDriver initFirefoxDriver() {
		/*System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\stepp\\Desktop\\curso-bdd\\workspace\\leilao\\drivers\\geckodriver.exe");*/
		try {
			System.setProperty("webdriver.gecko.driver", "geckodriver");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette",true);
			return new FirefoxDriver(capabilities);
		} catch(Exception exception){
			System.out.println(exception);
		}
		return null;
	}
}
