package orangetest;///
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
@Test


public class LoginTestCash {
  private static WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver","D:/Selanium/chromedriver_win32_3/chromedriver.exe ");
    driver = new ChromeDriver();
    
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
 

  @Test
  public void testOrange() throws Exception {
    driver.get("https://opensource-demo.orangehrmlive.com/");
   
   
    
    driver.findElement(By.id("txtUsername")).click();
    
    driver.findElement(By.id("txtUsername")).clear();
    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    driver.findElement(By.id("txtPassword")).click();
    driver.findElement(By.id("txtPassword")).clear();
    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
    driver.findElement(By.id("btnLogin")).click();
    TakesScreenshot  ts=(TakesScreenshot)driver;
    File source=ts.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(source, new File("C:\\ec\\Eample\\login\\src\\test\\java\\orangetest\\Login.png"));
    try {
      assertEquals(driver.findElement(By.id("welcome")).getText(), "Welcome Admin");
      
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("welcome")).click();
    
    driver.findElement(By.linkText("Logout")).click();
    
  }
  
  

  @AfterClass(alwaysRun = true)
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
