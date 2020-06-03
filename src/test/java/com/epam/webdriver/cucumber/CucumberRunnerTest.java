package com.epam.webdriver.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        glue = "com.epam.webdriver",
        features = "src/test/resources/feature"
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
