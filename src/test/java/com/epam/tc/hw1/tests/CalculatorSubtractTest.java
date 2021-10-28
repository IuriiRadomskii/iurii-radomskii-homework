package com.epam.tc.hw1.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CalculatorSubtractTest extends CalculatorBaseTest {

    @Test(dataProvider = "SubtractTestData")
    public void subtractTest(int a, int b, long expected) {
        System.out.printf("%d - %d\n", a, b);
        long actual = calculator.sub(a, b);
        Assertions.assertThat(actual)
                  .as(String.format("Subtract test with params %s, %s failed."
                      + " Expected result is: %s. Observed result is: %s", a, b, expected, actual))
                  .isEqualTo(expected);
    }

}
