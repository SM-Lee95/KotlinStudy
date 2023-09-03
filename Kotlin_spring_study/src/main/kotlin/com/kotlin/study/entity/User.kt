package com.kotlin.study.entity

import com.kotlin.study.constant.Authority
import com.kotlin.study.domain.UserDto
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
data class User(  @Id
                  @GeneratedValue(strategy = GenerationType.IDENTITY)
                  var id: Long? = null,
                  @Column(nullable = false)
                  val name: String,
                  @Column(nullable = false, unique = true)
                  val email: String,
                  @Column(nullable = false)
                  val password: String,
                  @Column(nullable = false)
                  @Enumerated(EnumType.STRING)
                  val authority: Authority = Authority.USER
) : BaseTime(){
    fun getDomain(): UserDto{
        return UserDto(name, email, password, authority)
    }
}