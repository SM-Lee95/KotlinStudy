package com.kotlin.study.api

import com.kotlin.study.domain.OrderDto
import com.kotlin.study.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order")
class OrderController(
    private val orderService: OrderService
) {
    @GetMapping("/list")
    fun getOrders(): ResponseEntity<Any>  {
        return ResponseEntity.ok(orderService.getAllOrderList())
    }
    @GetMapping("/info")
    fun getOrderByUserCode(@RequestParam(name = "userCd") userCd: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(orderService.getOrderByUserCode(userCd))
    }
    @PostMapping("/info")
    fun createOrder(@RequestBody createOrderDTO: OrderDto): ResponseEntity<Any> {
        orderService.createOrder(createOrderDTO)
        return ResponseEntity.ok(true)
    }
}