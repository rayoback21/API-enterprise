package com.example.evaluacion.repository

import com.example.evaluacion.entity.Country
import org.springframework.data.jpa.repository.JpaRepository

interface CountryRepository: JpaRepository<Country, Long> {
    fun  findById (id:Long?):Country?
}
