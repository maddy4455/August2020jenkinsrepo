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

public class chrome_test {

	public static final String USERNAME = "maddyrav1";
	public static final String AUTOMATE_KEY = "jnhDd1ykwpjqwCpNvAhv";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public WebDriver driver = null;

	@BeforeClass
	public void setup() throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os", "OS X");
		caps.setCapability("os_version", "Catalina");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "latest-beta");
		caps.setCapability("project", "com.browserstack");
		caps.setCapability("build", "Build1.1");
		caps.setCapability("name", "macos_chromeTest");
		caps.setCapability("browserstack.local", "false");
		caps.setCapability("browserstack.networkLogs", "true");
		caps.setCapability("browserstack.selenium_version", "3.141.5");
		caps.setCapability("browserstack.debug", "true");
		driver = new RemoteWebDriver(new URL(URL), caps);
	}

	@Test
	public void verifyPagetitle() {
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("rajnikanth");
		element.submit();
		System.out.println(driver.getTitle());

	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}
}
