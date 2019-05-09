package com.home.utils

import io.kotlintest.data.forall
import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class NumberStringGenerator : Gen<String> {
    override fun constants(): Iterable<String> = listOf(
            Int.MAX_VALUE.toString(), Int.MIN_VALUE.toString(), "0"
    )

    override fun random(): Sequence<String> = generateSequence {
        Gen.int().random().first().toString()
    }
}

class CalculatorTest : StringSpec() {
    init {
        // see https://github.com/kotlintest/kotlintest/blob/master/doc/reference.md#table-driven-testing
        "Should sum using Table" {
            forall(
                    row(1, "2", 3),
                    row(-1, "-1", -2),
                    row(0, "0", 0)
            ) { left, right, expectedResult ->
                Calculator.sum(left, right).shouldBe(expectedResult)
            }
        }

        // see https://github.com/kotlintest/kotlintest/blob/master/doc/reference.md#property-based-testing-
        "Should sum using NumberStringGenerator" {
            forAll(Gen.int(), NumberStringGenerator()) { left, right ->
                // this function must return a boolean, so doing assertions here isn't always feasible
                Calculator.sum(left, right) == left + right.toInt()
            }
        }
    }
}
