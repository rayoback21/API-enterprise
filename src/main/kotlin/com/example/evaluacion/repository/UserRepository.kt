package com.example.evaluacion.repository


import com.example.entity.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findById(id: Long?): User?
}
