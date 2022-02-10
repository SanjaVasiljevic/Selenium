package VezbanjeSelenijum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PredavanjaUploadPics {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        WebDriverWait wdWait= new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.navigate().to("https://crop-circle.imageonline.co/");
        WebElement uploadImage=driver.findElement(By.id("inputImage"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",uploadImage); //ovo je skrolovanje do elementa
        uploadImage.sendKeys("C:\\Users\\Salsa\\Desktop\\SkoobyDoo.jpg");
    }
}
