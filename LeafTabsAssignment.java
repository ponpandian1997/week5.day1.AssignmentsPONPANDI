package week5.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;


public class LeafTabsAssignment {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeDriver driver =new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Click on USerName
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		//Click on Password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(2000);
		// Click on CRM/SFA Link
		driver.findElement(By.xpath("//div[@id='label']")).click();
		//Click on contacts Button
		driver.findElement(By.xpath("(//div[@class='x-panel-header'])[3]")).click();
		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		Thread.sleep(2000);
//Click on  widget From Contact 
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		//Handle The Second Window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstwindow =new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindow.get(1));
		//Take a snap
				File source = driver.getScreenshotAs(OutputType.FILE);
				File Target =new File("./snap/fromcontact.png");
				//merge source and target
				FileUtils.copyFile(source, Target);
		
//Click on first Resulting contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		//Switch back From second to First Window
		driver.switchTo().window(lstwindow.get(0));
		
//Click on Widget To Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	//HAndle The Second Window
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> lstwindow1 =new ArrayList<String>(windowHandles2);
		driver.switchTo().window(lstwindow1.get(1));
	//Take a snap
		File source2 = driver.getScreenshotAs(OutputType.FILE);
		File Target2 =new File("./snap/Tocontact.png");
		//merge source and target
		FileUtils.copyFile(source2, Target2);
  
//Click on second resulting contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[4]")).click();
		//Switch Back from second to first Window
		driver.switchTo().window(lstwindow.get(0));
		//Click On Merge
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		 //Handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//Verify the title
		String Verifythetitle = driver.getTitle();
		System.out.println(Verifythetitle);
		
		
		}

}
