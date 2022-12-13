package com.altimateqa.courses.pages;

import com.altimateqa.courses.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome Back!')]")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(id = "user[email]")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "user[password]")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement signInButton;

    @CacheLookup
    @FindBy(xpath = "//li[@class='form-error__list-item']")
    WebElement errorMessage;


    public String getWelcomeText() {
        Reporter.log("WelcomeText"+ welcomeText.toString());
        return getTextFromElement(welcomeText);

    }

    public void enterEmailId(String email) {
        Reporter.log("enterEmailField"+ emailField.toString());
        sendTextToElement(emailField, email);
    }

    public void enterPassword(String password) {
        Reporter.log("enterPassword"+ passwordField.toString());
        sendTextToElement(passwordField, password);
    }

    public void clickOnSignInButton() {
        Reporter.log("clickOnSignButton"+ signInButton.toString());
        clickOnElement(signInButton);

    }

    public String verifyErrorMessage() {
        Reporter.log("VerifyErrorMessage"+ errorMessage.toString());
        return getTextFromElement(errorMessage);
    }
}



