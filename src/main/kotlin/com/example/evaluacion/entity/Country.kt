package com.example.evaluacion.entity

import jakarta.persistence.*

    @Entity
    @Table(name = "country")
    class Country {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false)
        var id: Long? = null
        var code: String? = null
        @Column(name = "country_name")
        var countryName: String? = null
        @Column(name = "continent_name")
        var continentName: String? = null


}