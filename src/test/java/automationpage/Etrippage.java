package automationpage;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Etrippage 
{
	WebDriver driver;

	By sourcecity = By.xpath("//*[@id=\"txtSrcCity\"]");
	By ban = By.xpath("//div[@class='search_bg']//li[1]");
	By destinationcity = By.xpath("//input[@id='txtDesCity']");
	By hyd = By.xpath("//div[@class='drop3']//li[1]");
	By date = By.xpath("//input[@id='datepicker']");
	By search = By.xpath("//input[@id='srcbtn']");


	public Etrippage(WebDriver driver)
	{
		this.driver= driver;
	}

	public void set() throws Exception
	{
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(sourcecity).click();
		driver.findElement(ban).click();
		driver.findElement(destinationcity).click();
		driver.findElement(hyd).click();
		driver.findElement(date).click();
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("E:\\etrippage1.png"));
		
		while(true)
		{
			WebElement month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
			String month1 = month.getText();
			if(month1.equals("November"))
			{
				System.out.println(month);
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
			
			List <WebElement> alldates1 = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a"));
			
			for(WebElement dateelement:alldates1)
			{
				String date = dateelement.getText();
				if(date.equals("7"))
				{
					dateelement.click();
					break;
				}
			}
			
			
		}
	}

	public void search()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(search).click();
	}

	public void backhome()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.navigate().back();
	}
	public void close()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.close();
	}
}
