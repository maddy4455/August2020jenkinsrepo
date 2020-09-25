package browserStack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

public class safari_Test {

	public static final String AUTOMATE_USERNAME = "maddyrav1";
	public static final String AUTOMATE_ACCESS_KEY = "jnhDd1ykwpjqwCpNvAhv";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";
	public WebDriver driver = null;

	@BeforeClass
	public void setup() throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os_version", "Catalina");
		caps.setCapability("resolution", "1920x1080");
		caps.setCapability("browser", "Safari");
		caps.setCapability("browser_version", "13.1");
		caps.setCapability("os", "OS X");
		caps.setCapability("build", "Build1.1");
		caps.setCapability("name", "macos_safariTest");
		caps.setCapability("browserstack.debug", "true");
		driver = new RemoteWebDriver(new URL(URL), caps);

	}

	@Test
	public void verifyPagetitle() {
		driver.get("https://www.google.ca");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Rajnikanth");
		element.submit();
		System.out.println(driver.getTitle());

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();

	}
}