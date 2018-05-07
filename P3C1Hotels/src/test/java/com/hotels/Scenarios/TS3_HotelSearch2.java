package com.hotels.Scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.hotels.pages.HomePage;
import com.hotels.pages.SearchResultsPage;
import com.hotels.pages.SearchResultsPage2;

public class TS3_HotelSearch2 {
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
	public void searchPackages() throws InterruptedException
	{
		HomePage oHomePg = PageFactory.initElements(oBrowser, HomePage.class);
		SearchResultsPage2 oSearchResultsPg = PageFactory.initElements(oBrowser, SearchResultsPage2.class);
		
		oHomePg.offerPopUpClose();
		oHomePg.searchHotel();
		oSearchResultsPg.findLeastPrice();
	}
	
	@After
	public void closeApp()
	{
		//oBrowser.quit();
	}
}
