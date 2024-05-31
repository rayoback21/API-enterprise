
package com.example.evaluacion.repository

import com.example.evaluacion.entity.Merchant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MerchantRepository: JpaRepository<Merchant, Long> {
    fun <Merchant> findById(merchantId: Long?): Merchant?
}
