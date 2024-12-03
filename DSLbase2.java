package desafioBase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSLbase2 {
	private WebDriver driver;
	public DSLbase2(WebDriver driver) {
		this.driver = driver;
		}
	public void escrever(By by, String texto){
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);	
		}
	public void escreverCampo(String id_campo, String texto){
		escrever(By.id(id_campo), texto);	
		}
	public void escreverCampoSelecionarPerfil(String id_campo, String texto){
		escrever(By.id(id_campo), texto);	
		}
	public void escreverCampoDescricao(String id_campo, String texto){
		escrever(By.id(id_campo), texto);
		}
	public void escreverCampoPassosparaReproduzir(String id_campo, String texto){
		escrever(By.id(id_campo), texto);
		}
	public void escreverCampoInformacoesAdicionais(String id_campo, String texto){
		escrever(By.id(id_campo), texto);
		}
	public void escreverCampoResumo(String id_campo, String texto){
		escrever(By.id(id_campo), texto);
		}
	public void clicarBotaoOk (String id_campo) {
		driver.findElement(By.cssSelector(id_campo)).click();
		}	
	public void clicarLink(String texto) {
		driver.findElement(By.linkText(texto)).click();
		}
	public void selecionarComboCategoria (String id_campo, String valor) {
		WebElement element = driver.findElement(By.id(id_campo));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
		}
	public void selecionarComboFrequencia (String id_campo, String valor) {
		WebElement element = driver.findElement(By.id(id_campo));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
		}
	public void selecionarComboGravidade (String id_campo, String valor) {
		WebElement element = driver.findElement(By.id(id_campo));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
		}
	public void selecionarComboPrioridade (String id_campo, String valor) {
		WebElement element = driver.findElement(By.id(id_campo));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
		}
	public String obterTextoDaPagina(String id) {
        WebElement label = driver.findElement(By.cssSelector("label[for='" + id + "']"));
        return label.getText();	
		}
	public void escreverCampoSeparaPor(String id_campo, String texto){
		escrever(By.id(id_campo), texto);
		}
	public void selecionarComboAplicarMarcadores (String id_campo, String valor) {
		WebElement element = driver.findElement(By.id(id_campo));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
		}
    public void selecionarOpcaoCampoVisibilidade (String radio) {
    	WebElement radioLabel = driver.findElement(By.xpath(radio));
        radioLabel.click();
        }
    public void selecionarOpcaoCampoContinuarRelatando (String check) {
    	WebElement checkLabel = driver.findElement(By.xpath(check));
        checkLabel.click();
        }	
    public void clicarBotaoCriarNovaTarefa (String buton) {
    	WebElement criarTarefaBotao = driver.findElement(By.xpath(buton));
    	criarTarefaBotao.click();
        }
    public void clicarBotaoVisualizarTarefaEnviada (String buton) {
    	WebElement visualizarTarefaButton = driver.findElement(By.xpath(buton));
        visualizarTarefaButton.click();
    	
   
        
    }
}

	