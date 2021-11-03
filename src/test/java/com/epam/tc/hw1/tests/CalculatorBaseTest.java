package com.epam.tc.hw1.tests;


import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CalculatorBaseTest extends CalculatorDataProvidersForTests {

    protected Calculator calculator;

    @BeforeClass
    public void createCalculator() {
        this.calculator = new Calculator();
    }

    @AfterClass
    public void tearDown() {
        this.calculator = null;
    }
}
