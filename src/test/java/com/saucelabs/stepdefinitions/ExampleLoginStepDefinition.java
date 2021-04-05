package com.saucelabs.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleLoginStepDefinition {
   WebDriver driver;
    By usernameInput = By.id("txtUsername");
    By passwordInput = By.id("txtPassword");
    By loginButton = By.id("btnLogin");
    @Given("user will be on login page")
    public void given1(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("user enter correct credentials and click login")
    public void when1(){

        driver.findElement(usernameInput).sendKeys("Admin");
        driver.findElement(passwordInput).sendKeys("admin123");
        driver.findElement(loginButton).click();

    }

    @Then("verify login")
    public void then1(){
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        Assert.assertEquals(actualURL,expectedURL);
        driver.close();
    }
}
