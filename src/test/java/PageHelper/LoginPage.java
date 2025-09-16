package PageHelper;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baselibrary.basePage;
import actionHelper.ActionHelper;
import utilities.waitUtiliy;

public class LoginPage extends basePage {
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy( id="react-select-2-input")
	private WebElement EnterCountry;
	
	@FindBy(id="phone")
	private WebElement EnterPhoneNo;
	
	@FindBy(xpath = "//input[@name='nickname']")
	private WebElement EnterName;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement NextBtn;
	
	@FindBy(xpath = "(//img[@class='object-cover h-full w-full optimize-contrast'])[1]")
	private WebElement Img;
	
	
	public void SelectTheCountry(String country) {
		
		ActionHelper.sendkeys(EnterCountry, country);
		//WaitUtility.impliciwait(1000);
		EnterCountry.sendKeys(Keys.ARROW_DOWN);
		//WaitUtility.impliciwait(1000);
		EnterCountry.sendKeys(Keys.ENTER);
	}
	
	public void EnterPhoneNo(String phNumber) {
		ActionHelper.sendkeys(EnterPhoneNo, phNumber);
	}
	
	public void EnterNickName(String name) {
		ActionHelper.sendkeys(EnterName, name);
	}
	
	public void ClickonNextBtn() {
		ActionHelper.click(NextBtn);
		}
	
	public boolean verifyNextPageOpen() {
		
		waitUtiliy.waitForVisibility(Img);
		
		boolean sel=false;
		String url =driver.getCurrentUrl();
		if(url.contains("Home")) {
			
			sel = true;
			
					}
		System.out.println(url);
		return sel;}
}
