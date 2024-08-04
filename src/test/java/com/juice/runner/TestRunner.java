package com.juice.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features= "src/test/resources/features",
        glue = {"com.juice"},   //Ruta donde estan los step
        plugin =  {"pretty","summary",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@OrdersHistory",
        monochrome = false,
        publish = true,
        dryRun = false)

public class TestRunner extends AbstractTestNGCucumberTests {


}

