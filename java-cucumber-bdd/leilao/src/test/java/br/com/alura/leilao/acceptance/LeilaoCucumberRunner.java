package br.com.alura.leilao.acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features = "classpath:features", tags = "@leilao") //busca o arquivo leilão.feature dentro da pasta features
public class LeilaoCucumberRunner {

}
