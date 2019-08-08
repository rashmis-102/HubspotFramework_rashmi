package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.util.HomePageElementActions;

public class HomePageNPF extends BasePage {
	
	HomePageElementActions homePageElementActions;
	
	//NPF
	//1.Define locators:Page Objects but without Page Factory
	By homePageHeader=By.xpath("//h1[@class='private-page__title']");
	By accountName=By.xpath("//span[@class='account-name ']");
	
	public HomePageNPF(WebDriver driver){
		this.driver=driver;
		homePageElementActions= new HomePageElementActions(driver);
	}

	//page actions:
	public String getHomePageTitle(){
		homePageElementActions.waitForTitlePresent(Constants.HOME_PAGE_TITLE);
		return homePageElementActions.getPageTitle();
	}
	
	public String getHomePageHeaderText(){
		return homePageElementActions.getPageHeader(homePageHeader);
	}
	public boolean verifyHomePageHeader(){
		return homePageElementActions.elementIsDisplayed(homePageHeader);
	}
	public String getAccountNameValue(){
		return homePageElementActions.getAccountName(accountName);
	}
	
	public boolean verifyAccountName(){
		return homePageElementActions.elementIsDisplayed(accountName);
	}
	

}
