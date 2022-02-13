package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public final static String LOGIN = "katsssru@gmail.com";
    public final static String PASSWORD = "Admin123";
    public static final String BASE_URL = "http://prestashop.qatestlab.com.ua/en/";
    public final static String FIRSTNAME = "Kate";
    public final static String LASTNAME = "Sh";
    public final static String ADDRESS1 ="123 Melrose street";
    public final static String CITY = "New York";
    public final static String POSTCODE = "12345";
    public final static String PHONE = "1234567";
    public final static String PHONEMOBILE = "1234567";
    public final static String OTHER= "some other text";

    protected static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod(alwaysRun = true)
    public void init() {
        driver.get(BASE_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass(alwaysRun = true)
    public static void tearDown() {
        driver.close();
    }
}
