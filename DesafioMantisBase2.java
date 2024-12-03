package desafioBase2;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DesafioMantisBase2 {
	private WebDriver driver;
	private DSLbase2 dsl;
	@Before
	public void inicializa () {
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://mantis-prova.base2.com.br/login_page.php");
		dsl = new DSLbase2(driver);
		dsl.escreverCampo("username", "mikael_silva");
    	dsl.clicarBotaoOk("input[type='submit']");
		dsl.escreverCampo("password", "M@teus2704");
		dsl.clicarBotaoOk("input[type='submit']");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@After
	public void finalizar () {
//		driver.quit();	
	}
	@Test
	public void criarTarefaMantis() {
		dsl.clicarLink("Criar Tarefa");
		dsl.selecionarComboCategoria("category_id", "[Todos os Projetos] categoria teste");
		Assert.assertEquals("Categoria", dsl.obterTextoDaPagina("category_id"));
		dsl.selecionarComboFrequencia("reproducibility", "às vezes");
		Assert.assertEquals("Freqüência", dsl.obterTextoDaPagina("reproducibility"));
		dsl.selecionarComboGravidade("severity", "grande");
		Assert.assertEquals("Gravidade", dsl.obterTextoDaPagina("severity"));
		dsl.selecionarComboPrioridade("priority", "urgente");
		Assert.assertEquals("Prioridade", dsl.obterTextoDaPagina("priority"));
		dsl.escreverCampoSelecionarPerfil("os", "Android");
		Assert.assertEquals("Selecionar Perfil", dsl.obterTextoDaPagina("profile_id"));
		dsl.escreverCampoResumo("summary", "Teste Base 2");
		Assert.assertEquals("Resumo", dsl.obterTextoDaPagina("summary"));
		dsl.escreverCampoDescricao("description", "Teste base 2");
		Assert.assertEquals("Descrição", dsl.obterTextoDaPagina("description"));
		dsl.escreverCampoPassosparaReproduzir("steps_to_reproduce", "Dado, quando e então");
		Assert.assertEquals("Passos para Reproduzir", dsl.obterTextoDaPagina("steps_to_reproduce"));
		dsl.escreverCampoInformacoesAdicionais("additional_info", "Testando 123");
		Assert.assertEquals("Informações Adicionais", dsl.obterTextoDaPagina("additional_info"));
		dsl.selecionarComboAplicarMarcadores("tag_select", "CriarTafera");
		Assert.assertEquals("CriarTafera", "CriarTafera");
		dsl.selecionarOpcaoCampoVisibilidade("//label[span[text()='privado']]");
		dsl.selecionarOpcaoCampoContinuarRelatando("//label[span[text()='selecione para criar mais tarefas']]");
		dsl.clicarBotaoCriarNovaTarefa("//input[@value='Criar Nova Tarefa']");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.bold.bigger-110")));
        String expectedText = "Operação realizada com sucesso.";
        String actualText = element.getText();        
        if (expectedText.equals(actualText)) {
            System.out.println("Texto validado com sucesso!");
        } else {
            System.out.println("Texto não corresponde! Esperado: " + expectedText + ", Obtido: " + actualText);
        }
        dsl.clicarBotaoVisualizarTarefaEnviada("//a[contains(text(),'Visualizar Tarefa Enviada')]");	 
	}
}
