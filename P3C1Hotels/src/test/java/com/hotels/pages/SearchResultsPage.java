package com.hotels.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage {

	@FindBy(xpath="//div[@class='price']/a/span/ins") private List<WebElement> uiSearchRsltsPg_DiscountedPrice;
	@FindBy(xpath="//div[@class='price']/a/b") private List<WebElement> uiSearchRsltsPg_NoDiscountedPrice;
	
	public void findLeastPriceBackUp()
	{
		String sPrice;
		String dPrice = null;
		List<String> dAllPrices = null;
		
		int iPrice;
				
		for(iPrice=0; iPrice<uiSearchRsltsPg_DiscountedPrice.size(); iPrice++)
		{
			sPrice = uiSearchRsltsPg_DiscountedPrice.get(iPrice).getText();
			System.out.println(sPrice);
			//dPrice = Double.parseDouble(sPrice);
			//dAllPrices.add(iPrice, dPrice);
		}
		
		for(int iPrice2=0; iPrice2<uiSearchRsltsPg_NoDiscountedPrice.size(); iPrice2++)
		{
			sPrice = uiSearchRsltsPg_NoDiscountedPrice.get(iPrice2).getText();
			System.out.println(sPrice);
			//dPrice = Double.parseDouble(sPrice);
			//dAllPrices.add(iPrice+1+iPrice2, dPrice);
		}
		
	/*	for(String dEachprice:dAllPrices)
		{
			System.out.println(dEachprice);
		}
		*/
	}
	
	public void findLeastPrice()
	{
		String sPrice;
		double dPrice;
		List<Double> dAllPrices = null;
		
		int iPrice;
				
		for(iPrice=0; iPrice<uiSearchRsltsPg_DiscountedPrice.size(); iPrice++)
		{
			sPrice = uiSearchRsltsPg_DiscountedPrice.get(iPrice).getText();
			sPrice = sPrice.replaceAll(" CAD", "");
			sPrice = sPrice.replaceAll("/$", "").trim();
			dPrice = Double.parseDouble(sPrice);	//"110" -> 110
			dAllPrices.add(iPrice, dPrice);
		}
		
		for(int iPrice2=0; iPrice2<uiSearchRsltsPg_NoDiscountedPrice.size(); iPrice2++)
		{
			sPrice = uiSearchRsltsPg_NoDiscountedPrice.get(iPrice2).getText();
			sPrice = sPrice.replaceAll(" CAD", "");
			sPrice = sPrice.replaceAll("$/", "").trim();
			dPrice = Double.parseDouble(sPrice);
			dAllPrices.add(iPrice+1+iPrice2, dPrice);
		}
		
		for(double dEachprice:dAllPrices)
		{
			System.out.println(dEachprice);
		}
		
	}
}
