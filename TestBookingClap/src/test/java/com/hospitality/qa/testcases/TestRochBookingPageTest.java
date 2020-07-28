package com.hospitality.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hospitality.qa.base.TestBase;
import com.hospitality.qa.pages.TestRochBookingPage;
import com.hospitality.qa.util.TestUtil;

public class TestRochBookingPageTest extends TestBase {
	 TestUtil testutil;
	 TestRochBookingPage rochpage;
	 
	 String sheetName="GuestDetails";
	
	public TestRochBookingPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		 rochpage = new TestRochBookingPage();
		 testutil =new TestUtil();
	}
	
	
	/*
	 * @Test public void PageTitle() { String title= rochpage.validatePageTitle();
	 * Assert.assertEquals(title,
	 * "Bookingclap.com: Find the Best Hotel Deals for Your Stay"); }
	 * 
	 * 
	 * @Test public void hospitalityImageTest() { boolean flag =
	 * rochpage.validateHospitalityImage(); Assert.assertTrue(flag); }
	 */
	
	@DataProvider
	public Object[][] getRochGData() throws EncryptedDocumentException, InvalidFormatException {
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
	}
	
	@Test(priority=1, dataProvider = "getRochGData")
	public void SearchHotel(String firstname,String lastname,String email,String mobile,
			String Organization ,String address,String City,String Country,String postcode,String specialrequest,
			String visa, String details,String month, String Year, String holder, String cvv)
	{
		
		rochpage.HotelName(firstname, lastname, email, mobile, Organization, address, City, Country, postcode,
				specialrequest, visa, details, month, Year, holder, cvv);
		
	}
	
	
	
	
	/*
	 * @AfterMethod public void tearDown() { driver.quit(); }
	 */
	
	
	

}
