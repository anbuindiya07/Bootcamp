package salesforceautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.internal.com.google.protobuf.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class samplecheck {
	
	public static void main(String[] args) throws InterruptedException {
		
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://ap16.lightning.force.com/lightning/r/ServiceAppointment/08p2w000000FFpoAAG/view");
	driver.findElementByXPath("//input[@id='username']").sendKeys("cypress@testleaf.com");
	driver.findElementByXPath("//input[@type='password']").sendKeys("Selbootcamp@123");
	driver.findElementByXPath("//input[@type='submit']").click();
	Thread.sleep(30000);
	driver.findElementByXPath("//a[@title='Show 7 more actions']").click();
		
	driver.executeScript("arguments[0].click()",driver.findElementByXPath("//div[text()='Edit']"));
	
		Thread.sleep(30000);	
    driver.findElementByXPath("//button[@title='Save']").click();
    @SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]")));
	String output = message.getText();
	String[] split = output.split(" ");
	System.out.println("The individual "+split[0]+split[1]+ split[2]+split[3]+split[4]+" is deleted successfully");
    
    			    
//17) Get the Appointment Number 
    
  WebElement appointnumber = driver.findElementByXPath("//table/tbody/tr[1]/th/span/a");
  
  appointnumber.getAttribute("value").toString();
  
  appointnumber.click();

}
}

