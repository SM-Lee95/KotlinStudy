package com.kotlin.study.repository

import com.kotlin.study.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long> {
    fun findByEmail(email: String): User?
}