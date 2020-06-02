package com.epam.webdriver.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        glue = "com.epam.webdriver.cucumber.steps",
        features = "src/test/resources/feature"
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
