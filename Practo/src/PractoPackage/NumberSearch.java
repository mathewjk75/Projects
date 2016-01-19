package PractoPackage;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class NumberSearch {
	WebDriver driver =null; 
	
	@Test   
	public void executiontest() throws Exception {
		   boolean result = true;
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
		      Thread.sleep(3000);
		      driver.findElement(By.id(Datafetch.DataFetch("Data/object.xml","Doctor","City"))).click();
		      Thread.sleep(2000);
		      driver.findElement(By.linkText(Datafetch.DataFetch("Data/Data.xml","Doctor","SelectCity"))).click();
		      driver.findElement(By.id("keywordsInput")).sendKeys(Datafetch.DataFetch("Data/Data.xml","Doctor","DocSelection"));
		      Thread.sleep(2000);
		      driver.findElement(By.partialLinkText(Datafetch.DataFetch("Data/object.xml","Doctor","DSelection"))).click();
		      Thread.sleep(3000);
		      driver.findElement(By.xpath(Datafetch.DataFetch("Data/object.xml","Doctor","Phone"))).click();
		      Thread.sleep(3000);
		      //Verifying phone number is correct
		      String phonevalue= driver.findElement(By.className(Datafetch.DataFetch("Data/object.xml","Doctor","PhoneText"))).getText();
		      Assert.assertEquals(phonevalue, Datafetch.DataFetch("Data/Data.xml","Doctor","DocNumber"));
		      Thread.sleep(3000);
		       
		     	      
		   }
		  catch(Exception e)
		  {
			  result = false;
			  e.printStackTrace();
		  }
		  finally 
		  {
			 
		   	  driver.close();
				
		  }
		  System.out.println("Test Execution Result: " + (result? "Passed." : "Failed."));

	   }
	}





