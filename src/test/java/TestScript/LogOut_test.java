package TestScript;

import org.testng.annotations.Test;

import Baselibrary.basePage;
import PageHelper.HomePage;
import PageHelper.LogOutPage;
import PageHelper.LoginPage;

public class LogOut_test extends basePage{
	
	HomePage Home;
	LoginPage Login;
	LogOutPage Logout;
	
	@Test
	public void logout() {
		
		Home = new HomePage();
		Login = new LoginPage();
		Logout = new LogOutPage();
		
		Home.ClickonPlaybtn();
		Login.SelectTheCountry("india");
		Login.EnterPhoneNo("7078152099");
		Login.EnterNickName("Prash");
		Login.ClickonNextBtn();
		Logout.clickOnProfile();
		Logout.clickOnlogoutBtn();
	}
	
	
	
	

}
