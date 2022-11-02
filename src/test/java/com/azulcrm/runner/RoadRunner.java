package com.azulcrm.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "pretty",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "com/azulcrm/step_definitions",
        dryRun = false,
        tags = "@AZUL-1520",
        publish = true
)
public class RoadRunner {

}
