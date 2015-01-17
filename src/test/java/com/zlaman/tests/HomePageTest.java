package com.zlaman.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.zlaman.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage homepage;
	
	@Parameters({ "path" })
	@BeforeClass
	public void testInit(String path) {

		// Load the page in the browser
		driver.get(baseUrl + path);
		homepage = PageFactory.initElements(driver, LoginPage.class);
	}

	@Test
	public void testH1Existing() throws InterruptedException {
//		Assert.assertTrue(homepage.getH1() != null);
	}

	@Test
	public void test2() throws InterruptedException {
		Assert.assertTrue(true);
	}
}
