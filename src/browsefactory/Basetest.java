package browsefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Basetest {
    public static WebDriver driver;

    //method for openbrowser
    public void openWebBrowser(String baseUrl){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();


        //launch url
        driver.get(baseUrl);
        //maximise window
        driver.manage().window().maximize();
        //implicittime
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    //close browser
    public void closeBrowser(){
        driver.quit();
    }

}
