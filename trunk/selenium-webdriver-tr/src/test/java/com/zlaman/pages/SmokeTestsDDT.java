package com.zlaman.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zlaman.model.User;

public class SmokeTestsDDT extends TestBase {

    @DataProvider(name = "users")
    public Object[][] createData(ITestContext context) {
        User user1 = new User();
        user1.initUser(context.getCurrentXmlTest().getParameter("user1.email"),
                context.getCurrentXmlTest().getParameter("user1.password"),
                context.getCurrentXmlTest().getParameter("user1.userName"));
        User user2 = new User();
        user2.initUser(context.getCurrentXmlTest().getParameter("user2.email"),
                context.getCurrentXmlTest().getParameter("user2.password"),
                context.getCurrentXmlTest().getParameter("user2.userName"));
        return new Object[][] { { user1 }, { user2 }, };
    }

    @Test(description = "Log in with new user and verify it is logged in and off", dataProvider = "users")
    public void kerLoginTest(User user) {

        System.out.println("Using " + user.getUserName() + " DDT (8");

        WebstoreHeader webstoreHeader = new WebstoreHeader(driver);
        webstoreHeader.openLoginPage().loginWithUser(user, true);
        assertTrue(webstoreHeader.verifyUserIsLoggedIn(user),
                "User is not logged in");
        webstoreHeader.logOff();
        assertFalse(webstoreHeader.verifyUserIsLoggedIn(user),
                "User is still logged in");
    }

}

/*
 * @Test(description = "Add product to cart and remove") public void
 * kerAddToCartTest(){ driver.findElement(By.id("q")).sendKeys("BCR0000");
 * driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
 * driver.findElement(By.xpath("//div[@data-itemid='BCR0000']/a")).click(); new
 * Actions
 * (driver).moveToElement(driver.findElement(By.className("logo_image")));
 * Select quantityDropdown = new
 * Select(driver.findElement(By.name("quantity")));
 * quantityDropdown.selectByVisibleText("3");
 * driver.findElement(By.cssSelector("button.addtocartbutton")).click();
 * driver.findElement(By.cssSelector("span.mini_cart_label")).click();
 * assertTrue
 * (verifyTextPresentIn(By.cssSelector("td > span.price_sale.single_product_price"
 * ), "$117.00"), "Price is wrong");
 * driver.findElement(By.name("dwfrm_cart_shipments_i0_items_i0_deleteProduct"
 * )).click(); assertFalse(verifyTextPresentIn(By.cssSelector(
 * "td > span.price_sale.single_product_price"), "$117.00"),
 * "Product is still in cart"); }
 */