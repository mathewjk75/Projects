package PractoPackage;
import java.awt.Button;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class NumberSearch {
	WebDriver driver =null; 
	
	@Test   
	public void executiontest() throws Exception {
		   boolean result = true;
		   //ProfilesIni profile = new ProfilesIni();
	       //FirefoxProfile ffprofile = profile.getProfile("default");
	      // WebDriver driver = new FirefoxDriver(ffprofile);
		   String urlValue="";
		 
		   DataDriver Datafetch = new DataDriver();
		   SetUp setupValue= new SetUp();
		   driver=setupValue.initilization();
		   urlValue=Datafetch.DataFetch("Data/Data.xml","Homepage","url");
		 		   
 		  
		   try
		   {
	          
		      //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
		      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		      driver.navigate().to(urlValue);
		      //Maximize the browser
		      driver.manage().window().maximize();
		      Thread.sleep(2000);
		      driver.findElement(By.id(Datafetch.DataFetch("Data/object.xml","Doctor","City"))).click();
		      Thread.sleep(2000);
		      driver.findElement(By.linkText(Datafetch.DataFetch("Data/Data.xml","Doctor","SelectCity"))).click();
		      Thread.sleep(2000);
		      //Launch website
		      Thread.sleep(2000);
		      driver.findElement(By.id("keywordsInput")).sendKeys(Datafetch.DataFetch("Data/Data.xml","Doctor","DocSelection"));
		      Thread.sleep(2000);
		      driver.findElement(By.partialLinkText(Datafetch.DataFetch("Data/object.xml","Doctor","DSelection"))).click();
		      //driver.findElement(By.linkText("Show Number")).click();
		      //driver.findElement(By.className("button-text")).click();
		      Thread.sleep(3000);
		      driver.findElement(By.xpath(Datafetch.DataFetch("Data/object.xml","Doctor","Phone"))).click();
		      Thread.sleep(3000);
		      //driver.findElement(By.xpath("//span[contains(text(), '080 6608 4027') and contains(@class,'phone')]"));
		      String pstring= driver.findElement(By.className(Datafetch.DataFetch("Data/object.xml","Doctor","PhoneText"))).getText();
		     // System.out.print("String Value"+pstring);
		      
		      
		     	      
		   }
		  catch(Exception e)
		  {
			  result = false;
			  e.printStackTrace();
		  }
		  finally 
		  {
			  // Switch back to original browser (first window)  
		   	  driver.close();
			  
			
		  }
		  System.out.println("Test Execution Result: " + (result? "Passed." : "Failed."));

	   }
	}





