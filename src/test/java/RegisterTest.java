import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void registerTest (){
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Ramo");
        driver.findElement(By.id("lastname")).sendKeys("Ramonescu");
        driver.findElement(By.id("email_address")).sendKeys("ramonaramona@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("RamoRamo");
        driver.findElement(By.id("confirmation")).sendKeys("RamoRamo");
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
    }


    @After
    public void quit () {
        driver.quit();
    }

}
