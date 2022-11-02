package com.azulcrm.step_definitions;

import com.azulcrm.pages.Dashboard;
import com.azulcrm.pages.LoginPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;


public class Logout_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    Dashboard dashboard = new Dashboard();

    /**
     * Background
     */
    @When("Users login with valid credentials")
    public void users_login_with_valid_credentials() {
        loginPage.usernameInputBox.sendKeys(ConfigurationReader.getProperty("usernameHR"));
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginButton.click();
    }

    /**
     * Logout button scenario
     */
    @When("click username dropdown that is top right on the homepage")
    public void click_username_dropdown_that_is_top_right_on_the_homepage() {
        dashboard.accountName.click();
    }
    @When("click Log out button")
    public void click_log_out_button() {
        dashboard.logOutOption.click();
    }
    @Then("verify that user should be able to log out and see login page")
    public void verify_that_user_should_be_able_to_log_out_and_see_login_page() {
        BrowserUtils.verifyTitle("Authorization");
    }


    /**
     * Open two tabs with same credentials
     */
    @When("open new tab and log in with same credentials")
    public void open_new_tab_and_log_in_with_same_credentials() {
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        jse.executeScript("window.open()");
        ArrayList<String> sessionIDs = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(sessionIDs.get(1));
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @Then("verify that user should NOT be able to do anything in the another open homepage")
    public void verify_that_user_should_not_be_able_to_do_anything_in_the_another_open_homepage() {
        ArrayList<String> sessionIDs = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(sessionIDs.get(0));
        dashboard.CRM.click();
        BrowserUtils.sleep(2);
        BrowserUtils.verifyTitle("Authorization");
    }

    /**
     * Back Button
     */
    @When("click back button")
    public void click_back_button() {
        Driver.getDriver().navigate().back();
    }

    @Then("verify that user should NOT be able to go back home page")
    public void verify_that_user_should_not_be_able_to_go_back_home_page() {
        BrowserUtils.verifyTitle("Authorization");
    }

    /**
     * Close single open tab
     */
    @When("close the single tab")
    public void close_the_single_tab() {
        Driver.closeDriver();
        BrowserUtils.sleep(2);
    }
    @When("open new browser and go to login page")
    public void open_new_browser_and_go_to_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        BrowserUtils.sleep(2);
    }

    /**
     * Close AzulCRM and try to go login page from another tab
     */
    @When("open new tab or tabs")
    public void open_new_tab_or_tabs() {
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        jse.executeScript("window.open()");
        BrowserUtils.sleep(1);
        jse.executeScript("window.open()");
    }
    @When("close the tab that is for Azul_crm")
    public void close_the_tab_that_is_for_azul_crm() {
        String sessionID = Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().window(sessionID).close();
        BrowserUtils.sleep(1);
    }
    @When("go to the login page using other tab")
    public void go_to_the_login_page_using_other_tab() {
        ArrayList<String> sessionIDs = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(sessionIDs.get(1));
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("url"));
    }

    /**
     * Try to go back using browser history from another web site without logging out
     */
    @When("go to the another web site and close web site")
    public void go_to_the_another_web_site_and_close_web_site() {
       ArrayList<String> sessionIDs = new ArrayList<>(Driver.getDriver().getWindowHandles());
       Driver.getDriver().switchTo().window(sessionIDs.get(0));
       Driver.getDriver().navigate().to(ConfigurationReader.getProperty("url1"));
       Driver.getDriver().close();
       BrowserUtils.sleep(1);
    }
    @When("go to the another web site")
    public void go_to_the_another_web_site() {
        ArrayList<String> sessionIDs = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(sessionIDs.get(0));
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("url1"));
        BrowserUtils.sleep(1);
    }
    @When("select first option from history")
    public void select_first_option_from_history() {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.history.go(-1)");
    }

    /**
     * Press shortcut key to go to previous web page
     */
    @And("press shortcut key to go to previous web page")
    public void press_shortcut_key_to_go_previous_web_page() {
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(loginPage.blueArea).click().sendKeys(Keys.COMMAND).sendKeys(Keys.ARROW_LEFT).perform();
    }

}
