import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    public void loginWithValidCredentials() {

        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("ramonaramona@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("RamoRamo");
        driver.findElement(By.id("send2")).click();
        WebElement welcomeTextElement = driver.findElement(By.cssSelector(".hello strong"));
        String welcomeText = welcomeTextElement.getText();
////        if (welcomeText.equals("Hello, Ramo Ramonescu!"))
////            System.out.println("Success");
////        else
////            System.err.println("Fail");
        Assert.assertTrue(welcomeTextElement.isDisplayed());
        Assert.assertEquals("Hello, Ramo Ramonescu!", welcomeText);
//
//        WebElement stateDropdown = driver.findElement(By.id("billing:region_id"));
//        Select select = new Select(stateDropdown);
//        select.selectByValue("10");
//        select.selectByVisibleText("Romania");
    }


    @Test
    public void loginWithInvalidCredentials(){

        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("ramonaramona@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("RamoRamooo");
        driver.findElement(By.id("send2")).click();
        WebElement welcomeTextElement = driver.findElement(By.cssSelector(".hello strong"));
        String welcomeText = welcomeTextElement.getText();
////////
//////        if (welcomeText.equals("Invalid login or password."))
//////            System.out.println("Success");
//////        else
//////            System.err.println("Fail");
        Assert.assertTrue(welcomeTextElement.isDisplayed());
        Assert.assertEquals("Hello, Ramo Ramonescu!", welcomeText);
    }

//
//    @Test
//    public void testSearchButton(){
//        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
//        driver.findElement(By.cssSelector("input[type=search]"));
//
//
//    }


        @After
        public void quit () {
            driver.quit();
        }

    }
