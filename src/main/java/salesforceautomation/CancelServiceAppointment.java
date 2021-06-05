package salesforceautomation;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CancelServiceAppointment {
	
	public static void main(String[] args) throws InterruptedException, ParseException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//1) Launch the app
				driver.get("https://login.salesforce.com/");
				
		//2) Click Login
		//3) Login with the credentials
				driver.findElementByXPath("//input[@id='username']").sendKeys("cypress@testleaf.com");
				driver.findElementByXPath("//input[@type='password']").sendKeys("Selbootcamp@123");
				driver.findElementByXPath("//input[@type='submit']").click();
				Thread.sleep(30000);

	    //4) Click on the App Launcher Icon left to Setup
				driver.findElementByXPath("//*[@class='slds-icon-waffle']").click();
				Thread.sleep(30000);
			
		//5) Click on View All
				driver.findElementByXPath("//button[text()='View All' and @class='slds-button']").click();
				Thread.sleep(30000);
				
		//6) Click on Service Appointments
				driver.findElementByXPath("//input[@type='search' and @class='slds-input']").sendKeys("Service Appointments");
				Thread.sleep(30000);
				driver.findElementByXPath("//p/mark[contains(text(),'Service Appointments')]").click();
				Thread.sleep(30000);
				
		//7) Click on the Dropdown Option on Right corner of newly Created Service Appointment 
	
				
				Thread.sleep(3000);	
				WebElement dropdown = driver.findElementByXPath("//a[contains(@class,'slds-button slds-button--icon-x-small slds-button--icon-border-filled')]");
				driver.executeScript("arguments[0].click();",dropdown );
		
	    //8) Select Option Cancel service  Apoointment 
				
				
				//WebElement dropdown1=driver.findElementByXPath("//li[@role='presentation']//a[@title='Cancel Service Appointment']");
				//driver.executeScript("arguments[0].click();",dropdown1);
				
		//9) click on Confirm Cancellation
				Thread.sleep(30000);
				driver.findElementByXPath("//button[contains(text(),'Confirm Cancellation')]").click();
				
		//10) Verify the status of The Appointment
				@SuppressWarnings("deprecation")
				WebDriverWait wait1 = new WebDriverWait(driver, 30);
				WebElement message = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]")));
				String output = message.getText();
				String[] split = output.split(" ");
				System.out.println("The "+split[0]+split[1]+ split[2]+split[3]+split[4]+" successfully");
				
				WebElement cancelstatus = driver.findElementByXPath("//span[contains(text(),'Canceled')]");
				String cancelstatusmsg = cancelstatus.getText();
				System.out.println(cancelstatusmsg);
								
	}
	
}
