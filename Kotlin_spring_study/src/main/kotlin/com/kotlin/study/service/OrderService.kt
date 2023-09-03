package com.kotlin.study.service

import com.kotlin.study.domain.OrderDto
import com.kotlin.study.entity.OrderInfo
import com.kotlin.study.repository.OrderRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderService(
    private val orderRepository: OrderRepository
) {
    private val log: Logger = LoggerFactory.getLogger(UserDetailsService::class.java)
    fun createOrder(orderDto: OrderDto){
        val newVal = orderDto.toEntity()
        val entity = orderRepository.save(newVal)
        println(entity.toString())
    }
    fun createOrderList(orderDtoList: List<OrderDto>){
        orderRepository.saveAll(orderDtoList.map{it.toEntity()})
    }
    fun getAllOrderList(): List<OrderDto>{
        return orderRepository.findAll().map{ it.getDomain()}
    }
    fun getOrderByUserCode(userCd: Long): List<OrderDto>{
        return orderRepository.findAll().map{ it.getDomain()}
    }
}