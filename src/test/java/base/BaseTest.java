package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties pro =new Properties();
	public static FileReader fr; 
	@BeforeTest
	public void setup() throws IOException
	{
		if(driver==null){
			System.out.println("The path is:"+ System.getProperty("user.dir"));
		FileReader fr= new FileReader(System.getProperty("user.dir")+"\\config.properties");
				pro.load(fr);
	}
		
			if(pro.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(pro.getProperty("testurl"));
			}
			else if(pro.getProperty("browser").equalsIgnoreCase("firefox"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new FirefoxDriver();
				driver.get(pro.getProperty("testurl"));
			}
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		System.out.println("Teardown successful");
	}

}
