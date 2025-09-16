package PageHelper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baselibrary.basePage;
import actionHelper.ActionHelper;

public class HomePage extends basePage{

	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@type='button']")
	  private WebElement PlayBtn;
	
	public void ClickonPlaybtn() {
		ActionHelper.jsClick(PlayBtn);
	}
}
