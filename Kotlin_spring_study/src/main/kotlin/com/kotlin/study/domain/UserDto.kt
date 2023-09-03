package com.kotlin.study.domain

import com.kotlin.study.constant.Authority
import com.kotlin.study.constant.ErrorCode
import com.kotlin.study.entity.User
import com.kotlin.study.util.BusinessException
import org.springframework.security.core.GrantedAuthority

data class UserDto(
    var name: String?,
    var email: String?,
    var password: String?,
    var authority: Authority?
) {
    fun getEntity(): User{
        if(name == null || email == null || password == null) throw BusinessException(ErrorCode.NOT_NULL)
        return User(name= name!!, email= email!!, password =  password!!)
    }
    fun getAuthority(): MutableCollection<out GrantedAuthority>{
        return mutableListOf(GrantedAuthority{authority?.name})
    }
}