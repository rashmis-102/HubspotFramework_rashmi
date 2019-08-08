package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.util.ElementActions;
import com.qa.hubspot.util.TimeUtil;

public class LoginPageNPF extends BasePage {
	
	ElementActions elementActions ;
	//NPF
	//1.define locators : Page Objects but without Page Factory
	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	public LoginPageNPF(WebDriver driver){
		this.driver=driver;
		elementActions = new ElementActions(driver);
	}
	
	//Page Actions:
	public String getLoginPageTitle(){
		elementActions.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE);
		return elementActions.getPageTitle();
	}	
	
	public boolean verifySignUpLinkDisplayed(){
		//return elementActions.getElement(signUpLink).isDisplayed();
		return elementActions.elementIsDisplayed(signUpLink);
	}
	
	public HomePageNPF doLogin(String username, String pwd){
		TimeUtil.mediumWait();
		System.out.println("Credentials:" + username + "/"+ pwd);
		elementActions.elementSendKeys(emailId, username);
		elementActions.elementSendKeys(password, pwd);
		elementActions.elementClick(loginButton);
		return new HomePageNPF(driver);
	}
}
