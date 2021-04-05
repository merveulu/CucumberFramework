package com.saucelabs.pages;

import com.saucelabs.utils.HelperMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.saucelabs.base.BasePage.driver;

import java.util.List;

public class CheckoutStepThree {

    @FindBy(xpath="//*[@class='inventory_item_name']")
    public static List<WebElement> items;

    public CheckoutStepThree(){
        PageFactory.initElements(driver,this);
    }

    public static Boolean verifyItem(String itemName){
        for (WebElement item: items) {
            if (item.getText().equals(itemName)){
               return true;
            }
        }
        return false;
    }
}
