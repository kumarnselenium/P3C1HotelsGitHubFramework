package com.hotels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPackages {

	@FindBy(xpath="//span[contains(.,'Flights')]") private WebElement uiPackages_FlightsTab;
	@FindBy(xpath="//span[contains(.,'Flight + Hotel')]") private WebElement uiPackages_FlightHotelTab;
	@FindBy(xpath="//span[contains(.,'Things to Do')]") private WebElement uiPackages_ThingstoDoTab;
	@FindBy(id="flight-type-roundtrip-label") private WebElement uiFlightsTab_Return;
	@FindBy(id="flight-type-one-way-label") private WebElement uiFlightsTab_Oneway;
	@FindBy(id="flight-type-multi-dest-label") private WebElement uiFlightsTab_MultiCity;
	@FindBy(id="flight-origin") private WebElement uiFlightsTab_FlyFrom;
	@FindBy(id="flight-destination") private WebElement uiFlightsTab_FlyTo;
	@FindBy(id="flight-departing") private WebElement uiFlightsTab_DepartDate;
	@FindBy(id="flight-returning") private WebElement uiFlightsTab_ReturnDate;
	@FindBy(id="flight-adults") private WebElement uiFlightsTab_NOfAdults;
	@FindBy(id="flight-children") private WebElement uiFlightsTab_NOfKids;
	@FindBy(id="search-button") private WebElement uiFlightsTab_SearchBtn;
	
	public void searchReturnFlight_Packages()
	{
		//Click Flights tab
		uiPackages_FlightsTab.click();
		
		//Click on Return selection
		uiFlightsTab_Return.click();
		
		//Enter Fly from
		uiFlightsTab_FlyFrom.clear();
		uiFlightsTab_FlyFrom.sendKeys("Los vegas");
		
		//Enter Fly to
		uiFlightsTab_FlyTo.clear();
		uiFlightsTab_FlyTo.sendKeys("New york");
		
		//Depart date
		uiFlightsTab_DepartDate.clear();
		uiFlightsTab_DepartDate.sendKeys("25/08/2018");
		
		//Return Date
		uiFlightsTab_ReturnDate.clear();
		uiFlightsTab_ReturnDate.sendKeys("29/08/2018");
		
		//Select Adults
		Select uiAultsDropDown = new Select(uiFlightsTab_NOfAdults);
		uiAultsDropDown.selectByVisibleText("3");
		
		//Search
		uiFlightsTab_SearchBtn.click();
	}
	
	public void searchOnewayFlight_Packages()
	{
		
	}
	
	public void searchMultiCityFlight_Packages()
	{
		
	}

	public void searchFlightAndHotel_Packages()
	{
		
	}
	
	public void searchThingsToDo_Packages()
	{
		
	}
}






