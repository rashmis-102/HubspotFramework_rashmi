package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.HomePageNPF;
import com.qa.hubspot.pages.LoginPageNPF;

public class HomePageTestNPF {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPageNPF loginPagenpf;
	HomePageNPF homePagenpf;
	
	@BeforeMethod
	public void setup(){
		basePage=new BasePage();
		prop= basePage.initialize_Properties();
		driver=basePage.initialize_driver(prop);
		loginPagenpf=new LoginPageNPF(driver);
		homePagenpf=loginPagenpf.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title=homePagenpf.getHomePageTitle();
		System.out.println("home page title is :"+ title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyHomePageHeaderTest(){
		
		Assert.assertTrue(homePagenpf.verifyHomePageHeader());
		Assert.assertEquals(homePagenpf.getHomePageHeaderText(), Constants.HOME_PAGE_HEADER);
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
