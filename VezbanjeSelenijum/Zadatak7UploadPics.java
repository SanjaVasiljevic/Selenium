package VezbanjeSelenijum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak7UploadPics {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        WebDriverWait wdWait= new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.navigate().to("https://imgflip.com/memegenerator");
        WebElement uploadNewTemplate= driver.findElement(By.id("mm-show-upload"));
        uploadNewTemplate.click();

        WebElement uploadImageFromDivice= driver.findElement(By.id("mm-upload-file"));
        uploadImageFromDivice.sendKeys("C:\\Users\\Salsa\\Desktop\\SkoobyDoo.jpg");
        Thread.sleep(2000);
        WebElement uploadButtom= driver.findElement(By.id("mm-upload-btn"));
        uploadButtom.click();
        Thread.sleep(2000);
        WebElement generateMeme=driver.findElement(By.xpath("//button[contains(text(),'Generate Meme')]"));
        generateMeme.click();

    }
}
