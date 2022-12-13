package com.altimateqa.courses.testsuit;

import com.altimateqa.courses.pages.HomePage;
import com.altimateqa.courses.pages.LoginPage;
import com.altimateqa.courses.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    HomePage homepage;
    @BeforeMethod(alwaysRun = true)
    public void inIt1(){homepage = new HomePage();}
    LoginPage loginpage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){loginpage = new LoginPage();}

    @Test (groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){

        homepage.clickOnSignIn();
        String expectedText = "Welcome Back!";
        String actualText = loginpage.getWelcomeText();
        Assert.assertEquals(actualText,expectedText,"Welcome Back!");
    }

    @Test (groups = {"smoke","regression"})
    public void verifyTheErrorMessage(){

        homepage.clickOnSignIn();
        loginpage.enterEmailId("Ritzs@gmail.com");
        loginpage.enterPassword("Ritz123");
        loginpage.clickOnSignInButton();

        String expectedText = "Invalid email or password.";
        String actualText = loginpage.verifyErrorMessage();
        Assert.assertEquals(actualText,expectedText,"Invalid email or password.");
    }

}





