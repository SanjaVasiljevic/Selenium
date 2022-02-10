package VezbanjeSelenijum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak3 {
    //Zadatak3: Otvoriti 3 taba i svaki treba da ode na neki url(po vasoj zelji), sacekati 2 sec u svakom tau, pa zatvoriti.
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> listaTabova= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to("https://www.youtube.com/");
        Thread.sleep(2000);
        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://www.wikipedia.org/");
        Thread.sleep(2000);
        driver.switchTo().window(listaTabova.get(3));
        driver.navigate().to("https://www.google.rs/");
        Thread.sleep(2000);

        for(int i=0; i<listaTabova.size();i++){
            driver.switchTo().window(listaTabova.get(i));
            driver.close();
        } //zatvaranje svih tabova
        //driver.quit();



    }
}
