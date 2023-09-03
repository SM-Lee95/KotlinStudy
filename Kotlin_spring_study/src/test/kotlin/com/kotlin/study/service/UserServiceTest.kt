package com.kotlin.study.service

import com.kotlin.study.constant.Authority
import com.kotlin.study.domain.UserDto
import groovy.util.logging.Slf4j
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UsernameNotFoundException

@SpringBootTest
class UserServiceTest {
    val log: Logger = LoggerFactory.getLogger(UserServiceTest::class.java)
    @Autowired
    private lateinit var userService: UserService
    @Test
    fun loadUserByUsername() {
        for( i in 1..200)
            userService.insertUser(UserDto("${i}_이성무","sm-lee$i@nate.com","password", null))
        assertThrows(UsernameNotFoundException::class.java){userService.loadUserByUsername(null)}
        assertThrows(UsernameNotFoundException::class.java){userService.loadUserByUsername(null)}
        val loadUserByUsername = userService.loadUserByUsername("sm-lee1@nate.com")
        assert(loadUserByUsername.authorities.first().authority == (Authority.USER.name))
    }

    @Test
    fun insertUser() {
        for( i in 1..200)
            userService.insertUser(UserDto("${i}_이성무","sm-lee$i@nate.com","password", null))
        for( i in 1..200)
            println(userService.loadUserByUsername("sm-lee$i@nate.com").username)
    }
}