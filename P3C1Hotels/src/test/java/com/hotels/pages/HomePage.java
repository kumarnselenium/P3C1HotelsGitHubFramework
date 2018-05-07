package com.hotels.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	//Home Page - UI Objects/Controls
	/*public String uiHomePg_SignInAndAccount_id = "hdr-account";
	public String uiHomePg_Packages_id = "hdr-packages";
	public String uiHomePg_SignIn_id = "hdr-signin";
	public String uiHomePg_Destination_id = "qf-0q-destination";
	public String uiHomePg_CheckInDt_id = "qf-0q-localised-check-in";
	public String uiHomePg_CheckOutDt_id = "qf-0q-localised-check-out";
	public String uiHomePg_Rooms_id = "qf-0q-compact-occupancy";
	public String uihomePg_SearchBtn_xp = "//button[contains(.,'Search')]"; */
	
	@FindBy(id="hdr-account") private WebElement uiHomePg_SignInAndAccount_id;
	@FindBy(id="hdr-packages") private WebElement uiHomePg_Packages_id;
	@FindBy(id="hdr-signin") private WebElement uiHomePg_SignIn_id;
	@FindBy(id="qf-0q-destination") private WebElement uiHomePg_Destination_id;
	@FindBy(id="qf-0q-localised-check-in") private WebElement uiHomePg_CheckInDt_id;
	@FindBy(id="qf-0q-localised-check-out") private WebElement uiHomePg_CheckOutDt_id;
	@FindBy(id="qf-0q-compact-occupancy") private WebElement uiHomePg_Rooms_id;
	@FindBy(xpath="//button[contains(.,'Search')]") private WebElement uihomePg_SearchBtn_xp;
	@FindBy(linkText="Continue to Hotels.com") private WebElement uihomePg_Continue;
	@FindBy(linkText="Continue to Hotels.com") private List<WebElement> uihomePg_ContinueLinks;
	@FindBy(linkText="Menu") private WebElement uihomePg_Menu;
	@FindBy(linkText="Menu") private List<WebElement> uihomePg_MenuS;
	@FindBy(className="widget-overlay-close") private WebElement uihomePg_DtCloseBtn;
	
	
	public void offerPopUpClose()
	{
		if(uihomePg_ContinueLinks.size()>0)	//verify popup presented
		{
			uihomePg_Continue.click();	//click on close
		}
	}
	
	public void navigateToSignInPage()
	{
		uiHomePg_SignInAndAccount_id.click();
		uiHomePg_SignIn_id.click();
	}
	
	public void searchHotel() throws InterruptedException
	{
		//Entering Destination
		uiHomePg_Destination_id.clear();
		uiHomePg_Destination_id.sendKeys("Niagara");
		
		//Entering Check in Date
		uiHomePg_CheckInDt_id.clear();
		uiHomePg_CheckInDt_id.sendKeys("05/09/2018");
		
		//Entering Check out Date
		uiHomePg_CheckOutDt_id.clear();
		uiHomePg_CheckOutDt_id.sendKeys("05/13/2018");
		Thread.sleep(2000);
		
		//uihomePg_DtCloseBtn.click();
		Thread.sleep(2000);
		
		uiHomePg_Rooms_id.click();
		
		uihomePg_SearchBtn_xp.click();
	}

	public void clickPackangesTab() throws InterruptedException
	{
		if(uihomePg_MenuS.size()>0)
		{
			uihomePg_Menu.click();
			Thread.sleep(2000);
		}
		uiHomePg_Packages_id.click();
	}
}











