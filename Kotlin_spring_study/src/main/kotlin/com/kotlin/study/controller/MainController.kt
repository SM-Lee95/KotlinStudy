package com.kotlin.study.controller

import com.kotlin.study.domain.OrderDto
import com.kotlin.study.service.OrderService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping
class MainController(
    private val orderService: OrderService
) {
    @GetMapping("/")
    fun goMain(request: HttpServletRequest): String{
        request.setAttribute("hello","Template Test Complete")
        request.setAttribute("helloHtml","<b>Template Test Complete</b>")
        val orderDto = OrderDto(null, "move")
        orderService.createOrder(orderDto)
        request.setAttribute("orderDtoList", orderService.getAllOrderList())
        return "index"
    }
    @GetMapping("/move")
    fun goMove(request: HttpServletRequest): String{
        return "move"
    }
}