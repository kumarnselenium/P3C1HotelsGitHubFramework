package com.hotels.Scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.hotels.pages.HomePage;
import com.hotels.pages.SearchPackages;

public class TS2_Packages {
	WebDriver oBrowser;
	
	@Before
	public void openApp()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/amulyavallamkonda/Documents/Selenium/chromedriver");
		oBrowser = new ChromeDriver();
		
		oBrowser.get("https://ca.hotels.com/");
		
		//oBrowser.manage().window().maximize();
	}
	
	@Test
	public void searchPackages() throws InterruptedException
	{
		//HomePage oHomePg = new HomePage();
		//SignInPage oSigninPg = new SignInPage();
		
		HomePage oHomePg = PageFactory.initElements(oBrowser, HomePage.class);
		SearchPackages oSearchPackagePg = PageFactory.initElements(oBrowser, SearchPackages.class);
		
		oHomePg.offerPopUpClose();
		oHomePg.clickPackangesTab();
		oSearchPackagePg.searchReturnFlight_Packages();
	}
	
	@After
	public void closeApp()
	{
		//oBrowser.quit();
	}
	
}
