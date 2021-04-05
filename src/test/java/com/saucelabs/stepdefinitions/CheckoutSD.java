package com.saucelabs.stepdefinitions;

import com.saucelabs.base.ConfigReader;
import com.saucelabs.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckoutSD {

  @Given("user is actually successfully login")
    public void verifyUserLoggedIn() {
      LoginPage.enterUsername(ConfigReader.getProperty("username"));
      LoginPage.enterPassword(ConfigReader.getProperty("password"));
      LoginPage.clickLoginBtn();
      String expectedUrl = "https://www.saucedemo.com/inventory.html";
      Assert.assertEquals(expectedUrl,LoginPage.verifyURL());
  }

    @When("I click on item with name {string}")
    public void iClickOnItemWithName(String itemName) {
      HomePage.clickItem(itemName);

    }

    @And("I click on the ADD TO CART button")
    public void iClickOnTheADDTOCARTButton() {
      ItemPage.clickAddtoCart();
    }

    @And("I click on the SHOPPING CART button")
    public void iClickOnTheSHOPPINGCARTButton() {
        ItemPage.clickToShoppingCart();
    }

    @And("I click on theCHECKOUT button")
    public void iClickOnTheCHECKOUTButton() {
      CheckoutStepOne.clickOnCheckOut();
    }

    @And("I enter the order information {string}, {string} and {string}")
    public void iEnterTheOrderInformationAnd(String firstName, String lastName, String zipCode) {
      CheckoutStepTwo.sendOrderInformation(firstName, lastName, zipCode);
    }

    @And("I click on continue button")
    public void iClickOnContinueButton() {
    CheckoutStepTwo.clickContinue();
    }

    @Then("Item name matches that of {string}")
    public void itemNameMatchesThatOf(String item) {
      Assert.assertTrue(CheckoutStepThree.verifyItem(item));
    }
}
