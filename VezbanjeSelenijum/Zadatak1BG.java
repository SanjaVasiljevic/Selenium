package VezbanjeSelenijum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1BG {
    public static void main(String[] args) {

        //Zadatak1 : Otici na google, povecati prozor, refresovati stranicu, otici na youtube i vratiti se nazad
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();


        driver.navigate().to("https://www.google.rs/");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().back();



    }
}
