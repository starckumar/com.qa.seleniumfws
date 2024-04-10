package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class MyFirstTestFW extends BaseTest {
	@Test
	public static void loginpage()
	{
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("login_id")).sendKeys("starckumar@gmail.com");
		driver.findElement(By.id("nextbtn")).click();
		
	}

}
