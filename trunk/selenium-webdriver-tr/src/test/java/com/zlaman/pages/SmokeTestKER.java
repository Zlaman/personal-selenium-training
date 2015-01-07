package com.zlaman.pages;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class SmokeTestKER extends TestBase{
    @Test(description = "Log in with new user and verify it is logged in and off")
    public void kerLoginTest(){
        driver.findElement(By.cssSelector("a.account_navigation_link.login_link")).click();
        driver.findElement(By.cssSelector("input.f_email[id *=dwfrm_login_username]")).clear();
        driver.findElement(By.cssSelector("input.f_email[id *=dwfrm_login_username]")).sendKeys("billyjackson2@gmail.com");
        driver.findElement(By.id("dwfrm_login_password")).clear();
        driver.findElement(By.id("dwfrm_login_password")).sendKeys("zxczxczxc");
        driver.findElement(By.id("dwfrm_login_rememberme")).click();
        driver.findElement(By.name("dwfrm_login_login")).click();
        assertTrue(verifyTextPresentIn(By.cssSelector("li.account_navigation_list_item.account_navigation_welcome"), "BILLY!"), "User is not logged in");
        driver.findElement(By.cssSelector("a.logout-link")).click();
        assertFalse(verifyTextPresentIn(By.cssSelector("li.account_navigation_list_item.account_navigation_welcome"), "BILLY!"), "User is logged in");
    }
        
    @Test(description = "Add product to cart and remove")
    public void kerAddToCartTest(){
        driver.findElement(By.id("q")).sendKeys("BCR0000");
        driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[@data-itemid='BCR0000']/a")).click();
        new Actions(driver).moveToElement(driver.findElement(By.className("logo_image")));
        Select quantityDropdown = new Select(driver.findElement(By.name("quantity")));
        quantityDropdown.selectByVisibleText("3");
        driver.findElement(By.cssSelector("button.addtocartbutton")).click();
        driver.findElement(By.cssSelector("span.mini_cart_label")).click();
        assertTrue(verifyTextPresentIn(By.cssSelector("td > span.price_sale.single_product_price"), "$117.00"), "Price is wrong");
        driver.findElement(By.name("dwfrm_cart_shipments_i0_items_i0_deleteProduct")).click();
        assertFalse(verifyTextPresentIn(By.cssSelector("td > span.price_sale.single_product_price"), "$117.00"), "Product is still in cart");
    }
   
}
