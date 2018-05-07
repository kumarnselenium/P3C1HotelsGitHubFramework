package com.hotels.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage2 {

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
	
	public void findLeastPriceWithOutDictionary()
	{
		String sPrice;
		double dPrice;
		List<Double> dAllPrices = new ArrayList<Double>();
		
		int iPrice;
				
		for(iPrice=0; iPrice<uiSearchRsltsPg_DiscountedPrice.size(); iPrice++)
		{
			sPrice = uiSearchRsltsPg_DiscountedPrice.get(iPrice).getText();
			sPrice = sPrice.replaceAll(" CAD", "");
			sPrice = sPrice.replaceAll("\\$", "").trim();
			dPrice = Double.parseDouble(sPrice);	//"110" -> 110
			System.out.println(dPrice);
			dAllPrices.add(iPrice, dPrice);
		}
		
		for(int iPrice2=0; iPrice2<uiSearchRsltsPg_NoDiscountedPrice.size(); iPrice2++)
		{
			sPrice = uiSearchRsltsPg_NoDiscountedPrice.get(iPrice2).getText();
			sPrice = sPrice.replaceAll(" CAD", "");
			sPrice = sPrice.replaceAll("\\$", "").trim();
			dPrice = Double.parseDouble(sPrice);
			System.out.println(dPrice);
			dAllPrices.add(iPrice+iPrice2, dPrice);
		}

		System.out.println("Before Sorting");
		for(double dEachprice:dAllPrices)
		{
			System.out.println(dEachprice);
		}
		
		//Sorting
		Collections.sort(dAllPrices);

		System.out.println("After Sorting");
		for(double dEachprice:dAllPrices)
		{
			System.out.println(dEachprice);
		}
		
		//Click on Choose Button for the least price
		
	}
	
	public void findLeastPrice()
	{
		String sPrice;
		double dPrice;
		Map<WebElement, Double> uiAllHotels = new HashMap<WebElement, Double>();
		List<Double> dAllPrices = new ArrayList<Double>();
		WebElement uiChooseBtn;
		int iPrice;
				
		for(iPrice=0; iPrice<uiSearchRsltsPg_DiscountedPrice.size(); iPrice++)
		{
			sPrice = uiSearchRsltsPg_DiscountedPrice.get(iPrice).getText();
			sPrice = sPrice.replaceAll(" CAD", "");
			sPrice = sPrice.replaceAll("\\$", "").trim();
			dPrice = Double.parseDouble(sPrice);	//"110" -> 110
			System.out.println(dPrice);
			dAllPrices.add(iPrice, dPrice);
			
			uiChooseBtn = uiSearchRsltsPg_DiscountedPrice.get(iPrice).findElement(By.xpath("//ancestor::div[@class='price']//following-sibling::div[2]/a"));
			//uiChooseBtn.click();
			uiAllHotels.put(uiChooseBtn, dPrice);
		}
		
		for(int iPrice2=0; iPrice2<uiSearchRsltsPg_NoDiscountedPrice.size(); iPrice2++)
		{
			sPrice = uiSearchRsltsPg_NoDiscountedPrice.get(iPrice2).getText();
			sPrice = sPrice.replaceAll(" CAD", "");
			sPrice = sPrice.replaceAll("\\$", "").trim();
			dPrice = Double.parseDouble(sPrice);
			System.out.println(dPrice);
			dAllPrices.add(iPrice+iPrice2, dPrice);

			uiChooseBtn = uiSearchRsltsPg_NoDiscountedPrice.get(iPrice2).findElement(By.xpath("//ancestor::div[@class='price']//following-sibling::div[2]/a"));
			uiAllHotels.put(uiChooseBtn, dPrice);
		}

		System.out.println("Before Sorting");
		for(double dEachprice:dAllPrices)
		{
			System.out.println(dEachprice);
		}
		
		Collections.sort(dAllPrices);
		System.out.println("After Sorting");
		for(double dEachprice:dAllPrices)
		{
			System.out.println(dEachprice);
		}
		System.out.println("Total Choose buttons " + uiAllHotels.size());
		for(WebElement uiEachVBtn: uiAllHotels.keySet())
		{
			if(uiAllHotels.get(uiEachVBtn).equals(dAllPrices.get(0)))
					uiEachVBtn.click();
			
		}
	}
}









