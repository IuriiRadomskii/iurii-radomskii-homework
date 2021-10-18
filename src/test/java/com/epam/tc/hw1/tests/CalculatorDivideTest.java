package com.epam.tc.hw1.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CalculatorDivideTest extends CalculatorBaseTest{

    @Test(dataProvider = "DivideTestData")
    public void divideTest(double a, double b, double expected) {
        System.out.printf("%s / %s\n", a, b);
        double actual = calculator.div(a, b);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
