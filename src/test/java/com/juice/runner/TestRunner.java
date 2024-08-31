package com.juice.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features= "src/test/resources/features",
        glue = {"com.juice"},   //Ruta donde estan los step
        plugin =  {"pretty","summary",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@Login",   // Register AddAddress AddPayMet Login Orders OrdersHistory
        monochrome = false,  // salida de consola debe ser en color o monocromática
        publish = true,
        dryRun = false)     // Cucumber solo verifica si todos los pasos tienen definiciones

public class TestRunner extends AbstractTestNGCucumberTests {       // integra Cucumber con TestNG.

   /*  @Orders       // el método está sobrescribiendo un método de la clase padre AbstractTestNGCucumberTests).
    @DataProvider(parallel = true)      // TestNG puede ejecutar múltiples instancias de pruebas simultáneamente, cada una con un conjunto de datos diferente.
    public Object[][] scenarios() {     // método que proporciona los escenarios de Cucumber como datos para las pruebas.
        return super.scenarios();           //aprovecha la implementación existente en Cucumber para recopilar escenarios
    }  */

}

