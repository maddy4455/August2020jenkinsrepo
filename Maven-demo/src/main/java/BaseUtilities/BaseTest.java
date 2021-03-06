package BaseUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {

	public static WebDriver driver;
	public String testName = null;
	public static String filePath;
	public static FileInputStream fis;
	public static Properties p;
	public static String projectpath = System.getProperty("user.dir");
	public static ExtentTest test;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	public static ExtentReports report;
	public static ExtentHtmlReporter htmlReporter;

	@BeforeTest
	public void init() throws Exception {

		Date dt = new Date();
		filePath = dt.toString().replace(':', '_').replace(' ', '_') + ".html";

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/extentRep.html" + filePath);
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "mac");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", "Maddy");

		fis = new FileInputStream(projectpath + "//data.properties");
		p = new Properties();
		p.load(fis);

	}

	public static void openBrowser(String browser) {
		if (browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "chromedriver");

			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "false");

			ChromeOptions option = new ChromeOptions();
			option.addArguments("user-data-dir=/Users/maddy/Library/Application Support/Google/Chrome/Profile 1");
			option.addArguments("--disable-notifications");

			driver = new ChromeDriver(option);
			driver.manage().window().maximize();

		} else if (browser.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "geckodriver");
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("Marchsel");
			profile.setPreference("dom.webnotifications.enabled", false);

			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);

			driver = new FirefoxDriver(option);
			driver.manage().window().maximize();

		} else if (browser.equals("safari")) {

			driver = new SafariDriver();
			driver.manage().window().maximize();

		}
	}

	@BeforeMethod
	public void register(Method method) {

		System.out.println("iam Befor Method.....");
		String testName = method.getName();
		test = report.createTest(testName);

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "The test method Named as : " + result.getName() + " is Failed");
			test.log(Status.FAIL, "Test failure : " + result.getThrowable());

			// String temp = Utility.getScreenshot(driver);
			test.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(Utility.getScreenshot(driver)).build());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "The Test Method Named as : " + result.getName() + " is Passed");

			test.pass("Test is Passed ",
					MediaEntityBuilder.createScreenCaptureFromPath(Utility.getScreenshot(driver)).build());

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "The Test Method Named as : " + result.getName() + " is Skipped");
		}
	}

	// to generate random numbers
	public int randomNum() {
		Random r = new Random();
		int rnum = r.nextInt(999999);
		return rnum;

	}

	@AfterTest
	public void cleanUp() throws Exception {

		report.flush();

		Thread.sleep(3000);
		driver.close();

	}
}
