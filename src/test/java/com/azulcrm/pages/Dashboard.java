package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

    public Dashboard(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user-name")
    public WebElement accountName;

    @FindBy(xpath = "(//a/span[@class='menu-popup-item-text'])[3]")
    public WebElement logOutOption;

    @FindBy(xpath = "//a/span/span[.='CRM']")
    public WebElement CRM;



}
