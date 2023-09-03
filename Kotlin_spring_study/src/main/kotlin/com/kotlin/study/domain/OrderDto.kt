package com.kotlin.study.domain;

import com.kotlin.study.entity.OrderInfo

data class OrderDto (
    val id: Long?,
    val moveUrl: String
){
    fun toEntity(): OrderInfo{
        return OrderInfo(id)
    }
}
