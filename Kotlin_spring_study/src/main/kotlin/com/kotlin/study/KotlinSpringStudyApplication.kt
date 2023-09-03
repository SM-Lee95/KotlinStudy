package com.kotlin.study

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class KotlinSpringStudyApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringStudyApplication>(*args)
}
