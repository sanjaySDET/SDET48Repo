package vtigerGenericUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.vtigerObjectRepository.HomePage;
import com.crm.vtigerObjectRepository.LoginPage;
/**
 * 
 * @author SanjayBabu
 *
 */
public class BaseClass {
	public static WebDriver sdriver;
	public WebDriver driver=null;
	public JavaUtility jLib = new JavaUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebdriverUtility wLib = new WebdriverUtility();
	
	/**
	 * connect db
	 */
	@BeforeSuite
	public void openDBConnection() {
		System.out.println("data base connection established");
	}

	/**
	 * launch the browser
	 * @throws IOException
	 */
	
//	@Parameters("BROWSER")
	@BeforeClass
	public void openBrowser() throws IOException {
	    String BROWSER = fLib.getPropertyKeyValue("browser");
	//	String BROWSER = System.getProperty("browser");
		String URL = fLib.getPropertyKeyValue("url");
		
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
		//	WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("chrome"))
		{
		//	WebDriverManager.firefoxdriver().setup();
			driver=new ChromeDriver();
		}else {
		//	WebDriverManager.chromedriver().create();
			driver=new ChromeDriver();
		}
//		switch (BROWSER) {
//		case "chrome":
//			driver=WebDriverManager.chromedriver().create();
//			break;
//		case "firefox":
//			driver=WebDriverManager.firefoxdriver().create();
//			break;
//		case "edge":
//			driver=WebDriverManager.edgedriver().create();
//			break;
//		default:
//			driver=WebDriverManager.chromedriver().create();
//			break;
//		}
		sdriver=driver;
		System.out.println("browser launched");
		driver.get(URL);
		wLib.maximizeWindow(driver);
		wLib.waitTillPageGetsLoad(driver);
	}

	/**
	 * login to application
	 * @throws IOException 
	 */
	@BeforeMethod
	public void loginToApp() throws IOException  {
		
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
		System.out.println("successfully logged into from application");
	}

	/**
	 * logout from application
	 */
	@AfterMethod
	public void logoutFromApp() {
		HomePage homePage = new HomePage(driver);
		homePage.logoutFromApp(driver, wLib);
		System.out.println("successfully logged Out from application");
	}
	
	/**
	 * close the browser
	 * @throws Throwable
	 */
	@AfterClass
	public void closeBrowser() throws Throwable {
		driver.quit();
		System.out.println("Browser is closed");
	}
	
	/**
	 * close db
	 */
	@AfterSuite
	public void closeDBConnection() {
		System.out.println("data base connection closed");
	}
}