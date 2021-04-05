package com.saucelabs.stepdefinitions;

import com.saucelabs.base.ConfigReader;
import com.saucelabs.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSD {
   @Given("^I am on the login page$")
    public void verifyLoginPage(){
       String expectedTitle = "Swag Labs";
       Assert.assertEquals(expectedTitle, LoginPage.verifyTitle());
   }
   @When("I enter valid username")
   public void IEnterValidUsername(){
        LoginPage.enterUsername("standard_user");
   }

   @And("I enter valid password")
   public void IEnterValidPassword(){
        LoginPage.enterPassword("secret_sauce");
   }

   @And("I click on the login button")
   public void clickOnLogin(){
        LoginPage.clickLoginBtn();
   }


    @Then("I see the homepage")
    public void seeHomePage(){
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl,LoginPage.verifyURL());
    }

    @When("I enter invalid username")
    public void iEnterInvalidUsername() {
        LoginPage.enterUsername(ConfigReader.getProperty("incorrectusername"));
    }

    @And("I enter invalid password")
    public void iEnterInvalidPassword() {
       LoginPage.enterPassword(ConfigReader.getProperty("incorrectpassword"));
    }



    @Then("I see the error message")
    public void iSeeTheErrorMessage() {
        Assert.assertTrue(LoginPage.verifyErrMessage());
    }
}
