package com.home.services

import com.home.domain.DataRepository
import com.home.dto.Data
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito

internal class ServiceTest{
    @Test
    fun shouldCombine() {
        val dataRepository = Mockito.mock(DataRepository::class.java)
        Mockito.`when`(dataRepository.readAll()).thenReturn(listOf(
                Data(3, "def"),
                Data(1, "abc"),
                Data(2, "abe")
        ))
        val service = Service(dataRepository)

        Assertions.assertEquals("abcabedef", service.getDataContent())
    }
}