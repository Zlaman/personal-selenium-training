package com.zlaman.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.zlaman.model.User;
import com.zlaman.pages.WebstoreHeader;

public class CopyOfSmokeTests extends TestBase {

    @Test(description = "Log in with new user and verify it is logged in and off")
    public void kerLoginTest() {
        User user1 = new User();
        user1.initUser("billyjackson2@gmail.com", "zxczxczxc", "BILLY");

        WebstoreHeader webstoreHeader = new WebstoreHeader(driver);

        webstoreHeader.openLoginPage().loginWithUser(user1, true);
        assertTrue(webstoreHeader.verifyUserIsLoggedIn(user1),
                "User is not logged in");
        webstoreHeader.logOff();
        assertFalse(webstoreHeader.verifyUserIsLoggedIn(user1),
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