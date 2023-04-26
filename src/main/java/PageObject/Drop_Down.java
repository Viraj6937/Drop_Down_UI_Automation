package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Drop_Down {

    public   WebDriver driver;
	private  By auto_suggestive_drop_down = By.id("autosuggest");
	private  By auto_suggest_options = By.cssSelector("ul#ui-id-1 > li");
	
	
	public Drop_Down(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public void auto_suggestion_drop_down(String Country) throws InterruptedException {
	   boolean elementIsDisplayed = driver.findElement(auto_suggestive_drop_down).isDisplayed();
	   if(elementIsDisplayed) {
		   driver.findElement(auto_suggestive_drop_down).sendKeys(Country);
		   WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		   List<WebElement> options = driver.findElements(auto_suggest_options);
		   w.until(ExpectedConditions.visibilityOfAllElements(options));
           for(int i=0; i<options.size();i++) {
        	   String country_name = options.get(i).getText();
        	   if(country_name.contains("India")) {
        		   Thread.sleep(2000);
                   System.out.println(options.size());
        		   int rowIndex = options.size() - 1;
        		   driver.findElement(By.cssSelector("ul#ui-id-1 > li:nth-Child("+rowIndex+") > a")).click();
        	   }
           }
	   }
	}

}
