package salesforceautomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateFollowUpTask {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Step 1 to 3 will be called from baseclass
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
		
		//4. Click on Content tab 		
				driver.findElementByXPath("//span/p[text()='Content']").click();
			
		//5. Click View All from Today's Task
				@SuppressWarnings("deprecation")
				WebDriverWait wait = new WebDriverWait(driver, 30);
				WebElement viewall = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a/span[text()='View All' and @class='viewAllLabel'])[2]")));
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",viewall);
				viewall.click();
		
		//6. Click the Display as dropdown under Recently Viewed and select Table
				WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Display as Split View']")));
				driver.executeScript("arguments[0].click();",dropdown );
				WebElement selecttable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@role='menuitemcheckbox'])[1]")));
				selecttable.click();
				
		//7. Click the dropdown of first result and click Create Follow-Up Task
				Thread.sleep(30000);
				WebElement dropdownfirst = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger')]"))); 
				driver.executeScript("arguments[0].click();",dropdownfirst );
//				WebElement crtfollwouptask =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@title,'Task']")));
//				driver.executeScript("arguments[0].click();",crtfollwouptask );
				Thread.sleep(30000);		
				List<WebElement> cft = driver.findElements(By.xpath("(//li[@role='presentation']//a[@role='menuitem'])"));
				String expectedRole = "Create Follow-Up Task"; 
				for(int i = 1; i<=cft.size();i++) 
				{ 
					String actualRole =driver.findElement(By.xpath("(//li[@role='presentation']//a[@role='menuitem'])"+"["+i+"]")).getText(); 
					if(actualRole.contains(expectedRole)) 
					{ 
						driver.findElement(By.xpath("(//li[@role='presentation']//a[@role='menuitem'])"+"["+i+"]")).click();
						System.out.println("the Create Follow-Up Task is selected "); 
						break;
					}
				}						
		
		//8.  Select a Account name in Assigned to field and Select a subject as Call
				
				//---> ignore "Select a Account name in Assigned to field"
				
				WebElement subject = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Subject']/following::input[@type='text'])[1]")));		
				subject.sendKeys(Keys.BACK_SPACE , Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
				subject.sendKeys("Call");	
				subject.click();
		
		//9. Set Priority as High and Status as In Progress
								
				List<WebElement> priority = driver.findElements(By.xpath("(//li[@role='presentation']//a[@role='menuitemradio'])"));
				String prioritydrp = "In Progress"; 
				for(int i = 1; i<=priority.size();i++) 
				{ 
					String actualRole =driver.findElement(By.xpath("(//li[@role='presentation']//a[@role='menuitemradio'])"+"["+i+"]")).getText(); 
					if(actualRole.contains(prioritydrp)) 
					{ 
						driver.findElement(By.xpath("(//li[@role='presentation']//a[@role='menuitemradio'])"+"["+i+"]")).click();
						System.out.println("the priority is selected "); 
						break;
					}
			}
	
		//10. Click on the image of Name field, click on Contacts and select Contact
				
				WebElement searchcontacts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search Contacts']")));
				searchcontacts.click();
				
				WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Anil Elumalai')]")));
				driver.executeScript("arguments[0].click();",name );
				
				WebElement selectproduct= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[@title='Products']")));	
				selectproduct.click();
				
				
				}
	private static void Thread(int i) {
		// TODO Auto-generated method stub
		
	}


}