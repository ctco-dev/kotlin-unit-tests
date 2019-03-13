package com.home.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CalculatorTest {

    //custom name not working
    @ParameterizedTest(name = "{0} plus {1} should be {2}")
    @CsvSource("1,2,3", "-1,0,-1")
    fun shouldSum(a: Int, b: String, result: Int) {
        assertEquals(result, Calculator.sum(a, b))
    }
}