package PractoPackage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class SearchDoctor {
	WebDriver driver =null; 
	
	@Test   
	public void executiontest() throws Exception {
		   boolean result = true;
		   SetUp setupValue= new SetUp();
		   driver=setupValue.initilization();
		   String urlValue="";
		 
		   DataDriver Datafetch = new DataDriver();
		   
		   urlValue=Datafetch.DataFetch("Data/Data.xml","Homepage","url");
 		  
		   try
		   {
	          
		      //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
		      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		      
		      //Maximize the browser
		      driver.manage().window().maximize();
		      
		      //Launch website
		      driver.navigate().to(urlValue);
		      Thread.sleep(2000);
		      driver.findElement(By.id(Datafetch.DataFetch("Data/object.xml","Doctor","City"))).click();
		      Thread.sleep(2000);
		      driver.findElement(By.linkText(Datafetch.DataFetch("Data/Data.xml","Doctor","SelectCity"))).click();
		      Thread.sleep(2000);
		      driver.findElement(By.id(Datafetch.DataFetch("Data/object.xml","Doctor","Searchbox"))).sendKeys(Datafetch.DataFetch("Data/Data.xml","Doctor","DocChoice"));
		      driver.findElement(By.linkText(Datafetch.DataFetch("Data/Data.xml","Doctor","DocChoice"))).click();
		      Thread.sleep(2000);
		      JavascriptExecutor jse = (JavascriptExecutor)driver;
		      jse.executeScript("scroll(0, 500)");
		      driver.findElement(By.linkText(Datafetch.DataFetch("Data/Data.xml","Doctor","SelectedDoc"))).click();
		      Thread.sleep(2000);
		      WebElement feedbackLink=driver.findElement(By.id(Datafetch.DataFetch("Data/object.xml","Doctor","Feebacklink")));
		      feedbackLink.click();
		      Thread.sleep(2000);
		      WebElement moreLink = driver.findElement(By.xpath(Datafetch.DataFetch("Data/object.xml","Doctor","Morelink")));
		      moreLink.sendKeys(Keys.PAGE_DOWN);
		      Thread.sleep(5000);
		      moreLink.click();
		      feedbackLink.sendKeys(Keys.PAGE_UP);
		      Thread.sleep(2000);
		      
		     	      
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


