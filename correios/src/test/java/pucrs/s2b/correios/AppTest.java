package pucrs.s2b.correios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest {

	private WebDriver driver;
	AppTestPage page;

	@Test
	public void GivenInitialPageWhenSearchAToZThenClick() {
		
		
		String id = "a_to_z";
		WebDriverWait wait = new WebDriverWait(driver, 2);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		
		assertNotNull(element);
		
		page.atoz.click();
		
		String actual = driver.getCurrentUrl();
		String expected = "http://www.correios.com.br/a-a-z/";
		assertEquals("Pagina errada",expected, actual);
	
	}

	@Before
	public void setupTest() {
		driver = new ChromeDriver();

		String InitialPage = "http://www.correios.com.br";
		driver.get(InitialPage);

		page = PageFactory.initElements(driver, AppTestPage.class);

	}

	@After
	public void teardown() {
		if (driver != null)
			driver.quit();
	}

	@BeforeClass
	static public void setupClass() {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
	}

}
