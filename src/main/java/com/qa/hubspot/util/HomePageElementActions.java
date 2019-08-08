package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class HomePageElementActions extends BasePage{

	public HomePageElementActions(WebDriver driver){
		this.driver=driver;	
	}
	
	/**
	 * This method is used to create WebElement on the basis of given By locator
	 * @param locator
	 * @return WebElement
	 */
    public WebElement getElement(By locator ){
    	WebElement element=null;
    	try{
    		 element=driver.findElement(locator);
    	}catch(Exception e){
    		System.out.println("some exception occured while creating web element "+ locator);
    	}    	
    	return element;
    }
    
    /**
     * this method is used to wait for element to be present
     * @param locator
     */
    public void waitForElementPresent(By locator){
    	WebDriverWait wait=new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    public void waitForTitlePresent(String title){
    	WebDriverWait wait=new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.titleContains(title));
    }
    /**
     * This method is used to check element is displayed or not 
    * @param locator
    * @return
    */
   public boolean elementIsDisplayed(By locator){
   	waitForElementPresent(locator);
   	return getElement(locator).isDisplayed();
   }
  
   public String getPageHeader(By locator){
   	String header=null;
   	try{
   		  header=getElement(locator).getText();
   	}catch(Exception e){
   		System.out.println("some exception occured while getting header text " + header);
   	}
   	return header;
   }
   public String getAccountName(By locator){
	   	String acc_Name=null;
	   	try{
	   		  acc_Name=getElement(locator).getText();
	   	}catch(Exception e){
	   		System.out.println("some exception occured while getting account name " + acc_Name);
	   	}
	   	return acc_Name;
	   }
   
   public String getPageTitle(){
   	String title=null;
   	try{
   		  title=driver.getTitle();
   	}catch(Exception e){
   		System.out.println("some exception occured while getting title " + title);
   	}
   	return title;
   }
}
