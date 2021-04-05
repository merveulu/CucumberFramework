package com.saucelabs.pages;

import com.saucelabs.utils.HelperMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.saucelabs.base.BasePage.driver;

public class ItemPage {

    @FindBy(xpath="//*[@class='btn_primary btn_inventory']")
    public static WebElement addBtn;

    @FindBy(xpath="//div[@id='shopping_cart_container']/a")
    public static WebElement shoppingCart;

    public ItemPage(){
        PageFactory.initElements(driver,this);
    }

    public static void clickAddtoCart(){
        HelperMethods.doClick(addBtn);
    }

    public static void clickToShoppingCart(){
        HelperMethods.waitForVisibility(shoppingCart);
        HelperMethods.doClick(shoppingCart);
    }
}
