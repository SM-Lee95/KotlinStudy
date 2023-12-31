package com.kotlin.study.config

import com.kotlin.study.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
class SecurityConfig {
    val WEB_WHITE_LIST: Array<String> = arrayOf(
        "/images/**", "/js/**", "/webjars/**",
        /* swagger v2 */
        "/v2/api-docs",
        "/swagger-resources",
        "/swagger-resources/**",
        "/configuration/ui",
        "/configuration/security",
        "/swagger",
        "/webjars/**",
        /* swagger v3 */
        "/v3/api-docs/**",
        "/swagger-ui/**",
        /* Resource */
        "/css/**",
        "/js/**",
        "/util/**",
        "/img/**",
        "/fonts/**",
        "/favicon.ico",
    );
    val WHITE_LIST: Array<String> = arrayOf(
        "/", "/user/login", "/user/info",
    );
    @Autowired
    lateinit var jwtTokenProvider: JwtTokenProvider
    /** WebSecurity - 인증,인가 모두 처리 X (HttpSecurity 보다 선순위) */
    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { authorize ->
            WEB_WHITE_LIST.forEach {
                authorize.ignoring().requestMatchers(it)
            }
        }
    }
    /** HttpSecurity - antMatchers에 있는 endpoint에 대한 '인증'을 무시한다.*/
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http.formLogin { it.disable() }
            .httpBasic { it.disable() }
            .csrf { it.disable() }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .headers { it.frameOptions { it.disable() } }
            .addFilterBefore(jwtAuthenticationFilter()
                , UsernamePasswordAuthenticationFilter::class.java)
            .authorizeHttpRequests { authorize ->
                WHITE_LIST.forEach { authorize.requestMatchers(it).permitAll() }
                authorize.anyRequest().authenticated() }
            .build()
    }
    @Bean
    fun jwtAuthenticationFilter(): JwtAuthenticationFilter {
        return JwtAuthenticationFilter(jwtTokenProvider)
    }
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder() //bcrypt 사용
    }

}
