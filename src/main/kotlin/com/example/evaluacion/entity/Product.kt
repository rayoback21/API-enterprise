package com.example.evaluacion.entity
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "products")

class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = false)
    var id: Long? = null
    var description: String? = null
    var price: Double? = null
    var status: String? = null
    @Column(name = "created_at")
    var createdAt: Date? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id")
    var merchant:Merchant? = null
}