package VezbanjeSelenijum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LogInCookies {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://wordpress.com/?apppromo");
        //ukoliko nam neko dugme ne radi da bi se kliknulo login moje biti preko kolacica

        Cookie kolacic= new Cookie("wordpress_logged_in","nekaproba21%7C1737907123%7ChTklXuanbm1EP22LXefTvms9MuwrNbAWdgd6MGdVYkP%7Cd2adbf2217fe4dd351429f796195861244249f5957d5a0d537f56076c60b52e9");
        driver.manage().addCookie(kolacic);
        driver.navigate().refresh();
        //otvori se inspect, pa se ide u gornjem desnom uglu u padajuci meni i tu se klikne naApplication
        //nakon toga se trazi coookies, klikne se na sajt i trazi se logIn name, pa se to kopira
        // i njena vrednost. To sve zamenjuje naredbe za logIn
    }
}
