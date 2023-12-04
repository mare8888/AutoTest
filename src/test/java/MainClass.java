import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.InterruptedIOException;
import static java.lang.Thread.sleep;

public class MainClass {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

/*
        driver.get("https://www.google.com/");

        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
        driver.findElement(By.xpath("//div[@jscontroller='vZr2rb']")).click();
        driver.findElement(By.xpath("//textarea[@jsname='yZiJbe']")).sendKeys("Все ок");
        driver.findElement(By.xpath("//textarea[@jsname='yZiJbe']")).sendKeys(Keys.ENTER);

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.quit();
*/


        driver.get("https://ru.wikipedia.org/wiki");

        driver.manage().window().maximize();


        driver.findElement(By.xpath("//span[text()='Просмотр кода']")).click();
        driver.findElement(By.xpath("//li[@id='ca-view']/following-sibling::li[2]")).click();
        driver.findElement(By.xpath("//ancestor::li[@id='ca-view']")).click();

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();


    }
}
