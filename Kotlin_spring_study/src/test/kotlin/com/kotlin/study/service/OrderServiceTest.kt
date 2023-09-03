package com.kotlin.study.service

import com.kotlin.study.domain.OrderDto
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class OrderServiceTest {
    @Autowired
    private lateinit var orderService: OrderService

    @Test
    fun createOrder() {
        val list = mutableListOf<OrderDto>()
        for(i in 1..10)
        {
            val orderDto = OrderDto(null, "move")
            list.add(orderDto)
        }
        orderService.createOrderList(list)

    }

    @Test
    fun getAllOrderList() {
    }

    @Test
    fun getOrderByUserCode() {
    }
}