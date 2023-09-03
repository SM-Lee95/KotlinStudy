package com.kotlin.study.service

import com.kotlin.study.constant.ErrorCode
import com.kotlin.study.domain.UserDetailsVo
import com.kotlin.study.repository.UserRepository
import com.kotlin.study.util.BusinessException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl: UserDetailsService {
    private val log: Logger = LoggerFactory.getLogger(UserDetailsService::class.java)
    @Autowired
    private lateinit var userRepository: UserRepository
    override fun loadUserByUsername(username: String?): UserDetails {
        username ?: throw BusinessException(ErrorCode.NOT_NULL)
        return username.run{
            val user = userRepository.findByEmail(this) ?: throw BusinessException(ErrorCode.EMAIL_NOT_FOUND)
            UserDetailsVo(user.getDomain())
        }
    }
}