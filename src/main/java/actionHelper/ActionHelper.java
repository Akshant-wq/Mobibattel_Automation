package actionHelper;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Baselibrary.basePage;
import utilities.waitUtiliy;

public class ActionHelper extends basePage{
	
	public static void click(WebElement ele) {
		
		waitUtiliy.waitForVisibility(ele);
		ele.click();
	}
	
	public static void jsClick(WebElement ele) {
		waitUtiliy.waitForVisibility(ele);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}
	
	public static void sendkeys(WebElement ele, String text) {
		waitUtiliy.waitForVisibility(ele);
		ele.sendKeys(text);
	}
	
	public static void clear(WebElement ele) {
		waitUtiliy.waitForVisibility(ele);
		ele.clear();
	}
	
	public static void doubleclick(WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}
	
	public static void rightclick(WebElement ele) {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}
	public static void getwindownchange(String url) {
		Set<String> set = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(set);
		driver.switchTo().window(url);
		//driver.switchTo().window(tabs.get(tabno));
		
	}
	
	
	
	public static void selectByVisibleText(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByVisibleText(value);
	}
	
	public static String getSelectedOption(WebElement ele) {
		Select select = new Select(ele);
		return select.getFirstSelectedOption().getText();
	}

	public static void selectByValue(WebElement ele, String value) {

		Select select = new Select(ele);
		select.selectByValue(value);
	}
	
	public static void mousehover(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();

	}

	public static void mousehover_click(WebElement ele, String target) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		driver.findElement(By.linkText(target)).click();}
}
