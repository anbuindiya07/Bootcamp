package salesforceautomation;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sortingdate {

	@Test
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
				
			//5. Select the Table view
		List<WebElement> stage= driver.findElements(By.xpath("//div/table/thead/tr/th[6]"));
		String[] beforesort_Stage = new String[stage.size()];
		for (int i=0;i<stage.size();i++)
		{
			beforesort_Stage[i]=stage.get(i).getText();
		}
		System.out.println(beforesort_Stage);
		Arrays.sort(beforesort_Stage);
		
		System.out.println("After sort " +beforesort_Stage);

				
		}
		public static void Print (String[] ar) {
			for (int i=0;i<ar.length;i++) {
				System.out.println(ar[i]);
			}
		}
	}
	


