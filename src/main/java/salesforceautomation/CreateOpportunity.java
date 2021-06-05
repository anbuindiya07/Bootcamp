package salesforceautomation;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunity {
	
	
	public static void main (String[] args) throws InterruptedException
	
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElementByXPath("//input[@id='username']").sendKeys("cypress@testleaf.com");
		driver.findElementByXPath("//input[@type='password']").sendKeys("Selbootcamp@123");
		driver.findElementByXPath("//input[@type='submit']").click();
		Thread.sleep(30000);

		//driver.findElementByXPath("//*[@class='slds-icon slds-icon_x-small']").click();
		driver.findElementByXPath("//*[@class='slds-icon-waffle']").click();
		Thread.sleep(30000);
		driver.findElementByXPath("//button[text()='View All' and @class='slds-button']").click();
		Thread.sleep(30000);
		driver.findElementByXPath("//p[contains(text(),'Manage your sales')]").click();
		Thread.sleep(30000);
		driver.executeScript("arguments[0].click()", driver.findElementByXPath("//a[@title='Opportunities']/span"));
		//driver.findElementByXPath("//span[text()='Opportunities'])").click();
		Thread.sleep(30000);
		driver.findElementByXPath("//a[@title='New']").click();
		Thread.sleep(30000);
		WebElement oppname1= driver.findElementByXPath("(//label[text()='Opportunity Name']/following::div[1]/input)");
		oppname1.sendKeys("Salesforce Automation by Anbukarasi");
		
		String opprtunityname=	driver.findElementByXPath("(//label[text()='Opportunity Name']/following::div[1]/input)").getAttribute("value").toString();
					
		System.out.println("Entered opprtunity name is: " + opprtunityname);
	
		//7. Choose close date as Today	
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		 LocalDate localDate = LocalDate.now();
		 driver.findElementByXPath("//input[@name='CloseDate']").sendKeys(dtf.format(localDate));
		
		//8. Select 'Stage' as Need Analysis
		
		Thread.sleep(30000);
		driver.findElement(By.xpath("(//input[@role='combobox'])[4]")).click();
		
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//span[contains(@title,'Needs Analysis')]")).click();
		driver.findElementByXPath("//button[text()='Save']").click();
		
		//9. click Save and Verify Opportunity Name
		
		  @SuppressWarnings("deprecation")
			WebDriverWait wait1 = new WebDriverWait(driver, 30);
			WebElement message = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]")));
			String output = message.getText();
			String[] split = output.split(" ");
			System.out.println("The "+split[0]+split[1]+ split[2]+split[3]+" successfully");
		    
				
	}

	private static void close() {
		// TODO Auto-generated method stub
		
	}
	

}
