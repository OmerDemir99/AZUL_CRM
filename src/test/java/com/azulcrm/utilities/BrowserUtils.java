package com.azulcrm.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    public static void sleep( int second ){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedUrl, String expectedTitle) {
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for ( String each : allWindowHandles ) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL : " + Driver.getDriver().getCurrentUrl());
            if ( Driver.getDriver().getCurrentUrl().contains(expectedUrl) ) {
                break;
            }
        }
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }

    /**
     * This method will verify actual URL contains the value
     * @param expectedInUrl
     */
    public static void verifyUrlWithContains(String expectedInUrl){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInUrl));
    }

    public static void waitForInvisibilityOf(WebElement webElement){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    /**
     * This method will accept a dropdown as a WebElement and return all the options' text in a List of String
     * @param dropdownElement
     * @return List<String>
     */
    public static List<String> dropdownOptions(WebElement dropdownElement){

        Select select = new Select(dropdownElement);
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        List<String > actualOptions = new ArrayList<>();

        for (WebElement element : actualOptionsAsWebElement) {
            actualOptions.add(element.getText());
        }

        return actualOptions;
    }


    /**
     * This method will accept a group of WebElement.
     * It will loop through the List, and click to the radio button with provided attributeValue
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButtons(List<WebElement> radioButtons, String  attributeValue){

        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equals(attributeValue)){
                each.click();
                Assert.assertTrue(each.isSelected());
            }
        }
    }

    public static void verifyTitleContains(String expectedValue){
       String title = Driver.getDriver().getTitle();
       Assert.assertTrue(title.contains(expectedValue));
    }

    public static void verifyWebElementText(String expectedText, String webElementText){
        Assert.assertEquals(expectedText, webElementText);
    }

    public static void clickRadioButton(WebElement radioButton){
                radioButton.click();
                Assert.assertTrue(radioButton.isSelected());
    }
}
