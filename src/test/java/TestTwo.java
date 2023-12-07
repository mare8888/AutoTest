import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestTwo {

    private static final By username= By.xpath("//input[@id='userName']");
    private static final By userpassword = By.xpath("//input[@id='password']");
    private static final By loginbutton = By.xpath("//button[@id='login']");
    private WebDriver driver = null;
    @BeforeMethod
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://demoqa.com/login");
        driver.manage().window().fullscreen();

    }


    @Test(dataProvider = "search_variant")
    void validLogin(String value){
        waiter(driver, username).sendKeys(value);
        waiter(driver, userpassword).sendKeys("Qwertz123456!");
        waiter(driver, loginbutton).click();

    }

    /*@AfterMethod
    void quit(){
        driver.quit();
    }*/


    @DataProvider(name = "search_variant")
    public Object[][] search_methods(){
        return new Object[][] {
                {"Bl"},
                {"Alex777"}

        };
    }



    public static WebElement waiter(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
