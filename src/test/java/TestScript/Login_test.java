package TestScript;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Baselibrary.basePage;
import PageHelper.HomePage;
import PageHelper.LoginPage;
import utilities.PropertyUtility;




public class Login_test extends basePage{

	HomePage Home;
	LoginPage Login;
	
	@Test
	public void Test1() {
		
		Home = new HomePage();
		Login = new LoginPage();
		
		 
		
		Home.ClickonPlaybtn();
	    Login.SelectTheCountry("india");
		Login.EnterPhoneNo("7078152099");
		Login.EnterNickName("Prash");
		Login.ClickonNextBtn();
		
		
		
		}
}
