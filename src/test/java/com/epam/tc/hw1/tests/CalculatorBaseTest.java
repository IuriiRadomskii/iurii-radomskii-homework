package com.epam.tc.hw1.tests;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class CalculatorBaseTest {

    protected Calculator calculator;

    @BeforeClass
    public void createCalculator() {
        this.calculator = new Calculator();
    }

    @DataProvider(name = "AddTestData")
    public Object[][] getAddTestData() {
        return new Object[][]{
                {1, 1, 2},
                {1, -1, 0},
                {-100, -100, -200},
                {0, 0, 0}
        };
    }

    @DataProvider(name = "SubtractTestData")
    public Object[][] getSubtractTestData() {
        return new Object[][]{
                {100, 1, 99},
                {-100, -99, -1},
                {10, 100, -90},
                {0, 0, 0}
        };
    }

    @DataProvider(name = "MultiplyTestData")
    public Object[][] getMultiplyTestData() {
        return new Object[][]{
                {0, 0, 0},
                {0, -1, 0},
                {-1, -2, 2},
                {5, 5, 25},
                {0.5, 0.5, 0}
        };
    }

    @DataProvider(name = "DivideTestData")
    public Object[][] getDivideTestData() {
        return new Object[][]{
                {100, 10, 10},
                {100, -100, -1},
                {0, 100, 0},
                {5, -5, -1},
                {1, 2, 0.5}
        };
    }
}
