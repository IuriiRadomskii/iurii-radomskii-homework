package com.epam.tc.hw1.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CalculatorDivideTest extends CalculatorBaseTest {

    @Test(dataProvider = "DivideTestData")
    public void divideTest(long a, long b, double expected) {
        System.out.printf("%s / %s\n", a, b);
        double actual = calculator.div(a, b);
        Assertions.assertThat(actual).as(String.format("Divide test with params %s, %s failed."
            + " Expected result is: %s. Observed result is: %s", a, b, expected, actual))
                  .isEqualTo(expected, Assertions.offset(0.1d));

    }

    @Test(expectedExceptions = {NumberFormatException.class})
    public void divideByZero() {
        double actual = calculator.div(10L, 0L);
    }
}
