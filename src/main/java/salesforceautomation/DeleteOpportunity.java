package salesforceautomation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteOpportunity extends  baseclass {
	
	@Test
	
	public  void deleteopprtunity () throws InterruptedException
	{
	
//	WebDriverManager.chromedriver().setup();
//	driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	
//	//1.Login to https://login.salesforce.com
//		driver.get("https://login.salesforce.com/");
//		driver.findElementByXPath("//input[@id='username']").sendKeys("cypress@testleaf.com");
//		driver.findElementByXPath("//input[@type='password']").sendKeys("Selbootcamp@123");
//		driver.findElementByXPath("//input[@type='submit']").click();
//		Thread.sleep(30000);
//
//	//2. Click on toggle menu button from the left corner
//		driver.findElementByXPath("//*[@class='slds-icon-waffle']").click();
//		Thread.sleep(30000);
//	
//	//3. Click view All and click Sales from App Launcher
//		driver.findElementByXPath("//button[text()='View All' and @class='slds-button']").click();
//		Thread.sleep(30000);
//		driver.findElementByXPath("//p[contains(text(),'Manage your sales')]").click();
//		Thread.sleep(30000);
	
//	//4. Click on Opportunity tab 
//		driver.executeScript("arguments[0].click()", driver.findElementByXPath("//a[@title='Opportunities']/span"));
//		Thread.sleep(30000);
		
	//5. Search the Opportunity 'Salesforce Automation by Your Name'
	
		WebElement objentername= driver.findElementByXPath("(//input[@type='text'])[2]");
		objentername.sendKeys("Salesforce Automation by Anbukarasi");
		objentername.sendKeys(Keys.ENTER);

	//6. Click on the Dropdown icon and Select Delete
	
		Thread.sleep(30000);
		WebElement table= driver.findElementByXPath("(//table[@role='grid'])[2]//tr[1]/th/span/a");
		table.click();
		
		Thread.sleep(30000);
		driver.findElementByXPath("//*[@class='slds-button slds-button_icon-border-filled']").click();
		driver.findElementByXPath("//a[@name='Delete']").click();
		Thread.sleep(30000);
		driver.findElementByXPath("//span[text()='Delete' and @class=' label bBody']").click();
		
	//7. Verify Whether Oppurtunity is Deleted using Oppurtunity Name
		
		@SuppressWarnings("deprecation")
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		WebElement message = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]")));
		String output = message.getText();
		String[] split = output.split(" ");
		System.out.println("The "+split[0]+split[1]+ split[2]+split[3]+" successfully");
	    
		
	
}
}
