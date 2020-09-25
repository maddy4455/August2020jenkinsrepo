package browserStack;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class edgeBrowser_Test {

	public static final String AUTOMATE_USERNAME = "maddyrav1";
	public static final String AUTOMATE_ACCESS_KEY = "jnhDd1ykwpjqwCpNvAhv";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";
	public WebDriver driver = null;

	@BeforeClass
	public void setup() throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os", "OS X");
		caps.setCapability("os_version", "Catalina");
		caps.setCapability("browser", "Edge");
		caps.setCapability("browser_version", "latest-beta");
		caps.setCapability("project", "com.browserstack");
		caps.setCapability("build", "Build1.1");
		caps.setCapability("name", "macos_EdgeBrowserTest");
		caps.setCapability("browserstack.local", "false");
		caps.setCapability("browserstack.networkLogs", "true");
		caps.setCapability("browserstack.selenium_version", "3.141.5");
		caps.setCapability("browserstack.debug", "true");
		driver = new RemoteWebDriver(new URL(URL), caps);

	}

	@Test
	public void verifySearchbox() {
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
		element.sendKeys("books");
		element.submit();
		String actPagetitle = driver.getTitle();

		System.out.println("page title is: " + actPagetitle);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
