import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTest {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test

    public void addToCartTest(){
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("ramonaramona@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("RamoRamo");
        driver.findElement(By.id("send2")).click();
        WebElement welcomeTextElement = driver.findElement(By.cssSelector(".hello strong"));
        String welcomeText = welcomeTextElement.getText();
//        if (welcomeText.equals("Hello, Ramo Ramonescu!"))
//            System.out.println("Success");
//        else
//            System.err.println("Fail");
        Assert.assertTrue(welcomeTextElement.isDisplayed());
        Assert.assertEquals("Hello, Ramo Ramonescu!", welcomeText);


    }

    @After
    public void quit () {
        driver.quit();
    }

}

