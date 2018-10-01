package pucrs.s2b.correios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AppTestPage {

	@FindBy( id="a_to_z")
	@CacheLookup
	WebElement atoz;
	
	
	
}
