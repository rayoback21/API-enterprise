package com.example.evaluacion.entity
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "merchant")

class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null
    @Column(name = "merchant_name")
    var merchantName: String? = null
    var created_at: Date? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    var user:User? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    var country:Country? = null
}
