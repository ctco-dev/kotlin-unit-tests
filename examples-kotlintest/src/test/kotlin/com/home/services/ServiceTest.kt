package com.home.services

import com.home.domain.DataRepository
import com.home.dto.Data
import io.kotlintest.shouldBe
import io.kotlintest.specs.AnnotationSpec
import org.mockito.Mockito

class ServiceTest : AnnotationSpec() {
    lateinit var service: Service

    @BeforeClass
    fun beforeClass() {
        val dataRepoMock = Mockito.mock(DataRepository::class.java)
        Mockito.`when`(dataRepoMock.readAll()).thenReturn(listOf(
                Data(3, "def"),
                Data(1, "abc"),
                Data(2, "abe")
        ))

        this.service = Service(dataRepoMock)
    }

    @Test
    fun shouldCombine() {
        this.service.getDataContent().shouldBe("abcabedef")
    }
}