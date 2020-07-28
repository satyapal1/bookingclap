package com.hospitality.qa.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hospitality.qa.base.TestBase;

public class TestRochBookingPage extends TestBase{
	
	@FindBy(xpath="//input[@name='Location']")
	WebElement Location;
	
	@FindBy(xpath="//span[contains(text(),' Rochester by Blue Orchid, London, United Kingdom')]")
	WebElement Roch;
	
	@FindBy(xpath="//input[@name='CheckIn']")
	WebElement CheckIn;
	
	@FindBy(xpath="//a[contains(text(),'30')]")
	WebElement Date1;
	
	//@FindBy(xpath="//a[@class='ui-state-default ui-state-hover']")
	//WebElement Date2;
	
	
	@FindBy(xpath="//input[@name='CheckOut']")
	WebElement CheckOut;
	
	@FindBy(id = "btn-search-hotel")
	WebElement Search;
	
	@FindBy(id = "booknowbtn_10497")
	WebElement BookNow;
	
	@FindBy(xpath = "//button[contains(text(),'Book Now')]")
	WebElement Reserve;
	
	@FindBy(xpath = "//a[contains(text(),'Book Now')]")
	WebElement BookNow3;
	
	@FindBy(id="btncontinue")
	WebElement Continue;
	
	//Guest detail page
	
	  @FindBy(xpath = "(//input[@name='FirstName'])[1]")
	   WebElement Fname;
	
	  @FindBy(xpath = "//input[@title='Last Name' and @name='LastName']")
	  WebElement Lname;
	
	  @FindBy(xpath="(//input[@name='Email' and @type ='email'])[1]") 
	  WebElement mail;	  
	  
	  @FindBy(xpath="//input[@name='Mobile' and @title='Mobile Number']") 
	  WebElement mob;
	  
	 // @FindBy(xpath="//input[@name='PurposeOfTravel']") 
	 // WebElement pot;
	  
	  @FindBy(xpath="//input[@title='Organizationname']")
	  WebElement OrgName;
	
	  @FindBy(xpath="//textarea[@name='Address']") 
	  WebElement add;
	  
	  @FindBy(xpath="//input[@name='CityName']") 
	  WebElement city;
	  
	  @FindBy(xpath="//input[@title='Post Code' and @name='PostCode']") 
	  WebElement pcode;
	  
	  @FindBy(xpath="//textarea[@name='SpecialRequest']") 
	  WebElement splrequest;
	
	  @FindBy(xpath="(//input[@type='checkbox'])[1]") 
	  WebElement Term$Conditions;
	  
	  @FindBy(xpath="//span[contains(text(),'Continue To Payment')]") 
	  WebElement ContinueToPayment;
	  
		
		  @FindBy(xpath="//input[@name='CardNumber']") 
		  WebElement CardNumber;
		  
		  @FindBy(xpath="//input[@name='CardHolderName']") 
		  WebElement Cardholder;
		  
		  @FindBy(xpath="//input[@name='CVCCode']") 
		  WebElement CVC;
		  
		  @FindBy(xpath="//*[@id=\"enhance-stay\"]/div[2]/div[1]/div[1]/form/div[6]/a")
		  WebElement COMPLETEBOOKING;
		  
		 
		  @FindBy(xpath="/html/body/div[2]/div/nav/div/div[1]/a/img") WebElement
		  HospitalityLogo;
		 
	
	
	

	public TestRochBookingPage() throws IOException {
		PageFactory.initElements(driver, this);
		}
	public String validatePageTitle() {
		return driver.getTitle();
	}
	public boolean validateHospitalityImage() {
		return HospitalityLogo.isDisplayed();
	}
	public void HotelName(String firstname,String lastname,String email,String mobile,
			String Organization,String address,String City,String Country,String postcode,String specialrequest,
			String visa,String details, String month, String Year, String holder, String cvv)
 
	{
		Location.sendKeys("The");
		Roch.click();
		CheckIn.click();
		Date1.click();
		Search.click();
		BookNow.click();
		
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String ParentID = it.next();
		String ChildID = it.next();
		System.out.println("ParentID=" + ParentID);
		System.out.println("ChildID=" + ChildID);
		driver.switchTo().window(ChildID);
		
		Select sct =new Select(driver.findElement(By.xpath("(//select[@class='select-room-option ddlavl_addon_cls ng-pristine ng-valid'])[1]")));
		sct.selectByValue("1");
		
		Reserve.click();
		BookNow3.click();
		Continue.click();
		
		Select titl = new Select(driver.findElement(By.xpath("//select[@title='Title']")));
		titl.selectByVisibleText("Mr");
		Fname.sendKeys(firstname);
		Lname.sendKeys(lastname);
		mail.sendKeys(email);
		mob.sendKeys(mobile);
		//pot.sendKeys(purposeoftravel);
		OrgName.sendKeys(Organization );
		add.sendKeys(address);
		city.sendKeys(City);
		
		Select cntry = new Select(driver.findElement(By.xpath("//select[@name='ddlCountry']")));
		cntry.selectByVisibleText(Country);
		
		pcode.sendKeys(postcode);
		splrequest.sendKeys(specialrequest);
		Term$Conditions.click();
		ContinueToPayment.click();
		
		
		 Select card = new Select(driver.findElement(By.xpath("//select[@name='CreditCardTypeId']")));
		 card.selectByVisibleText(visa); 
		  
		 CardNumber.sendKeys(details);
		  
		 Select mnth = new Select(driver.findElement(By.id("ExpiryMonth")));
		 mnth.selectByVisibleText(month);
		  
		 Select year = new Select(driver.findElement(By.id("ExpiryYear")));
		 year.selectByVisibleText(Year);
		  
		 Cardholder.sendKeys(holder); 
		 
		 CVC.sendKeys(cvv); 
		 
		 COMPLETEBOOKING.click();
		 
	}
	
	
		
	}
 
	
