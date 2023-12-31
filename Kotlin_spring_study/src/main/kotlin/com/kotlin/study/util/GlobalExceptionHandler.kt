package com.kotlin.study.util

import com.kotlin.study.constant.ErrorCode
import com.kotlin.study.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler: ResponseEntityExceptionHandler() {
    val log: Logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)
    /**
     * 비즈니스 로직상 오류 발생  */
    @ExceptionHandler(BusinessException::class)
    protected fun handleBusinessException(e: BusinessException): ResponseEntity<BaseResponseBody?>? {
        log.error("handleBusinessException", e)
        val errorCode: ErrorCode = e.error
        return ResponseEntity.status(HttpStatus.OK).body<BaseResponseBody?>(errorCode.getResponseBody())
    }
    /**
     * 로그인 로직상 오류 발생  */
    @ExceptionHandler(AuthenticationException::class)
    protected fun handleAuthenticationException(e: AuthenticationException): ResponseEntity<BaseResponseBody?>? {
        log.error("handleAuthenticationException", e)
        return ResponseEntity.status(HttpStatus.OK).body<BaseResponseBody?>(BaseResponseBody(403, "Authentication Error"))
    }
}