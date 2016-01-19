package PractoPackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


public class androidTest {
RemoteWebDriver driver = null;
	
@Test
    public void setUp() throws Exception {


	DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
    capabilities.setCapability("automationName","Appium");
    capabilities.setCapability("platformName","Android");
    capabilities.setCapability("platformVersion", "4.2.2");
    capabilities.setCapability("deviceName", "ZH80019T5U");
    capabilities.setCapability("appPackage", "com.practo.fabric");
    capabilities.setCapability("appActivity", "com.practo.fabric.LauncherActivity");
    
	try {
        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    } catch (MalformedURLException e) {
       
        e.printStackTrace();
    }
      driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);  
              driver.quit();

}
}