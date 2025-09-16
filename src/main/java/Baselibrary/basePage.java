package Baselibrary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

  
public class basePage {

	 public static WebDriver driver;
	 
	 @BeforeMethod
	 public void initialBrowser() {
			String browser = "Chrome";
			
			switch(browser.toLowerCase()) {
			
			case "chrome" :
				 WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
				 
				 System.out.println("Chrome Browser is Launched");
				 break;
				 
			case "firefox" :
				 WebDriverManager.firefoxdriver().setup();
				 driver = new FirefoxDriver();
				 
				 System.out.println("Firefox is Launched");
				 break;
				 
			case "edge" :
				 WebDriverManager.edgedriver().setup();
				 driver = new EdgeDriver();
				 System.out.println("Edge Browser is Launched");
				 break;
			}
			
			driver.manage().window().maximize();
			driver.get("https://www.mobibattle.com/#/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	 }
	 
	 public String captureScreen(String tname) throws IOException{
		 
		 String timeStamp = new SimpleDateFormat("yyyyMMDDhhmmss").format(new Date());
		 
		 TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
		 File sourceFile = takesScreenShot.getScreenshotAs(OutputType.FILE);
		 
		 String targetFilePath = System.getProperty("user.dir")+ "\\reports\\" + tname + "_"+timeStamp + ".jpg";
		 File targetFile = new File(targetFilePath);
		 
		 sourceFile.renameTo(targetFile);
		 
		 return targetFilePath;
	 }
		
		@AfterMethod
	 public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	        }
				 
			
			
}
