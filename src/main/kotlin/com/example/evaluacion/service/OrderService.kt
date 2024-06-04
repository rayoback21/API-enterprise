package com.example.evaluacion.service

import com.example.evaluacion.entity.Order
import com.example.evaluacion.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class OrderService {
    @Autowired
    lateinit var orderRepository: OrderRepository

    fun list(): List<Order> {
        return orderRepository.findAll()
    }

    fun save(order: Order):Order {
        return orderRepository.save(order)
    }

    fun update(order: Order):Order{
        try {
            orderRepository.findById(order.id)?:throw Exception("Orden no Encontrada")
            return orderRepository.save(order)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateStatus(order: Order):Order{
        try{
            var reponse = orderRepository.findById(order.id)?: throw  Exception("Ya Existe el Id")
            reponse.apply {
                status=order.status
            }
            return orderRepository.save(reponse)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }


    fun delete(id: Long){
        try {
            var response = orderRepository.findById(id).orElseThrow{throw  ResponseStatusException(HttpStatus.NOT_FOUND,"Orden no Encontrada con el Id: $id")}
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al Eliminar la Orden",ex)
        }
    }
}