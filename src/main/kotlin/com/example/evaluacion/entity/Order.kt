package com.example.evaluacion.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "orden")

class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    var status: String? = null
    @Column(name = "create_at")
    var createAt: Date? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user:User? = null
}