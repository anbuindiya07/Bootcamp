package salesforceautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
	
	public ChromeDriver driver ;
	
	@Parameters ({"username","password","url"})
	@BeforeMethod
	
	public void Navigatetoopportunities(String username,String password,String url) throws Exception
	
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElementByXPath("//input[@id='username']").sendKeys("cypress@testleaf.com");
		driver.findElementByXPath("//input[@type='password']").sendKeys("Selbootcamp@123");
		driver.findElementByXPath("//input[@type='submit']").click();
		Thread.sleep(30000);

		//driver.findElementByXPath("//*[@class='slds-icon slds-icon_x-small']").click();
		driver.findElementByXPath("//*[@class='slds-icon-waffle']").click();
		Thread.sleep(30000);
		
	}

	@AfterMethod
	public void Closesalesfore()
	{
		driver.close();
	}
	}

