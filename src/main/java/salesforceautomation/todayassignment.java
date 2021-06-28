package salesforceautomation;

import java.math.BigInteger;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class todayassignment {
	
	public static void main(String[] args) throws InterruptedException, ParseException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//1. Login to https://login.salesforce.com
				driver.get("https://login.salesforce.com/");
				driver.findElementByXPath("//input[@id='username']").sendKeys("cypress@testleaf.com");
				driver.findElementByXPath("//input[@type='password']").sendKeys("Selbootcamp@123");
				driver.findElementByXPath("//input[@type='submit']").click();
				Thread.sleep(30000);

		//2. Click on toggle menu button from the left corner
				driver.findElementByXPath("//*[@class='slds-icon-waffle']").click();
				Thread.sleep(30000);
			
		//3. Click view All 
				driver.findElementByXPath("//button[text()='View All' and @class='slds-button']").click();
				Thread.sleep(30000);
				
		//4. Click Service Console from App Launcher 
				driver.findElementByXPath("//span/p[contains(text(),'Service Console')]").click();
				Thread.sleep(30000);
				
		//5. Select Home from the DropDown		
				driver.executeScript("arguments[0].click()", driver.findElementByXPath("//div[contains(@class,'slds-context-bar__icon-action')]//following::button[@title='Show Navigation Menu']"));
				driver.findElementByXPath("//a[@class='menuItem' and @title='Home']").click();
		
		//6. Add CLOSED + OPEN values and result should set as the GOAL (If the result is less than 10000 then set the goal as 10000)
							

				@SuppressWarnings("deprecation")
				WebDriverWait wait1 = new WebDriverWait(driver, 30);
				WebElement closed = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(@class,'metricAmount uiOutputText')])[1]")));
				String first = closed.getText();
				
				WebElement open = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(@class,'metricAmount uiOutputText')])[2]")));
				String second = open.getText();
				
				BigInteger first1  = new BigInteger(first);
			    BigInteger second1 = new BigInteger(second);
			    BigInteger sum1;
			 
			    sum1 = first1.add(second1);
			    int sum2 = sum1.intValue();
			    System.out.println("Result of addition = " + sum2);
			 		    
			    if( sum2 == 10000 )
			    	
			    {
			    	System.out.println ("The value is greater than 10000");
			    }
			    else
			    	driver.findElementByXPath("//button[@title='Edit Goal']").click();
			    	Thread.sleep(30000);
			    	driver.findElementByXPath("//span[@class='currencyCode']//following::input").sendKeys("10000");
			    	
			    	
			 //7. Select Dashboards from DropDown
			    	
			    driver.executeScript("arguments[0].click()", driver.findElementByXPath("//div[contains(@class,'slds-context-bar__icon-action')]//following::button[@title='Show Navigation Menu']"));
			    driver.findElementByXPath("//span[contains(text(),'Dashboards')]").click();
			    	
			 //8. Click on New Dashboard
			    
			    driver.findElementByXPath("//div[@title='New Dashboard']").click();
			    Thread.sleep(30000);
			 
			 //9. Enter the Dashboard name as "YourName_Workout"
			   WebElement dashname = driver.findElementByXPath("//input[@id='dashboardNameInput']");
			   dashname.sendKeys("YourName_Workout");
			   
			//10. Enter Description as Testing and Click on Create
			   
			   WebElement description =  driver.findElementByXPath("//input[@id='dashboardDescriptionInput']");
			   description.sendKeys("Testing");
			   driver.findElementByXPath("//button[text()='Create']").click();
			   
			//11. Click on Done
			   
			   
			    	
					
				
				
				
	}
	
	
}
