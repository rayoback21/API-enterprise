package com.example.evaluacion.service

import com.example.evaluacion.entity.Country
import com.example.evaluacion.repository.CountryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CountryService {
    @Autowired
    lateinit var countryRepository: CountryRepository

    fun list(): List<Country> {
        return countryRepository.findAll()
    }

    fun save(country: Country):Country {
        return countryRepository.save(country)
    }

    fun update(country: Country):Country{
        try {
            countryRepository.findById(country.id)?:throw Exception("Pais no Encontrado")
            return countryRepository.save(country)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(country: Country):Country{
        try {
            var reponse = countryRepository.findById(country.id)?: throw  Exception("Ya Existe el Id")
            reponse.apply {
                countryName=country.countryName
            }
            return countryRepository.save(reponse)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }


    fun delete(id: Long){
        try {
            var response = countryRepository.findById(id).orElseThrow{throw  ResponseStatusException(HttpStatus.NOT_FOUND,"Pais no encontrado con el Id: $id")}
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al Eliminar el Pais",ex)
        }
    }
}