package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseTest;

public class CustomerRegistration extends BaseTest
{

	@FindBy(linkText="Sign in")WebElement signIn;
	@FindBy(id="email_create")WebElement customerEmail;
	@FindBy(xpath="//form[@id='create-account_form']//span[1]")WebElement createAccount;
	@FindBy(id="id_gender1")WebElement gender1;
	@FindBy(id="id_gender2") public WebElement gender2;
	@FindBy(id="customer_firstname")WebElement customerFirstnmae;
	@FindBy(id="customer_lastname")WebElement customerLastname;
	@FindBy(id="email")WebElement customerEmailid;
	@FindBy(id="passwd")WebElement choosePassword;
	@FindBy(id="days")WebElement DOB_day;
	@FindBy(id="months")WebElement DOB_month;
	@FindBy(id="years")WebElement DOB_year;
	@FindBy(id="firstname")WebElement firstName_address;
	@FindBy(id="lastname")WebElement lastName_address;
	@FindBy(id="company")WebElement Company;
	@FindBy(id="address1")WebElement Address1;
	@FindBy(id="address2")WebElement Address2;
	@FindBy(id="city")WebElement City;
	@FindBy(id="id_state")WebElement State;
	@FindBy(id="postcode")WebElement Postcode;
	@FindBy(id="id_country")WebElement Country;
	@FindBy(id="phone_mobile")WebElement Mobilenumber;
	@FindBy(id="alias")WebElement Alias_address;
	@FindBy(xpath="//span[contains(text(),'Register')]")WebElement submitRegister;

	
	public CustomerRegistration(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	
	public void CustomerRegistrationPage() throws Exception
	{
	
		signIn.click();
		
		//customerEmail.sendKeys("qa456381@gmail.com");
		// to generate random email 
		customerEmail.sendKeys(p.getProperty("fname")+p.getProperty("lname")+randomNum()+p.getProperty("domain"));
		String val = customerEmail.getAttribute("value");
		System.out.println(val);
		
		createAccount.click();
		gender1.click();
		customerFirstnmae.sendKeys("masdy");
		customerLastname.sendKeys("ragbv");
		//customerEmailid.sendKeys("qa456378@gmail.com");
		choosePassword.sendKeys("passwordg");
		DOB_day.sendKeys("20");
		DOB_month.sendKeys("July");
		DOB_year.sendKeys("2000");
		//firstName_address.sendKeys("maddy");
		//lastName_address.sendKeys("rambo");
		Address1.sendKeys("jasperu");
		Address2.sendKeys("1075");
		City.sendKeys("nework");
		State.sendKeys("Colorado");
		Postcode.sendKeys("80203");
		Country.sendKeys("Canada");
		Mobilenumber.sendKeys("1234567890");
		submitRegister.click();
			
		
	}


	
	
	
	

}
