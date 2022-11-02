package com.azulcrm.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.azulcrm.utilities.Driver;

public class LoginPage {

   public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "USER_LOGIN")
    public WebElement usernameInputBox;

    @FindBy(name = "USER_PASSWORD")
    public WebElement passwordInputBox;

    @FindBy(className = "login-btn")
    public WebElement loginButton;

    @FindBy(xpath = "//div/label[@class='login-item-checkbox-label']")
    public WebElement rememberMeRadioButtonText;

    @FindBy(id = "USER_REMEMBER")
    public WebElement rememberMeRadioButton;

    @FindBy(xpath = "//div/a[@class='login-link-forgot-pass']")
    public WebElement forgotYourPassword;

    @FindBy(xpath = "//div[@class='log-popup-header']/following-sibling::div[1]")
    public WebElement errorMessage;

    @FindBy(name = "log-popup-header")
    public WebElement getPassword;

    @FindBy(linkText = "Authorization")
    public WebElement authorizationPageLink;

    @FindBy(className = "log-popup-header")
    public WebElement authorization;

    @FindBy(xpath = "//table//td[@class='log-top-cell']")
    public WebElement blueArea;


    @FindBy(id = "nav-xshop")
    public WebElement amazonBlackBar;

    public void login(String username, String password){
       this.usernameInputBox.sendKeys(username);
       this.passwordInputBox.sendKeys(password);
    }



}
