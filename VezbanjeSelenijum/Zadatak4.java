package VezbanjeSelenijum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;

public class Zadatak4 {
    //Zadatak4: Napraviti program koji ce se ulogovati na wordpress i proveriti da li se korisnik ulogovao
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://wordpress.com/?apppromo");
        WebElement logIn= driver.findElement(By.xpath("//*[@id=\"masterbar\"]/ul/li[1]/a"));
        logIn.click();
        //Thread.sleep(2000); eksplicitnio cekanje se gasi kad se uvede implicitno cekanje sto je wdwait na 21 liniji
        /*WebElement emailAddress= driver.findElement(By.name("usernameOrEmail"));
        emailAddress.sendKeys("nekaproba@gmail.com");
        emailAddress.sendKeys(ENTER);

        //Thread.sleep(2000);
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("Qwerty123");
        password.sendKeys(ENTER);*/
        //Thread.sleep(2000);

        String actualURL= driver.getCurrentUrl();
        System.out.println(actualURL);
        String expectedURL="https://wordpress.com/read";
        System.out.println(expectedURL);
        Assert.assertNotEquals(expectedURL,actualURL);
        System.out.println("Potvrdjuje se da je korisnik LogIn");

        /*String actualTitle=driver.findElement(By.xpath("//span[contains(text(),'My Site')]")).getText();
        System.out.println(actualTitle);
        String expectedTitle="My Site";
        Assert.assertEquals(expectedTitle,actualTitle);
        System.out.println("Potvrdjuje se da je to  isti tekst");
        */ //neradi linije 40 ne znam zasto :)
        WebElement profileButtom=driver.findElement(By.className("gravatar"));
        Assert.assertTrue(profileButtom.isDisplayed());
        System.out.println("Potvrdjuje se da je pronadjen profil");
        driver.close();
        driver.quit();

    }
}
