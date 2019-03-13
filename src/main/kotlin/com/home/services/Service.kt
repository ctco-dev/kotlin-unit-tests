package com.home.services

import com.home.domain.DataRepository
import java.util.stream.Collectors

class Service(val repository: DataRepository){

    fun getDataContent(): String{
        val data = repository.readAll()
        return data.stream()
                .map { it.content }
                .sorted()
                .collect(Collectors.joining(""))
    }
}

