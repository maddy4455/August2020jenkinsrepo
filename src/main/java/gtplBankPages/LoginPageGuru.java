package gtplBankPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageGuru {

	@FindBy(xpath = "//input[@name='uid']")
	WebElement UserId;
	@FindBy(xpath = "//input[@name='password']")
	WebElement Password;
	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement LoginButton;
	@FindBy(xpath = "//input[@name='btnReset']")
	WebElement ResetButton;
	@FindBy(xpath = "//td[contains(text(),'Manger Id : mngr276570')]")
	WebElement ManagerID;

	public LoginPageGuru(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void ManagerLogin() {

		UserId.sendKeys("mngr276570");
		Password.sendKeys("AtYdagE");
		LoginButton.click();

	}
	public String verifyManagerId()
	{
		return ManagerID.getText();
		
	
		
	}

}
