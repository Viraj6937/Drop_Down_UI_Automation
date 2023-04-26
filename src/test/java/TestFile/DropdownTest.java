package TestFile;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import PageObject.Drop_Down;
import Resources.Base;

public class DropdownTest extends Base {

	public WebDriver driver;
	
	
	@BeforeTest
	public void navigateURL() throws IOException {
		driver = InitializeWebDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void verify_application_title() {
		Assert.assertEquals(driver.getTitle().replace("\n","").replace("\t","").trim(),"QAClickJet - Flight Booking for Domestic and International, Cheap Air Tickets");
	}
	
	@Test
	public void verify_auto_suggestion_dropdown() throws InterruptedException {
		Drop_Down d= new Drop_Down(driver);
		d.auto_suggestion_drop_down("Ind");
	}
	
	@AfterTest
	public void terminate() {
		driver.quit();
	}
	
}
