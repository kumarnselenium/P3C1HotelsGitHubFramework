package com.hotels.Scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.hotels.pages.HomePage;
import com.hotels.pages.SignInPage;

public class TS1_NegativeLogin {

	WebDriver oBrowser;
	
	@Before
	public void openApp()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/amulyavallamkonda/Documents/Selenium/chromedriver");
		oBrowser = new ChromeDriver();
		
		oBrowser.get("https://ca.hotels.com/");
		
		oBrowser.manage().window().maximize();
	}
	
	@Test
	public void negativeLogin() throws InterruptedException
	{
		//HomePage oHomePg = new HomePage();
		//SignInPage oSigninPg = new SignInPage();
		
		HomePage oHomePg = PageFactory.initElements(oBrowser, HomePage.class);
		SignInPage oSigninPg = PageFactory.initElements(oBrowser, SignInPage.class);
		
		oHomePg.offerPopUpClose();
		oHomePg.navigateToSignInPage();
		Thread.sleep(2000);
		oSigninPg.signIn();
	}
	
	@After
	public void closeApp()
	{
		//oBrowser.quit();
	}
	
}
