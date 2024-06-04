package com.example.evaluacion.service

import com.example.evaluacion.entity.OrderItem
import com.example.evaluacion.repository.OrderItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class OrderItemService {
    @Autowired
    lateinit var orderItemRepository: OrderItemRepository

    fun list (): List<OrderItem> {
        return orderItemRepository.findAll()
    }

    fun save(orderItem: OrderItem): OrderItem {
        return orderItemRepository.save(orderItem)
    }

    fun update(orderItem: OrderItem): OrderItem {
        try {
            orderItemRepository.findById(orderItem.id)?:throw Exception("Articulo no Encontrado")
            return orderItemRepository.save(orderItem)
        }catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
            }
        }
    fun updateOrder(orderItem: OrderItem):OrderItem{
        try {
            var reponse = orderItemRepository.findById(orderItem.id)?: throw  Exception("Ya Existe el Id")
            reponse.apply {
                order=orderItem.order
            }
            return orderItemRepository.save(reponse)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }


    fun delete(id: Long){
        try {
            var response = orderItemRepository.findById(id).orElseThrow{throw  ResponseStatusException(HttpStatus.NOT_FOUND,"Pais no encontrado con el Id: $id")}
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al Eliminar el Articulo",ex)
        }
    }

}