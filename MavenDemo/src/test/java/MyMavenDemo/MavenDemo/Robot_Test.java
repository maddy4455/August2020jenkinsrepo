package MyMavenDemo.MavenDemo;

import org.openqa.selenium.By;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseClass.BaseTest;

public class Robot_Test extends BaseTest {

	@Test
	public void Robot() throws SikuliException, Exception {

		openBrowser("chrome");

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");

		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		driver.findElement(By.id("firstName")).sendKeys("ramm");
		driver.findElement(By.id("lastName")).sendKeys("rads");
		driver.findElement(By.xpath("//*[@id=\"employeeId\"]")).sendKeys("0015");
	
		//Sikuli starts from here
		Screen s=new Screen();
		
		String fileInputPath = "C:\\Images\\";
		
		Pattern img1=new Pattern("C:\\Images\\choose_file.PNG");
		Pattern img2=new Pattern("C:\\Images\\filename-textbox.PNG");
		Pattern img3=new Pattern("C:\\Images\\open.PNG");
		Pattern img4=new Pattern("C:\\Images\\save.PNG");
		
		s.click(img1);
		Thread.sleep(3000);
		
		s.wait(img2, 20);
		s.type(img2,fileInputPath+"images.jpg");
		
		s.click(img3);
		
		s.wait(img4, 20);
		s.click(img4);
	
		String empName = driver.findElement(By.xpath("//h1[contains(text(),'ramm rads')]")).getAttribute("innerHTML");
		System.out.println("current page name is :-"+empName);
		String expempName = "ramm rads";
		
		Assert.assertTrue(empName.equals(expempName), "Both linktexts are  equal");
		test.log(Status.PASS, "succesfully added new employee :-"+empName);
		

	}
}
