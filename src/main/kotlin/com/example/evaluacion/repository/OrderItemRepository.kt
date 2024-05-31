package com.example.evaluacion.repository

import com.example.evaluacion.entity.OrderItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderItemRepository:JpaRepository<OrderItem, Long> {
    fun findById(id: Long?) : OrderItem?
}