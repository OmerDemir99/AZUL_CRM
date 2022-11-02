package com.azulcrm.step_definitions;

import com.azulcrm.pages.Dashboard;
import com.azulcrm.pages.LoginPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Map;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    Dashboard dashboard = new Dashboard();

    /**
     * Background
     */
    @Given("Users go to the Log in page")
    public void users_go_to_the_log_in_page() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }

    /**
     * Scenario Outline
     */
    @When("Type {string} and {string} in the input boxes")
    public void type_and_in_the_input_boxes(String username, String password) {
        loginPage.login(username, password);
    }
    @When("Click Log In button")
    public void click_log_in_button() {
        loginPage.loginButton.click();
    }
    @Then("Verify that user should be able to see title that contains {string}")
    public void verify_that_user_should_be_able_to_see_title_that_contains(String portal) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleContains("Portal"));
        BrowserUtils.verifyTitleContains(portal);
    }

    /**
     *
     * @param username
     * @param password
     * Parameterization
     */
    @When("Type username {string} and password {string} in the input boxes")
    public void type_username_and_password_in_the_input_boxes(String username, String password) {
        loginPage.usernameInputBox.sendKeys(username);
        loginPage.passwordInputBox.sendKeys(password);
    }
    @When("Press Enter button on the keyboard")
    public void press_enter_button_on_the_keyboard() {
        loginPage.passwordInputBox.sendKeys(Keys.ENTER);
    }

    /**
     *
     * @param credentials
     * Data Table
     */
    @When("Enter username and password in the input boxes")
    public void type_username_and_password_in_the_input_boxes(Map<String, String> credentials) {
        loginPage.usernameInputBox.sendKeys(credentials.get("username"));
        loginPage.passwordInputBox.sendKeys(credentials.get("password"));
    }

    /**
     * ConfigurationReader
     */
    @When("Type username and password in the input boxes")
    public void type_username_and_password_in_the_input_boxes() {
        loginPage.usernameInputBox.sendKeys(ConfigurationReader.getProperty("usernameMARKETING"));
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
    }

    /**
     * Login function with Invalid Credentials - Login function with Empty Credentials
     */
    @Then("Verify that user should be able to see error message {string}")
    public void verify_that_user_should_be_able_to_see_error_message(String message) {
        Assert.assertEquals(message, loginPage.errorMessage.getText());
    }

    /**
     * Login function "Get Password" page
     */
    @When("click forgot your password link")
    public void click_forgot_your_password_link() {
        if (loginPage.forgotYourPassword.getText().equalsIgnoreCase("forgot your password?")){
            loginPage.forgotYourPassword.click();
        }
    }
    @Then("verify that user should be able access get password page")
    public void verify_that_user_should_be_able_access_get_password_page() {
        BrowserUtils.verifyUrlWithContains("forgot_password");
    }
    @Then("click Authorization link")
    public void click_authorization_link() {
        loginPage.authorizationPageLink.click();
    }
    @Then("verify that user should be able to go back login page")
    public void verify_that_user_should_be_able_to_go_back_login_page() {
        BrowserUtils.verifyTitleContains("Authorization");
    }

    /**
     * Login function "Remember Me" link
     */
    @Then("verify that remember me link exist")
    public void verify_that_remember_me_link_exist() {
        // Also we can use isDisplayed() method as well
        BrowserUtils.verifyWebElementText("Remember me on this computer", loginPage.rememberMeRadioButtonText.getText());
    }
    @Then("verify that remember me link is clickable")
    public void verify_that_remember_me_link_is_clickable() {
        BrowserUtils.clickRadioButton(loginPage.rememberMeRadioButton);
    }

    /**
     * Login function password turn into bullet signs
     */
    @Then("verify that user should be able see entered password as bullet signs")
    public void verify_that_user_should_be_able_see_entered_password_as_bullet_signs() {
        String inputType = loginPage.passwordInputBox.getAttribute("type");
        Assert.assertTrue(inputType.equals("password"));
    }
    @Then("Verify that user should be able to see own name {string} in the profile menu")
    public void verify_that_user_should_be_able_to_see_own_name_in_the_profile_menu(String username) {
        String actualAccountName = dashboard.accountName.getText();
        Assert.assertEquals(username, actualAccountName);
    }
}
