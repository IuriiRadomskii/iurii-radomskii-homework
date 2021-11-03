package com.epam.tc.hw1.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CalculatorAddTest extends CalculatorBaseTest {
    @Test(dataProvider = "AddTestData")
    public void sumTest(double a, double b, double expected) {
        System.out.printf("%s + %s\n", a, b);
        double actual = calculator.sum(a, b);
        Assertions.assertThat(actual)
                  .as(String.format("Add test with params %s, %s failed."
            + " Expected result is: %s. Observed result is: %s", a, b, expected, actual))
                  .isEqualTo(expected);
    }
}
