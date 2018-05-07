package com.hotels.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

	@FindBy(id="sign-in-email") private WebElement uiSignInPg_EmailAdd;
	@FindBy(id="sign-in-password") private WebElement uiSignInPg_Password;
	@FindBy(xpath="//button[contains(.,'Sign in')]") private WebElement uiSignInPg_SignInBtn;
	@FindBy(xpath="//div[contains(.,'recognize the email and password combination')]") private WebElement uiSignInPg_loginErrMsg;
	@FindBy(className="sica-form sign-in") public static WebElement uiSignInPg_SignInFormFrame;
	
	
	public void signIn()
	{
		
		//Enter Email Address
		uiSignInPg_EmailAdd.clear();
		uiSignInPg_EmailAdd.sendKeys("akdhalkhflaf");
		
		//Enter Password
		uiSignInPg_Password.clear();
		uiSignInPg_Password.sendKeys("akfkalflaf");
		
		//Click on Sign in
		uiSignInPg_SignInBtn.click();
		
		try {
			Assert.assertTrue("Pass, Expected Error message is displayed", uiSignInPg_loginErrMsg.isDisplayed());
			System.out.println("Fail, Expected Error message is not displayed");
		}catch(Exception e)
		{
			System.out.println("Fail, Expected Error message is not displayed");
		}
	}
	
	public void forgotPassword()
	{
		
	}
}
