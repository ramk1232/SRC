package Ttest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amaz {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone x");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Essentials Rubber Libro Flip Case For ")).click();

		Thread.sleep(5000);
		
		//To change focus from main window to child window
		Set<String> ids = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(ids);

		String child = al.get(1); // To get address of child window or new popup

		driver.switchTo().window(child); // Focus is on child window

		Thread.sleep(3000);

		WebElement selElement = driver.findElement(By.xpath("//div[@id='quantityLayoutLow_feature_div']//select")); // #selectquantity
		Select s = new Select(selElement);
		s.selectByVisibleText("2");

	}

}
