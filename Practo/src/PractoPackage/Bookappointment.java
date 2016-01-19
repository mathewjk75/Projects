package PractoPackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

public class Bookappointment {
	
	public WebDriver driver=null;
	
	@Test   
	public void executiontest() throws Exception {
		   boolean result = true;
		   SetUp setupValue= new SetUp();
		   driver=setupValue.initilization();
		   String urlValue="";
		   String newurlValue="";

		   DataDriver Datafetch = new DataDriver();
		   
		   urlValue=Datafetch.DataFetch("Data/Data.xml","Homepage","url");
		   String searchValue=Datafetch.DataFetch("Data/Data.xml","Homepage","searchData");
		   newurlValue=urlValue+"/"+searchValue;
		   
 		  
		   try
		   {
	          
		      //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
		      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		      
		      //Maximize the browser
		      driver.manage().window().maximize();
		      
		      //Launch website
		      driver.navigate().to(newurlValue);
		      driver.findElement(By.className(Datafetch.DataFetch("Data/object.xml","Appointment","Booking"))).click();
		      Thread.sleep(5000);
		      String appointmentTime=Datafetch.DataFetch("Data/Data.xml","appointment","appointmenttime");
		      driver.findElement(By.xpath(".//*[@class='book-slot ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']/span[contains(text(), \"" + appointmentTime + "\")]")).click();
		      Thread.sleep(5000);
		      driver.findElement(By.name(Datafetch.DataFetch("Data/object.xml","Appointment","Username"))).clear();
		      driver.findElement(By.name(Datafetch.DataFetch("Data/object.xml","Appointment","Username"))).sendKeys(Datafetch.DataFetch("Data/Data.xml","appointment","username"));
		      driver.findElement(By.name(Datafetch.DataFetch("Data/object.xml","Appointment","EmailId"))).clear();
		      driver.findElement(By.name(Datafetch.DataFetch("Data/object.xml","Appointment","EmailId"))).sendKeys(Datafetch.DataFetch("Data/Data.xml","appointment","emailId"));
		      driver.findElement(By.className(Datafetch.DataFetch("Data/object.xml","Appointment","Submit"))).click();
		      Thread.sleep(5000);
		     	      
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



