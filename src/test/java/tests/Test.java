package tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test {

	//This is just for test
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://demowebshop.tricentis.com/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

		driver.findElement(By.id("Email")).sendKeys("laura.taylor1234@example.com");

		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("test123");

		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop");
		driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();

		driver.quit();
	}

}
