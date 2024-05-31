package com.example.evaluacion.repository

import com.example.evaluacion.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: JpaRepository<Order, Long> {
    fun findById(id: Long?): Order?
}