package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {

    private WebDriver driver;


    // @ Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Browser/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://www.bouletcorp.com");
        driver.manage().window().maximize();

    }

    // @ After
    public void tearDown() {
        driver.quit();
    }
}

