package com.epam.webdriver.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        glue = "com.epam.webdriver.cucumber.steps",
        features = "src/test/resources/feature",
        tags = {"@Test2"}
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
