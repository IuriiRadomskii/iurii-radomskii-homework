package com.epam.tc.hw1.tests;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class CalculatorBaseTest extends CalculatorDataProvidersForTests {

    protected Calculator calculator;

    @BeforeClass
    public void createCalculator() {
        this.calculator = new Calculator();
    }
}
