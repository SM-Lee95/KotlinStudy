package com.kotlin.study.util

import com.kotlin.study.constant.ErrorCode

data class BusinessException(
    val error: ErrorCode
): RuntimeException(error.message)
