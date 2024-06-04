package com.example.evaluacion.service

import com.example.evaluacion.entity.Merchant
import com.example.evaluacion.repository.MerchantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class MerchantService {
    @Autowired
    lateinit var merchantRepository: MerchantRepository

    fun list(): List<Merchant> {
        return merchantRepository.findAll()
    }

    fun save(merchant: Merchant):Merchant {
        return merchantRepository.save(merchant)
    }

    fun update(merchant: Merchant):Merchant{
        try {
            merchantRepository.findById(merchant.id)?:throw Exception("Comerciante no Encontrado")
            return merchantRepository.save(merchant)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(merchant: Merchant):Merchant{
        try {
            var reponse = merchantRepository.findById(merchant.id) ?: throw Exception("Ya Existe el Id")
            reponse.apply {
                merchantName = merchant.merchantName
            }

            return merchantRepository.save(reponse)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }


    fun delete(id: Long){
        try {
            var response = merchantRepository.findById(id).orElseThrow{throw  ResponseStatusException(HttpStatus.NOT_FOUND,"Comerciante no encontrado con el Id: $id")}
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al Eliminar al Comerciante",ex)
        }
    }

}