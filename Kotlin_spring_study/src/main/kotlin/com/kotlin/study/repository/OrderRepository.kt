package com.kotlin.study.repository;

import com.kotlin.study.entity.OrderInfo
import org.springframework.data.repository.CrudRepository

interface OrderRepository: CrudRepository<OrderInfo, Long> {
}
