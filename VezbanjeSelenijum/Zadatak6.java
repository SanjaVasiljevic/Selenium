package VezbanjeSelenijum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        WebDriverWait wdWait= new WebDriverWait(driver,Duration.ofSeconds(15));
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/Learn-Selenium-data-driven-frameworks-applications/dp/183898304X/ref=sr_1_1?crid=1PDOETTA3ICXQ&keywords=Learn+Selenium&qid=1643460751&s=books&sprefix=learn+selenium%2Cstripbooks-intl-ship%2C183&sr=1-1");

        WebElement cart = driver.findElement(By.id("nav-cart-count"));
        String cartOn0=cart.getText();
        Assert.assertEquals(cartOn0,"0");
        System.out.println("Potvrdjuje da je korpa prazna");
        WebElement addToCartButtom= driver.findElement(By.id("add-to-cart-button"));
        addToCartButtom.click();

        Thread.sleep(2000);
        WebElement cartAdd = driver.findElement(By.id("nav-cart-count"));
        String addBook1=cartAdd.getText();
        Assert.assertEquals(addBook1,"1");
        System.out.println("Potvrdjuje da se u korpi nalazi jedna knjiga");

        driver.manage().deleteCookieNamed("session-id");
        Thread.sleep(2000);
        System.out.println("Kolcic je obrisan");
        Thread.sleep(2000);
        driver.navigate().refresh();

        Thread.sleep(2000);
        WebElement cartAfterDelete = driver.findElement(By.id("nav-cart-count"));
        String cart0=cartAfterDelete.getText();
        Assert.assertEquals(cart0,"0");
        System.out.println("Potvrdjuje da je iz korpe obrisana knjiga");



    }


}
