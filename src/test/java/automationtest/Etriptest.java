package automationtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automationpage.Etrippage;

public class Etriptest 
{
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver= new ChromeDriver();
	}
	@BeforeMethod
	public void urlloading()
	{
		driver.get("https://www.easemytrip.com/bus/");
		driver.manage().window().maximize();
	}
	@Test
	public void test() throws Exception
	{
		Etrippage ob = new Etrippage(driver);
		ob.set();
		ob.search();
		ob.backhome();
		ob.close();
		
		
	}
}
