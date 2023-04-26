package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver InitializeWebDriver() throws IOException {
	    String file = System.getProperty("user.dir")+"/src/test/java/Resources/data.properties";
	    FileInputStream fis = new FileInputStream(file);
	    prop = new Properties();
	    prop.load(fis); 	
	    String browserName = prop.getProperty("browser");
	    if(browserName.equals("chrome")) {
	    	driver = new ChromeDriver();
	    }
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    return driver;
  }
}
