package salesforceautomation;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createnewserviceappointments {

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
				
		//7) Click on New 
				driver.findElementByXPath("(//div[@title='New'])").click();
		
		//8) Enter Description as Creating Service Appointments
				
				@SuppressWarnings("deprecation")
				WebDriverWait wait = new WebDriverWait(driver, 30);
				WebElement Description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label/span[text()='Description']/following::textarea[1]")));
				Description.sendKeys("Creating Service Appointments");
				
		//9) Click on Search Accounts under Parent Record
				driver.findElementByXPath("//input[@title='Search Accounts']").click();

		//10) Click on New  Account 
				
				WebElement newaccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='New Account']")));
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",newaccount);
				newaccount.click();
		
		//11) Enter Your name in the Account Name
				Thread.sleep(30000);
				WebElement accountname = driver.findElementByXPath("(//label/span[text()='Account Name']/following::input[@type='text'])[1]");
				accountname.sendKeys("Anbu4");	
				
		//12) Click On Save 
				
				driver.findElementByXPath("(//span[text()='Save'])[3]").click();
				
		//13) Verify Parent Record
				
//				Thread.sleep(30000);
//				WebElement parentrecord = driver.findElementByXPath("((//span[@class='pillText'])[1])");
//				parentrecord.getText();
//				System.out.println("The Parent record name is "+parentrecord);
//				
		//14) Select Today date in Earliest Start Permitted and Nearest Current Time
				
				Thread.sleep(30000);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			    LocalDate localDate = LocalDate.now();
				WebElement earlieststartdate = driver.findElementByXPath("(//label[text()='Date'])[1]/following::input[1]");
				earlieststartdate.sendKeys(dtf.format(localDate));

//				WebElement cuurenttime = driver.findElementByXPath("(//label[text()='Time'])[1]/following::input[1]");
//				cuurenttime.clear();
//				SimpleDateFormat dateFormat = new SimpleDateFormat("K.mm a");
//				String dateString = dateFormat.format(new Date()).toString();
//			    System.out.println("Current time in AM/PM: "+dateString);
//			    cuurenttime.clear();
//				cuurenttime.click();
//		    	cuurenttime.sendKeys(dateString);
		    	    	
		//15) Select 5+ days from Today's date as Due Date
				
				Thread.sleep(30000);
				LocalDate localDate1 = LocalDate.now().plusDays(5);
			    WebElement duedate = driver.findElementByXPath("(//label[text()='Date'])[1]/following::input[4]");
			    duedate.clear();
			    duedate.sendKeys(dtf.format(localDate1));
			    
		//16) click on save 
			    driver.findElementByXPath("//button[@title='Save']").click();
		
	    //17) Get the Appointment Number 
		
			    @SuppressWarnings("deprecation")
				WebDriverWait wait1 = new WebDriverWait(driver, 30);
				WebElement message = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]")));
				String output = message.getText();
				String[] split = output.split(" ");
				System.out.println("The "+split[0]+split[1]+ split[2]+split[3]+split[4]+" successfully");
			    
		//18) Click on Service Appointments 
		//19.Verify the Appointment Number
			   			  		  
				 WebElement appointnumber1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/span[contains(text(),'SA-')]")));
				 String output1 = appointnumber1.getText();
				 AssertEquals(split[3],output1);
				 System.out.println("the Appointment Number is verified"); 
				 		  
	}

	private static void AssertEquals(String string, String output1) {
		// TODO Auto-generated method stub
		
	}

}
