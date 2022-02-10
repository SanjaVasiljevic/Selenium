package VezbanjeSelenijum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.openqa.selenium.Keys.ENTER;

public class Zadatak2 {
    public static void main(String[] args) {
        //Zadatak 2: Otici na saj wikipedia i pronaci clanak o Nikoli Tesli.
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.navigate().to("https://www.wikipedia.org/");
        driver.manage().window().maximize();
        WebElement textBox =driver.findElement(By.xpath("//input[@id='searchInput']"));
        textBox.sendKeys("Nikola Tesla");
        textBox.sendKeys(ENTER);

        String actualURL= driver.getCurrentUrl();
        System.out.println(actualURL);


        String expectedURL="https://en.wikipedia.org/wiki/Nikola_Tesla";
        System.out.println(expectedURL);
        Assert.assertEquals(actualURL,expectedURL);
        String actualTitle=driver.findElement(By.xpath("//h1[@id='firstHeading']")).getText();
        System.out.println(actualTitle);
        String expectedTitle="Nikola Tesla";
        Assert.assertEquals(expectedTitle,actualTitle);

        driver.close();
        driver.quit();

    }
}
