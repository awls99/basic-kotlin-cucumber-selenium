package com.arthur

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber::class)
    @CucumberOptions(
        features = ["src/test/resources/com/arthur/features"],
        glue = ["com.arthur.features"],
        plugin = [
            "pretty",
            "json:build/cucumber-report/cucumber.json",
            "html:build/cucumber-report/cucumber.html",
            "junit:build/cucumber-report/cucumber.xml"]
    )
    public class RunTests {
    }
