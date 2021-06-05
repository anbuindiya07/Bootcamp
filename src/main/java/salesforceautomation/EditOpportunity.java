package salesforceautomation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditOpportunity {
	
	
	public static void main (String[] args) throws InterruptedException
	{
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	//1.Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");
		driver.findElementByXPath("//input[@id='username']").sendKeys("cypress@testleaf.com");
		driver.findElementByXPath("//input[@type='password']").sendKeys("Selbootcamp@123");
		driver.findElementByXPath("//input[@type='submit']").click();
		Thread.sleep(30000);

	//2. Click on toggle menu button from the left corner
		driver.findElementByXPath("//*[@class='slds-icon-waffle']").click();
		Thread.sleep(30000);
	
	//3. Click view All and click Sales from App Launcher
		driver.findElementByXPath("//button[text()='View All' and @class='slds-button']").click();
		Thread.sleep(30000);
		driver.findElementByXPath("//p[contains(text(),'Manage your sales')]").click();
		Thread.sleep(30000);
	
	//4. Click on Opportunity tab 
		driver.executeScript("arguments[0].click()", driver.findElementByXPath("//a[@title='Opportunities']/span"));
		Thread.sleep(30000);
		
	//5. Search the Opportunity 'Salesforce Automation by Your Name'
	
		WebElement objentername= driver.findElementByXPath("(//input[@type='text'])[2]");
		objentername.sendKeys("Salesforce Automation by Anbukarasi");
		objentername.sendKeys(Keys.ENTER);

	//6. Click on the Dropdown icon and Select Edit
	
		Thread.sleep(30000);
		WebElement table= driver.findElementByXPath("(//table[@role='grid'])[2]//tr[1]/th/span/a");
		table.click();
		
		Thread.sleep(30000);
		driver.findElementByXPath("//*[@class='slds-button slds-button_icon-border-filled']").click();
		driver.findElementByXPath("//a[@name='Edit']").click();
		
	//7. Choose close date as Tomorrow date
		Thread.sleep(30000);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    LocalDate localDate = LocalDate.now().plusDays(1);
		WebElement closedate = driver.findElementByXPath("//input[@name='CloseDate']");
		closedate.clear();
		closedate.sendKeys(dtf.format(localDate));
	 
	 //8. Select 'Stage' as Perception Analysis
		Thread.sleep(30000);
		driver.findElement(By.xpath("(//input[@role='combobox'])[5]")).click();
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//span[contains(@title,'Perception Analysis')]")).click();
		
	//9. Select Deliver Status as In Progress
		Thread.sleep(30000);
		WebElement delstatus = driver.findElement(By.xpath("(//input[@role='combobox'])[8]"));
		//delstatus.sendKeys(Keys.PAGE_DOWN);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", delstatus);
		delstatus.click();
		Thread.sleep(30000);
		driver.executeScript("arguments[0].click()", driver.findElementByXPath("//span[contains(@title,'In progress')]"));
				
	
	//10. Enter Description as SalesForce
		Thread.sleep(30000);
		WebElement objdescription= driver.findElementByXPath("//textarea[@class='slds-textarea']");
		String description = "SalesForce";
		objdescription.sendKeys(description);	
	
	//11. Click on Save and Verify Stage as Perception Analysis
	
		driver.findElementByXPath("//button[text()='Save']").click();
		
		@SuppressWarnings("deprecation")
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		WebElement message = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]")));
		String output = message.getText();
		String[] split = output.split(" ");
		System.out.println("The "+split[0]+split[1]+ split[2]+split[3]+" successfully");
		
	}	
}
