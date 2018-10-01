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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest {

	private WebDriver driver;
	AppTestPage page;

	//@Test
	public void GivenInitialPageWhenFindAToZThenClick() {
		String id = "a_to_z";
		findElementByID(id);
		page.atoz.click();
		testURL("http://www.correios.com.br/a-a-z/","Pagina Errada");
	}

	//@Test
	public void GivenPageAToZWhenSerchMenuThenFind() {
		page.atoz.click();
		String id = "content-homes-a";
		findElementByID(id);
	}

	@Test
	public void GivenPageAToZWhenFindTodosOsItensThenClick() {
		page.atoz.click();
		String id = "miolo-internas";
		findElementByID(id);
		page.todosItens.click();
		System.out.println(driver.getCurrentUrl());
	}

	//@Test
	public void GivenPageTodosItensWhenSeachConteudoThenFind() {
		page.atoz.click();
		page.todosItens.click();

		String id = "miolo-internas";
		findElementByID(id);
	}

	public void testURL(String url, String mensagem) {
		String expected = url;
		String actual = driver.getCurrentUrl();
		assertEquals(mensagem, expected, actual);
	}

	public void findElementByID(String id) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		assertNotNull("Elemento não encontrado",element);
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
