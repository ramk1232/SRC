package liabrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Browser {

	public static WebDriver driver;

	public static void StartBrowser(String browsername) {
		if (browsername.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browsername.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver1.exe");
			driver = new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("IE")) {
			
			System.setProperty("webdriver.edge.driver", "C:\\Selenium\\msedgedriver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.cortexedi.com/");
		
	}
	
	@BeforeClass
	public void initializeBrowser() {
		Browser.StartBrowser("Chrome");
	}
	
	@AfterClass
	public void afterMethod() {
		driver.close();
	}
}
	


