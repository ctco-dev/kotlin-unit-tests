package com.home.utils

import com.home.dto.Data
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream

internal class CalculatorTest {

    //custom name not working
    @ParameterizedTest(name = "{0} plus {1} should be {2}")
    @CsvSource("1,2,3", "-1,0,-1")
    fun shouldSum(a: Int, b: String, result: Int) {
        assertEquals(result, Calculator.sum(a, b))
    }

    data class SumCase(val a: Int, val b: String, val expected: Int)


    companion object {
        @JvmStatic
        fun sumCaseSource(): Stream<SumCase> {
            return Stream.of(SumCase(1, "2", 3),
                    SumCase(-1, "0", -1),
                    SumCase(-1, "", -1),
                    SumCase(-1, "abc", -1))
        }
    }

    //companion object is required
    @ParameterizedTest
    @MethodSource("sumCaseSource")
    fun shouldSumViaMethodSource(case: SumCase) {
        assertEquals(case.expected, Calculator.sum(case.a, case.b))
    }

    //less code, no individual results per case
    @Test
    fun shouldSumWithTableCases() {
        data class Case(val a: Int, val b: String, val expected: Int)

        val cases = listOf(Case(1, "2", 3),
                Case(-1, "0", -1),
                Case(-1, "", -1),
                Case(-1, "abc", -1))

        cases.forEach {
            assertEquals(it.expected, Calculator.sum(it.a, it.b))
        }
    }

    @Test
    fun shouldFilterByContent() {
        val data = listOf(Data(1, "abc"), Data(2, "bc"), Data(3, "a"), Data(4, "ab"))
        val expected = listOf(Data(1, "abc"), Data(4, "ab"))
        assertEquals(expected, Calculator.filterByContent(data, "a.+"))
    }

    @Test
    fun shouldFilterEmpty() {
        val data = Collections.emptyList<Data>()
        val expected = Collections.emptyList<Data>()
        assertEquals(expected, Calculator.filterByContent(data, "a.+"))
    }

    //ValueSource won't accept null

    //@ParameterizedTest
    //@ValueSource(strings = arrayOf<String?>( "", null))
    @Test
    fun shouldFilterWithoutRegex() {
        val data = listOf(Data(1, "abc"), Data(4, "ab"))
        val expected = listOf(Data(1, "abc"), Data(4, "ab"))
        assertEquals(expected, Calculator.filterByContent(data, ""))
        assertEquals(expected, Calculator.filterByContent(data, null))
    }

    @Test
    fun shouldThrow() {
        val data = Collections.emptyList<Data>()

        assertThrows(IllegalArgumentException::class.java) {
            Calculator.filterByContent(data, "\\")
        }
    }

}