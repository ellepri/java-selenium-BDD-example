package com.exercise.support;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features"},
        glue = {"mercator.group.steps", "mercator.group.support"},
        plugin = {"pretty"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
