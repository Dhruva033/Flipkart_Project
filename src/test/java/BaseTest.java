import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser){

        if (browser.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
           driver=new FirefoxDriver();
        }
        else {
            throw new IllegalArgumentException("Invalid browser name"+"------>"+browser);
        }
       driver.manage().window().maximize();
    }

    @AfterClass
    public void Afterclass(){
        driver.quit();
    }

}
