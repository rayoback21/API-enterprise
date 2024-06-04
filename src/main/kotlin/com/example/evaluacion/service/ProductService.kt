package com.example.evaluacion.service

import com.example.evaluacion.entity.Product
import com.example.evaluacion.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProductService {
    @Autowired
    lateinit var productRepository: ProductRepository

    fun list(): List<Product> {
        return productRepository.findAll()
    }

    fun save(product: Product):Product {
        return productRepository.save(product)
    }

    fun update(product: Product):Product{
        try {
            productRepository.findById(product.id)?:throw Exception("Producto no Encontrado")
            return productRepository.save(product)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(product: Product):Product{
        try {
            var reponse = productRepository.findById(product.id)?: throw  Exception("Ya Existe el Id")
            reponse.apply {
                description=product.description
            }
            return productRepository.save(reponse)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }


    fun delete(id: Long){
        try {
            var response = productRepository.findById(id).orElseThrow{throw  ResponseStatusException(HttpStatus.NOT_FOUND,"Pais no encontrado con el Id: $id")}
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al Eliminar el Producto",ex)
        }
    }


}