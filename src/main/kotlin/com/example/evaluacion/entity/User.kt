package com.example.entity.model

import com.example.evaluacion.entity.Country
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(name = "fullname")
    var fullName: String? = null
    var email: String? = null
    var gender: String? = null
    @Column(name = "birth_date")
    var birthDate: String? = null
    @Column(name = "created_at")
    var createdAt: Date? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    var country: Country? = null
}


