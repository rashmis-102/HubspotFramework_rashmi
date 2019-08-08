package com.qa.hubspot.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.listeners.ExtentReportListener;
import com.qa.hubspot.listeners.pdfListener;
import com.qa.hubspot.listeners.TestAllureListener;
import com.qa.hubspot.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Epic("Epic - hub spot login page module")
@Feature("US-101: define the login feature for hub spot application")
//@Listeners(TestAllureListener.class)
//@Listeners(ExtentReportListener.class)
public class LoginPageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup(){
		basePage=new BasePage();
		prop= basePage.initialize_Properties();
		driver=basePage.initialize_driver(prop);
		loginPage=new LoginPage(driver);
		
	}
	
	@Test(priority=1)
	@Description("test case name:verify login page title - positive test case")
	@Severity(SeverityLevel.NORMAL)
		void verifyLoginPageTitleTest(){
		String title=loginPage.getLoginPageTitle();
		System.out.println("The login page title is:"+ title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	@Description("test cases name: verifySignUpLinkTest - positive test case")
	@Severity(SeverityLevel.CRITICAL)
	public void verifySignUpLinkTest(){
		Assert.assertTrue(loginPage.verifySignupLinkDisplayed());
	}
	
	
	@Test(priority=3, enabled=false)
	@Description("test cases name: loginTestWithCorrectCredentialsTest - positive test case")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTestWithCorrectCredentialsTest(){
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=4, enabled=false)
	@Description("test cases name: loginTestWithInCorrectCredentialsTest - negative test case")
	@Severity(SeverityLevel.NORMAL)
	public void loginTestWithInCorrectCredentialsTest(){
		loginPage.doLogin("abcd@ggg.com", "tttt");
		//Assert.assertEquals("abcd@ggg.com", prop.getProperty("username"));
		//Assert.assertEquals("tttt", prop.getProperty("password"));
		//System.out.println("Email Id and Password does not exist");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
