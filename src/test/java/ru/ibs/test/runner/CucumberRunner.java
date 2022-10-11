package ru.ibs.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/scenario",
        glue = "Steps",
        tags = "@withdrawal",
        plugin = "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
)


public class CucumberRunner {

}
