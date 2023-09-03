package com.kotlin.study.service

import com.kotlin.study.config.JwtTokenProvider
import com.kotlin.study.constant.ErrorCode
import com.kotlin.study.domain.UserDetailsVo
import com.kotlin.study.domain.UserDto
import com.kotlin.study.repository.UserRepository
import com.kotlin.study.util.BusinessException
import groovy.util.logging.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository,
    private val jwtTokenProvider: JwtTokenProvider,
){
    private val log: Logger = LoggerFactory.getLogger(UserService::class.java)
    fun insertUser(user: UserDto){
        log.info(user.getEntity().toString())
        userRepository.save(user.getEntity())
    }
    fun login(user: UserDto): String {
        return user.email?.let { jwtTokenProvider.createToken(it) } ?: throw BusinessException(ErrorCode.NOT_NULL)
    }
}