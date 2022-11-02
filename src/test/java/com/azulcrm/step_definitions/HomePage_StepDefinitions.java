package com.azulcrm.step_definitions;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class HomePage_StepDefinitions {

    public HomePage_StepDefinitions(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



}
