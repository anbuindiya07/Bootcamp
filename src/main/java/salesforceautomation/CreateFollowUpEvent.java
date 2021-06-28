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

public class CreateFollowUpEvent extends baseclass{
	
	//@Test(dataProvider="fetchData",retryAnalyzer=RetryFailedTestcases.class)
	public static void main(String[] args) throws InterruptedException
	
	{
		
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
		
		//7. Click the dropdown of first result and click Create Follow-Up Event
		
				Thread.sleep(30000);
				WebElement dropdownfirst = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger')]"))); 
				driver.executeScript("arguments[0].click();",dropdownfirst );
				WebElement crtfollwoupevent =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Create Follow-Up Event']")));
				driver.executeScript("arguments[0].click();",crtfollwoupevent );
				 	
		//8. Select the  Account in Assigned to field ---> ignore the step
		//9. Select Subject as Meeting
				Thread.sleep(30000);
				WebElement subject = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Subject']/following::input[@type='text'])[1]")));		
				subject.sendKeys(Keys.BACK_SPACE , Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
				subject.sendKeys("Meeting");		
				//WebElement searchsubject= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left slds-dropdown_length-with-icon-7']")));		
				//searchsubject.click();
					
		//10. Select the Name of the person in Name field
				WebElement searchcontacts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search Contacts']")));
				searchcontacts.click();
				WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Anil Elumalai')]")));
				driver.executeScript("arguments[0].click();",name );
				
		//12. Select start date as next month 5th day 8 Am and End day as 15th day 3 PM.
		
				Thread.sleep(30000);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			    LocalDate startdate = LocalDate.now().plusMonths(1).plusDays(5);
				WebElement earlieststartdate = driver.findElementByXPath("(//label[text()='Date'])[1]/following::input[1]");
				earlieststartdate.clear();
				earlieststartdate.sendKeys(dtf.format(startdate));
				
				//time			
				WebElement earlieststarttime = driver.findElementByXPath("(//label[text()='Date'])[1]/following::input[2]");
				earlieststarttime.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);  
				earlieststarttime.sendKeys("8:00 AM");
				//End day as 15th day 3 PM.
				
				LocalDate enddate = LocalDate.now().plusMonths(1).plusDays(15);
				WebElement earliestenddate = driver.findElementByXPath("(//label[text()='Date'])[1]/following::input[4]");
				earliestenddate.clear();
				earliestenddate.sendKeys(dtf.format(enddate));
				Thread.sleep(30000);
				WebElement earliestendtime = driver.findElementByXPath("(//label[text()='Date'])[1]/following::input[5]");
				earliestendtime.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
				earliestendtime.sendKeys("3:00 PM");
		
		//11. Select the Product in related to field
		
				WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/img[@title='Accounts']")));
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",product);
				product.click();
				WebElement selectproduct= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[@title='Products']")));	
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",selectproduct);
				selectproduct.click();
		
		//13. Click Save button
		
				driver.findElementByXPath("//button[@title='Save']").click();
		
			//msg
				  @SuppressWarnings("deprecation")
					WebDriverWait wait1 = new WebDriverWait(driver, 30);
					WebElement message = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,toastMessage slds-text-heading--small forceActionsText')]")));
					String output = message.getText();
					String[] split = output.split(" ");
					System.out.println("The "+split[0]+split[1]+ split[2]+split[3]+" successfully");
				
				
	}

	private static void Thread(int i) {
		// TODO Auto-generated method stub
		
	}
	
	
}
