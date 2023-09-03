package com.kotlin.study.entity

import com.kotlin.study.domain.OrderDto
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name="order_info")
data class OrderInfo (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
){
    fun getDomain(): OrderDto{
        return OrderDto(id, "move")
    }
}