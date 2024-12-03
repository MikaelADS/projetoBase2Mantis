package desafioBase2;

import org.openqa.selenium.WebDriver;

public class base2PageObjects {
	private DSLbase2 dsl;
	
	
	public base2PageObjects(WebDriver driver) {
		dsl = new DSLbase2(driver);
	}
	public void setLogin(String usuario) {
		dsl.escreverCampo("username",usuario);
	}

}
