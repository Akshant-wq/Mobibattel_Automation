package PageHelper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baselibrary.basePage;
import actionHelper.ActionHelper;
import utilities.waitUtiliy;

public class LogOutPage extends basePage {
	
	public LogOutPage() {
		PageFactory.initElements(driver, this);
	}
   
	@FindBy(xpath="//a[@href='#/myprofile']")
	private WebElement pfimg;
	
	@FindBy(xpath="//h5[@class='p-3 text-white text-center 3xs:text-xs 2xs:text-sm 1xs:text-base xs:text-lg sm:text-xl h5 tracking-normal list-none']")
	private WebElement logoutBtn;
	
	
	public void clickOnProfile() {
		
		waitUtiliy.waitForVisibility(pfimg);
		ActionHelper.jsClick(pfimg);
		
	}
	
	public void clickOnlogoutBtn() {
		waitUtiliy.waitForVisibility(logoutBtn);
		ActionHelper.jsClick(logoutBtn);
	}
	
}
