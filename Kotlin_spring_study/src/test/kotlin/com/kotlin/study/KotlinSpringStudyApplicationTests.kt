package com.kotlin.study

import com.kotlin.study.domain.OrderDto
import com.kotlin.study.service.OrderService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KotlinSpringStudyApplicationTests {
    @Autowired
    private lateinit var orderService: OrderService
    @Test
    fun contextLoads() {
    }

    @Test
    fun orderInsertTest(){
        for( index in 0..10){
            orderService.createOrder(OrderDto(null, "test"))
        }
        val allOrderList = orderService.getAllOrderList()
        allOrderList.forEach { println(it.id)}
        Assertions.assertThat(allOrderList.size == 11)
    }
}
