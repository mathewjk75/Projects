package PractoPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class SetUp {

public WebDriver driver=null;	
	
public WebDriver initilization() throws Exception
{
	 ProfilesIni profile = new ProfilesIni();
     FirefoxProfile ffprofile = profile.getProfile("default");
     driver = new FirefoxDriver(ffprofile);
     return driver;
}
}