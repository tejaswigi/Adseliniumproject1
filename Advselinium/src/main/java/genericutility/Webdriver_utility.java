package genericutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Webdriver_utility 
{

	/**
	 * This method used to wait for the load in Gui
	 */
	public void implicitywait(WebDriver driver)
			{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
	/**
	 * This method is used for switching windows
	 * @param driver
	 * @param partialwindowTitle
	 */
	public void switchwindow(WebDriver driver,String partialwindowTitle)
	{
		Set<String>allid=driver.getWindowHandles();
		Iterator<String>id=allid.iterator();
		while(id.hasNext())
		{
			String wid=id.next();
			driver.switchTo().window(wid);
			String title=driver.getTitle();
			if(title.contains("partialwindowTitle"));
			{
				break;
			}
		}
	}
	
	/**
	 * wait for page to load before identifying any synchronized element in DOM
	 */
	
	public void waitforpageToLoad(WebDriver driver)
	{

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * used to wait for element to be clickable in Gui and check for specific element for every 500ms
	 */
	public void waitforelementwithcustomtimeout(WebDriver driver,WebElement element,int pollingtime) 
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}


/**
 * used to switch to Alertwindowandaccept(click on ok button)
 * @param driver
 * @author suhas
 */
public void switchtoAlertandAccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
}

/**
 * used to switch to frame window based on index
 * @param driver
 * @param index
 * @author suhas
 * */
public void switchtoframe(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}

/**
 * used to switch to alert window and dismiss(click on cancelbutton)
 * @param driver
 */

public void switchtoAlertandDismiss(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
public void mouseoveronelement(WebDriver driver, WebElement morelink) {
	// TODO Auto-generated method stub
	
}
}
 

	
	
	
	
	
	

