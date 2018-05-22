package es.upm.dit.isst.LabElec.dao;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculadoraDatosTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	//Indicamos donde se encuentra el archivo con el driver de chrome
	System.setProperty( "webdriver.chrome.driver", "/home/isst/chromedriver");
	driver = new ChromeDriver();    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCalculadoraDatos() throws Exception {
    driver.get("http://localhost:8080/ISST2/LaboratorioElectoral.jsp");
    new Select(driver.findElement(By.id("ley"))).selectByVisibleText("Saint Lagüe");
    driver.findElement(By.id("ley")).click();
    driver.findElement(By.id("ano")).click();
    new Select(driver.findElement(By.id("ano"))).selectByVisibleText("2015");
    driver.findElement(By.id("ano")).click();
    new Select(driver.findElement(By.id("circu"))).selectByVisibleText("Comunidad autónoma");
    driver.findElement(By.id("circu")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    driver.findElement(By.xpath("//tr[13]/td[3]")).click();
    driver.findElement(By.xpath("//td[3]")).click();
    driver.findElement(By.xpath("//td[3]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | //td[3] | ]]
    driver.findElement(By.xpath("//td[3]")).click();
    driver.findElement(By.xpath("//td[3]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | //td[3] | ]]
    driver.findElement(By.xpath("//td[3]")).click();
    assertEquals("106", driver.findElement(By.xpath("//td[3]")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
