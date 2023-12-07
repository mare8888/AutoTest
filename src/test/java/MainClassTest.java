import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MainClassTest {

    private static final By historyButton = By.xpath("//li[@id='ca-history']");
    private static final By searchInput = By.cssSelector(".vector-search-box-input");
    private static final By article = By.xpath("//div[@class='mw-search-result-heading']/a[@data-prefixed text='Ubisoft']");
    private static final By firstHeading = By.xpath("//h1[@id='firstHeading']/span");

    private static final By firstHeadingHistory = By.xpath("//h1[@id='firstHeading']");
    private WebDriver driver = null;

    @BeforeMethod
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://ru.wikipedia.org/wiki");
        driver.manage().window().fullscreen();

    }

   @Test(dependsOnMethods = {"shouldBeVisibleHistoryPage"})
   void shouldBeUbisoftArticles(){

       waiter(driver, historyButton).click();
       waiter(driver, searchInput).sendKeys("Autodoc");
       waiter(driver, searchInput).sendKeys(Keys.ENTER);
       waiter(driver, article).click();


       String text = waiter(driver, firstHeading).getText();

       System.out.println(text);

       Assert.assertEquals("Autodoc", text);

    }

    @Test
    void shouldBeVisibleHistoryPage(){
        waiter(driver, historyButton).click();
        var text = waiter(driver, firstHeadingHistory).getText();

        Assert.assertEquals("Заглавная страница: история изменений", text);
    }

    @AfterMethod
    void quit(){
        driver.quit();
    }

    public static WebElement waiter(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}
