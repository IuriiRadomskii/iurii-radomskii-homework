package com.epam.tc.hw1.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CalculatorMultiplyTest extends CalculatorBaseTest{

    @Test(dataProvider = "MultiplyTestData")
    public void multiplyTest(double a, double b, double expected) {
        System.out.println(calculator.mult(0.1, 0.1));
        System.out.printf("%s * %s\n", a, b);
        double actual = calculator.mult(a, b);
        Assertions.assertThat(actual).isEqualTo(expected, Assertions.offset(0.1d));
    }
}
