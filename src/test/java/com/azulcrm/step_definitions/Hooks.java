package com.azulcrm.step_definitions;

import com.azulcrm.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
In the class we will be able to pass pre-conditions and post-conditions to each scenario and each step
 - Hooks class will allow us to pass pre and post conditions for each scenario and each step.
 - Hooks class is seperated from feature file
 - Therefore it will go into the implementation side (step_definitions)
 - Basically logic is coming from the cucumber annotations and also glue path we provide in the runner class.
 */
public class Hooks {

    // import from io.cucumber.java not from junit

    /*
    - If we have multiple versions of the same annotation, we can prioritize the running order using the "order" keyword.
    - The lower the number passed in the order, earlier it will be executed.

    - We can specify which annotation is running for which scenarios or features using @TAGS.
     */


    //@Before(order = 0)
    public void setupScenario() {
        System.out.println("=====Setting up browser using cucumber @Before");
    }

    //@Before(value = "@login", order = 1)
    public void setupScenarioForLogin() {
        System.out.println("=====This will only apply to scenarios with @login tag");
        /*
         - comes from cucumber-java dependency
         - this will change the behavior of the method we use it.
         - this method will be running BEFORE each and every SCENARIO in our project (unless we specify with @TAGS)
         */

    }

    //@Before(value = "@db", order = -1)
    public void setupForDatabaseScenarios() {
        System.out.println("=====This will only apply to scenarios with @db tag");
    }


    @After
    public void teardownScenario(Scenario scenario) {

        /*
        This Scenario class is actually keeping track the currently executed scenario.
        For example, we have multiple feature files, and we have multiple scenario in each file
        somehow our cucumber is following which scenario is being executed. This information is actually stored in Scenario class object.
        And this object is capable of doing a few things.

         */
        if (scenario.isFailed()) { // If scenario fails this method will return TRUE

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        /*
        TakesScreenshot is an interface and getScreenshotAs(OutputType.BYTES) method is an abstract method coming from TakeScreenshot interface.
        For using that method we need to do downcasting(Polymorphism)
         */

            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        // scenario.attach(); // This method allow us to attach our screenshot into our report
        // scenario.getName(); // This method is basically providing the name of scenario
        // scenario.isFailed(); // if you want to get screenshot only the scenario is failed you can use this method

        Driver.closeDriver();
        // System.out.println("=====Closing browser using cucumber @After");
        // System.out.println("=====Scenario ended/ Take screenshot if failed!");
        /*
          - comes from cucumber-java dependency
          - this will change the behavior of the method we use it.
          - this method will be running AFTER each and every SCENARIO in our project (unless we specify with @TAGS)
         */
    }

    //@BeforeStep
    public void setupStep() {
        System.out.println("---------------------> Applying setup using @BeforeStep");
    }


    //@AfterStep
    public void afterStep() {
        System.out.println("---------------------> Applying tearDown using @AfterStep");
        /*
          - comes from cucumber-java dependency
          - this will change the behavior of the method we use it.
          - this method will be running AFTER each and every STEP in our project (unless we specify with @TAGS)
         */

    }

}
