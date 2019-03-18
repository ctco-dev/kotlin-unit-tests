package com.home.utils

import com.home.dto.Data
import java.util.regex.Pattern

class Calculator {

    companion object {
        fun sum(a: Int, b: String): Int {
            var bInt = 0
            try {
                bInt = Integer.parseInt(b)
            } catch (e: NumberFormatException) {
            }

            return a + bInt;
        }

        //test for normal filtering, filtering of empty data, invalid and empty regex
        fun filterByContent(data: List<Data>, regex: String?): List<Data> {
            if (regex == null || regex.isBlank()) {
                return data
            }
            val pattern = Pattern.compile(regex)
            return data.filter { d -> pattern.matcher(d.content).matches() }
        }
    }
}