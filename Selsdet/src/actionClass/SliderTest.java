package actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\yavyo\\Desktop\\seleniumproject\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/slider/");
		driver.switchTo().frame(0);
		WebElement slider=driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		
		Actions act=new Actions(driver);
		act.moveToElement(slider).dragAndDropBy(slider,300 ,0 ).build().perform();// to drag the slider
		

	}

}
