package com.example.evaluacion.service

import com.example.entity.model.User
import com.example.evaluacion.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService{
    @Autowired
    lateinit var userRepository: UserRepository

    fun list(): List<User> {
        return userRepository.findAll()
    }

    fun save(user: User):User {
        return userRepository.save(user)
    }

    fun update(user: User):User{
        try {
            userRepository.findById(user.id)?:throw Exception("Usuario no Encontrado")
            return userRepository.save(user)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(user: User):User{
        try {
            var reponse = userRepository.findById(user.id)?: throw  Exception("Ya Existe el Id")
            reponse.apply {
                fullName=user.fullName
            }
            return userRepository.save(reponse)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }


    fun delete(id: Long){
        try {
            var response = userRepository.findById(id).orElseThrow{throw  ResponseStatusException(HttpStatus.NOT_FOUND,"Pais no encontrado con el Id: $id")}
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al Eliminar el Usuario",ex)
        }
    }
}